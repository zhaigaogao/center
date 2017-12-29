package learn.center.thinkInJava.unit11.demo1;

import java.util.HashMap;
import java.util.Map;

public class LearnForMap {
	public static void main(String[] args) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("zhai01-K", "zhai01-V");
		params.put("zhai02-K", "zhai02-V");
		params.put("zhai03-K", "zhai03-V");
		params.put("zhai04-K", "zhai04-V");
		params.put("zhai05-K", "zhai05-V");
		System.out.println("输出关于Map集合：");
		for (@SuppressWarnings("rawtypes") Map.Entry entry : params.entrySet()) {
			System.out.println("Key="+entry.getKey()+" ,Value="+entry.getValue());
		}
	}
}
