package learn.center.other.oncsnd;

import java.util.Iterator;

import com.alibaba.fastjson.JSONArray;

public class TteratorUse {
	public static void main(String[] args) {
		JSONArray array = new JSONArray();
		array.add("132302");
		array.add("122301");
		
		try {
			Iterator<Object> iterator = array.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next().toString().substring(0,2)+"0000");
				System.out.println(iterator.next().toString().substring(0,4)+"00");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Iterator迭代器：循环中不能用两次（含）的next（）方法。");
		}
	}
}
