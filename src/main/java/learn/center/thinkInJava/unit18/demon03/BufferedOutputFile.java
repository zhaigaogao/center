package learn.center.thinkInJava.unit18.demon03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class BufferedOutputFile {
	public static String write(String fileName,String content) throws IOException{
		BufferedReader in = new BufferedReader(new StringReader(content));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
		int lineCount=1;
		if(content!=null){
			out.print(lineCount++ + ":"+content);
		}
		out.close();
		in.close();
		return "success";
	}
	
	public static void main(String[] args) throws IOException {
		String content = BufferedInputFile.read("E:/EclipseWorkMybatisLearn/center/src/main/java/learn/center/thinkInJava/unit18/demon03/test.txt");
		String message = BufferedOutputFile.write("E:/EclipseWorkMybatisLearn/center/src/main/java/learn/center/thinkInJava/unit18/demon03/BasicFileOutput.txt.txt", content);
		System.out.println(message);
	}
}
