package learn.center.thinkInJava.unit18.demon04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class BufferedInputFileDemo01 {
	public static LinkedList<String> read(String filename) throws IOException{
		FileReader fileReader = new FileReader(filename);
		BufferedReader in = new BufferedReader(fileReader);
		String line;
		StringBuilder sb = new StringBuilder();
		LinkedList<String> list = new LinkedList<String>();
		while((line = in.readLine())!=null){
			list.add(line);
			sb.append(line);
		}
		in.close();
		return list;
	}
	
	public static void main(String[] args) throws IOException {
		LinkedList<String> linkedList = read("E:/EclipseWorkMybatisLearn/center/src/main/java/learn/center/thinkInJava/unit18/demon03/test.txt");
		for(String item : linkedList){
			System.out.println(item);
		}
	}
}
