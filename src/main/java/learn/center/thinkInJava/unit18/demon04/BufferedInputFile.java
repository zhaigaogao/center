package learn.center.thinkInJava.unit18.demon04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * javaIO缓冲输入文件
 * @author Administrator
 * @deprecated 如果想要打开一个文化部用于字符输入，可以使用以String或File对象作为文化部名的FileInputStreamReader
 * 。为了提高速度，我们希望对那个文件进行缓冲，那么我们将所产生的引用传给一个BufferedReader构造器。由于BufferedReader也
 * 只提供readline（）方法，所以这是我们的最终对象和进行读取的解集
 *
 */
public class BufferedInputFile {
	
	public static String read(String filename) throws IOException{
		FileReader fileReader = new FileReader(filename);
		BufferedReader in = new BufferedReader(fileReader);
		String line;
		StringBuilder sb = new StringBuilder();
		while((line=in.readLine())!=null){
			sb.append(line);
			System.out.println(line);
		}
		in.close();
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		String content = read("E:/EclipseWorkMybatisLearn/center/src/main/java/learn/center/thinkInJava/unit18/demon03/test.txt");
		System.out.println(content);
	}
}
