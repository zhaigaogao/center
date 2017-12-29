package learn.center.redis.test;

import redis.clients.jedis.Jedis;
/**
 * 
 * Title: RedisJava.java 
 * @discription {jedis自增序列}
 * @author zhaieryuan    
 * @created 2017年4月13日 下午5:37:35
 */
public class RedisJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//连接本地的 Redis 服务
	     Jedis jedis = new Jedis("10.1.0.42");
	     System.out.println("Connection to server sucessfully");
	     //查看服务是否运行
	     System.out.println("Server is running: "+jedis.ping());
	     
	     jedis.set("increment", "001");
	     jedis.incr("increment");
	     String increment=jedis.get("increment");
	     System.out.println(increment);
	}

}
