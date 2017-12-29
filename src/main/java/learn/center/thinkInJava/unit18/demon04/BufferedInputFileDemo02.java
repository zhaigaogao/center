package learn.center.thinkInJava.unit18.demon04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BufferedInputFileDemo02 {
	public static List<String> read(String filename) throws IOException{
		List<String> list = new ArrayList<String>();
		FileReader fileReader = new FileReader(filename);
		BufferedReader in = new BufferedReader(fileReader);
		String line;
		while((line=in.readLine())!=null){
			list.add(line);
		}
		in.close();
		return list;
	}
	public static void main(String[] args) throws IOException {
		List<String> list = read("E:/EclipseWorkMybatisLearn/center/src/main/java/learn/center/thinkInJava/unit18/demon03/test.txt");
		for(String item : list){
			System.out.println(item.toUpperCase());
		}
	}
}
