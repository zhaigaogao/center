package learn.center.thinkInJava.unit18.demon03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class BasicFileOutput {
	static String fileString="E:/EclipseWorkMybatisLearn/center/src/main/java/learn/center/thinkInJava/unit18/demon03/BasicFileOutput.txt";
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(
				new StringReader(BufferedInputFile.read("E:/EclipseWorkMybatisLearn/center/src/main/java/learn/center/thinkInJava/unit18/demon03/test.txt")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileString)));
		int lineCount=1;
		String string;
		while((string=bf.readLine())!=null){
			out.print(lineCount++ + ":"+string);
		}
		out.close();
	}
}
