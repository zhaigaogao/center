package learn.center.thinkInJava.unit18.IOUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * java 内部编码装换实体类
 * @author zhaieryuan
 * @date 2017年9月25日 上午10:35:02
 */
public class StreamCode {
	public static void main(String[] args) throws IOException {
		String file = "C:/Users/Administrator/Desktop/mybatisXML/stream.txt";
		String charset ="GB2312";
		FileOutputStream outputStream = new FileOutputStream(file,true);
		
		@SuppressWarnings("resource")
		OutputStreamWriter writer = new OutputStreamWriter(outputStream,charset);
		try {
			writer.write("操你妹，你个傻逼！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("内部异常");
		}finally{
			writer.close();
		}
		
		//读取字节转换成字符
		
	}
}
