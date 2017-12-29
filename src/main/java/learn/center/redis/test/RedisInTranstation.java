package learn.center.redis.test;

import redis.clients.jedis.Jedis;

public class RedisInTranstation {
	public static void main(String[] args) {
		Jedis jedis=new Jedis("localhost");
		jedis.multi();
		jedis.lpush("test", "zhai");
		/**
		 * 
		 */
		jedis.save();
	}
}
