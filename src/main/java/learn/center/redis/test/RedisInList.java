package learn.center.redis.test;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;

public class RedisInList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jedis jedis=new Jedis("10.1.0.99",6379);
		
		System.out.println("连接成功！Q");
		jedis.lpush("zhai01", "123");
		jedis.lpush("zhai01", "456");
		jedis.lpush("zhai01", "789");
		
		List<String> list=new ArrayList<String>();
		list=jedis.lrange("zhai01", 0, 5);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Redis List :"+list.get(i));
		}
		System.out.println("*******************");
		jedis.pfadd("case", "哈哈");
		System.out.println(jedis.pfcount("case"));;
		System.out.println("*******************");
	}

}
