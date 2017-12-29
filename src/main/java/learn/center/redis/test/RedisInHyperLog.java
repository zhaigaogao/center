package learn.center.redis.test;

import redis.clients.jedis.Jedis;

public class RedisInHyperLog {
	public static void main(String[] args) {
		Jedis jedis=new Jedis("localhost");
		System.out.println("连接Redis成功！");
		jedis.del("zhai");
		jedis.del("zhai01");
		System.out.println("执行结果：");
		System.out.println(jedis.get("zhai")+"--"+jedis.get("zhai01"));
		System.out.println("*****************");
		jedis.pfadd("test", "case");
		
	}
}
