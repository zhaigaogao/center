package learn.center.redis.utils;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
  

public class JedisUtils {
	/**
	 * @author zhaieryuan
	 * @see 创建类型引用RTTI标准获取类对象信息，实现log日志的记录
	 * @describe getClass=JedisUtils.class
	 */
	protected Logger log = LoggerFactory.getLogger(getClass());
	
	protected Logger zhaiLogger=LoggerFactory.getLogger(JedisUtils.class);
	//创建内部构造函数:无参构造
	private JedisUtils(){
		
	}
	
	private static Map<String,JedisPool> maps  = new HashMap<String,JedisPool>();
	
	/**
	 * 获取连接池，返回连接池实例对象
	 */
	private static JedisPool getJedisPool(String ip,int port){
		String key = ip+":" +port;
		JedisPool pool = null;
		if(!maps.containsKey(key)){
			JedisPoolConfig config=new JedisPoolConfig();
//			config.setMaxActive(RedisConfig.getMaxactive());  
//            config.setMaxIdle(RedisConfig.getMaxidle());  
//            config.setMaxWait(RedisConfig.getMaxwait());  
            config.setTestOnBorrow(true);  
            config.setTestOnReturn(true); 
		}
		return null;
	}
}
