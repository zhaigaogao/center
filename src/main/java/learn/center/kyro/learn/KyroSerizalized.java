package learn.center.kyro.learn;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;









import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.CollectionSerializer;
import com.esotericsoftware.kryo.serializers.JavaSerializer;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import learn.center.other.onblog.varargus.Student;

/**
 * kyro序列化
 * @author zhaieryuan
 * @date 2017年10月9日 下午4:21:37
 */
public class KyroSerizalized implements Serializable{

	/** 
	 * 
	 */
	private static final long serialVersionUID = 5530581630234176476L;
	
	private static final Logger log = Logger.getLogger(KyroSerizalized.class);
	
	public static void main(String[] args) throws Exception {
		List<Student> students = new ArrayList<Student>();
		for (int i = 0; i < 10; i++) {
			Student student = new Student();
			student.setAge(Long.parseLong(String.valueOf(i)));
			student.setName("seriz:"+i);
			students.add(student);
		}
		/*System.out.println(students.toString());
		long startTime = System.currentTimeMillis();
		String serListString  = serializationList(students,Student.class);
		long endTime = System.currentTimeMillis()-startTime;
		System.out.println("耗时："+endTime+"毫秒");
		System.out.println(serListString);
		List<Student> students2 = deserializationList(serListString, Student.class);
		System.out.println(students2.toString());*/
		
		System.out.println(jserialize(students));
	}
	
	public static <T extends Serializable> String serializationSet(Set<T> obj, Class<T> clazz) {
        Kryo kryo = new Kryo();
        kryo.setReferences(false);
        kryo.setRegistrationRequired(true);
 
        CollectionSerializer serializer = new CollectionSerializer();
        serializer.setElementClass(clazz, new JavaSerializer());
        serializer.setElementsCanBeNull(false);
        kryo.register(HashSet.class, serializer);
 
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Output output = new Output(baos);
        kryo.writeObject(output, obj);
        output.flush();
        output.close();
 
        byte[] b = baos.toByteArray();
        try {
            baos.flush();
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        return new String(new Base64().encode(b));
    }
	
	
	@SuppressWarnings("unused")
	private static <T extends Serializable> String serializationList(List<T> obj, Class<T> clazz) {
	        Kryo kryo = new Kryo();
	        kryo.setReferences(false);
	        kryo.setRegistrationRequired(true);
	 
	        CollectionSerializer serializer = new CollectionSerializer();
	        serializer.setElementClass(clazz, new JavaSerializer());
	        serializer.setElementsCanBeNull(false);
	 
	        kryo.register(clazz, new JavaSerializer());
	        kryo.register(ArrayList.class, serializer);
	 
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        Output output = new Output(baos);
	        kryo.writeObject(output, obj);
	        output.flush();
	        output.close();
	 
	        byte[] b = baos.toByteArray();
	        try {
	            baos.flush();
	            baos.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	     return new String(new Base64().encode(b));
	 }
	 
	@SuppressWarnings({ "unchecked", "unused"})
    private static <T extends Serializable> List<T> deserializationList(String obj,Class<T> clazz) {
        Kryo kryo = new Kryo();
        kryo.setReferences(false);
        kryo.setRegistrationRequired(true);
 
        CollectionSerializer serializer = new CollectionSerializer();
        serializer.setElementClass(clazz, new JavaSerializer());
        serializer.setElementsCanBeNull(false);
 
        kryo.register(clazz, new JavaSerializer());
        kryo.register(ArrayList.class, serializer);
 
        ByteArrayInputStream bais = new ByteArrayInputStream(
                new Base64().decode(obj));
        Input input = new Input(bais);
        return (List<T>) kryo.readObject(input, ArrayList.class, serializer);
    }   
	
	@Deprecated
	public static String jserialize(Object obj) throws Exception{
		ObjectOutputStream oos = null ;
		ByteArrayOutputStream bos = null;
		try {
			log.info("开始序列化");
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			return bos.toString();
		} catch (IOException e) {
			throw new Exception(e);
		}finally{
			if(oos != null){
				try {
					oos.close();
					bos.close();
				} catch (IOException e2) {
				}
			}
		}
	}
	
}
