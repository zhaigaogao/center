package learn.center.thinkInJava.unit18.IOUtils;

import java.io.UnsupportedEncodingException;

/**
 * java在内存中对字符串进行字节的转换
 * @author zhaieryuan
 * @date 2017年9月25日 下午12:05:28
 */
public class InsideCode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String string = "你好啊，老翟，牛掰";
		
		byte[] byteArray = string.getBytes("UTF-8");
		System.out.println("byteArray = "+byteArray.toString());
		
		System.out.println("------------------------------------");
		String newString = new String(byteArray , "UTF-8");
		System.out.println(newString);
	}
}
