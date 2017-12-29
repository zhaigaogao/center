package learn.center.thinkInJava.unit18.demon03;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
	public static void main(String[] args) throws IOException {
		StringReader sr = new StringReader(BufferedInputFile.
				read("E:/EclipseWorkMybatisLearn/center/src/main/java/learn/center/thinkInJava/unit18/demon03/test.txt"));
		int c;
		while((c=sr.read())!=-1){
			System.out.println((char)c);
		}
		
		String s = "fs123fdsa";//String变量 

		byte b[] = s.getBytes();//String转换为byte[] 

		String t = new String(b);//bytep[]转换为String
	}
}
