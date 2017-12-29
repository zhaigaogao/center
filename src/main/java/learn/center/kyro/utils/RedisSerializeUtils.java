package learn.center.kyro.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.GregorianCalendar;

import javolution.util.FastTable;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import de.javakaffee.kryoserializers.ArraysAsListSerializer;
import de.javakaffee.kryoserializers.CollectionsEmptyListSerializer;
import de.javakaffee.kryoserializers.CollectionsEmptyMapSerializer;
import de.javakaffee.kryoserializers.CollectionsEmptySetSerializer;
import de.javakaffee.kryoserializers.CollectionsSingletonListSerializer;
import de.javakaffee.kryoserializers.CollectionsSingletonMapSerializer;
import de.javakaffee.kryoserializers.CollectionsSingletonSetSerializer;
import de.javakaffee.kryoserializers.GregorianCalendarSerializer;
import de.javakaffee.kryoserializers.JdkProxySerializer;
import de.javakaffee.kryoserializers.SynchronizedCollectionsSerializer;
import de.javakaffee.kryoserializers.UnmodifiableCollectionsSerializer;
import de.javakaffee.kryoserializers.cglib.CGLibProxySerializer;
/**
 * Redis 序列化工具类（对象序列化+反序列化）
 * @author llp
 * @version 2017/3/23 11:00
 */
public class RedisSerializeUtils {
	
    public RedisSerializeUtils() {
    }
    
    
    /**
     * Kryo 对象的包装
     */
    private static class KryoHolder {
        private Kryo kryo;
        static final int BUFFER_SIZE = 1024;
        /**
         * 序列化输入办出的缓冲值
         */
        private Output output = new Output(BUFFER_SIZE, -1);
        private Input input = new Input();
        
        /**
         * 注册常用数据类型（kryo在序列化之前需要）
         * @param kryo
         */
        KryoHolder(Kryo kryo) {
            this.kryo = kryo;
            this.kryo.register(Arrays.asList("").getClass(), new ArraysAsListSerializer());
            this.kryo.register(Collections.EMPTY_LIST.getClass(), new CollectionsEmptyListSerializer());
            this.kryo.register(Collections.EMPTY_MAP.getClass(), new CollectionsEmptyMapSerializer());
            this.kryo.register(Collections.EMPTY_SET.getClass(), new CollectionsEmptySetSerializer());
            this.kryo.register(Collections.singletonList("").getClass(), new CollectionsSingletonListSerializer());
            this.kryo.register(Collections.singleton("").getClass(), new CollectionsSingletonSetSerializer());
            this.kryo.register(Collections.singletonMap("", "").getClass(), new CollectionsSingletonMapSerializer());
            this.kryo.register(GregorianCalendar.class, new GregorianCalendarSerializer());
            this.kryo.register(InvocationHandler.class, new JdkProxySerializer());
            // register CGLibProxySerializer, works in combination with the appropriate action in handleUnregisteredClass (see below)
            this.kryo.register(CGLibProxySerializer.CGLibProxyMarker.class, new CGLibProxySerializer());
            UnmodifiableCollectionsSerializer.registerSerializers(this.kryo);
            SynchronizedCollectionsSerializer.registerSerializers(this.kryo);
        }

    }

    /**
     * 对象池接口
     * @author llp
     */
    interface KryoPool {
        /**
         * 获取Kryo对象
         * @return
         */
        KryoHolder get();
        
        /**
         * 归还Kryo对象
         * @param kryo
         */
        void offer(KryoHolder kryo);
    }
    
    /**
     * 基于kryo序列化方案
     * 由于kryo创建的代价相对较高 ，这里使用空间换时间
     * 对KryoHolder对象进行重用
     */
    public static class KryoPoolImpl implements KryoPool {
    	private KryoPoolImpl() {}
    	
    	
        /**
         * default is 1500
         * online server limit 3K
         */
        private static int DEFAULT_MAX_KRYO_SIZE = 3000;
        
        /**
         * 线程安全的list
         */
        private final FastTable<KryoHolder> kryoFastTable = new FastTable<KryoHolder>().atomic();
        
        /**
         * 获取Kryo对象池的实例（单例）
         * @return 
         */
        public static KryoPool getInstance() {
            return Singleton.pool;
        }

        /**
         * 获取一个 KryoHolder 对象
         * @return
         */
        public KryoHolder get() {
        	// 从队列头部的弹出一个元素
            KryoHolder kryoHolder = kryoFastTable.pollFirst();      
            return kryoHolder == null ? creatInstnce() : kryoHolder;
        }

        /**
         * 创建一个新的Kryo对象
         * @return
         */
        public KryoHolder creatInstnce() {
            Kryo kryo = new Kryo();
            kryo.setReferences(false);
            return new KryoHolder(kryo);
        }

        /**
         * 释放的对象时将其插入到队列的尾部
         * @param kryoHolder
         */
        public void offer(KryoHolder kryoHolder) {
            kryoFastTable.addLast(kryoHolder);
        }

        /**
         * 创建一个单例对象
         */
        private static class Singleton {
            private static final KryoPool pool = new KryoPoolImpl();
        }
    }
    

    /**
     * 将对象序列化为字节数组
     * @param obj
     * @return 字节数组
     * @throws RedisCacheException
     */
    public static byte[] kryoSerialize(Object obj) throws Exception {
    	KryoHolder kryoHolder = null;
        //if (obj == null) throw new RedisCacheException("obj can not be null");
        try {
            kryoHolder = KryoPoolImpl.getInstance().get();
            //clear 每次调用的时候  重置
            kryoHolder.output.clear();  
            kryoHolder.kryo.writeClassAndObject(kryoHolder.output, obj);
            return kryoHolder.output.toBytes();
        } catch (Exception e) {
            throw new Exception("Serialize obj exception");
        } finally {
            KryoPoolImpl.getInstance().offer(kryoHolder);
            // 便于GC
            obj = null; 
        }
    }


    /**
     * 将字节数组反序列化为对象
     *
     * @param bytes 字节数组
     * @return object
     * @throws RedisCacheException
     */
    public static Object kryoDeserialize(byte[] bytes) throws Exception {
    	KryoHolder kryoHolder = null;
        if (bytes == null) throw new Exception("bytes can not be null");
        try {
            kryoHolder = KryoPoolImpl.getInstance().get();
            kryoHolder.input.setBuffer(bytes, 0, bytes.length);//call it ,and then use input object  ,discard any array
            return kryoHolder.kryo.readClassAndObject(kryoHolder.input);
        } catch (Exception e) {
            throw new Exception("Deserialize bytes exception");
        } finally {
            KryoPoolImpl.getInstance().offer(kryoHolder);
            bytes = null;
        }
    }


    /**
     * 将字节数组反序列化为对象
     * @param bytes 字节数组
     * @return object
     * @throws RedisCacheException
     */
    public static Object kryoDeserialize(byte[] bytes, int length) throws Exception {
        KryoHolder kryoHolder = null;
        if (bytes == null) throw new Exception("bytes can not be null");
        try {
            kryoHolder = KryoPoolImpl.getInstance().get();
            kryoHolder.input.setBuffer(bytes, 0, length);
            return kryoHolder.kryo.readClassAndObject(kryoHolder.input);
        } catch (Exception e) {
            throw new Exception("Deserialize bytes exception");
        } finally {
            KryoPoolImpl.getInstance().offer(kryoHolder);
            bytes = null;
        }
    }


    /**
     * jdk原生序列化
     * @param obj
     * @return
     */
    @Deprecated
    public static byte[] jserialize(Object obj) throws Exception{
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new Exception(e);
        } finally {
            if (oos != null)
                try {
                    oos.close();
                    baos.close();
                } catch (IOException e) {
                }
        }
    }

    /**
     * Java原生反序列化
     * @param bits
     * @return
     */
    @Deprecated
    public static Object jdeserialize(byte[] bits) throws Exception{
        ObjectInputStream ois = null;
        ByteArrayInputStream bais = null;
        try {
            bais = new ByteArrayInputStream(bits);
            ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (ois != null)
                try {
                    ois.close();
                    bais.close();
                } catch (IOException e) {
                }
        }
    }

}
