package learn.center.thinkInJava.unit18.demon03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class BufferedInputFile {
	public static String read(String fileName) throws IOException{
		BufferedReader bf = new BufferedReader(new FileReader(fileName));
		String string;
		StringBuffer sb = new StringBuffer();
		LinkedList<String> list = new LinkedList<String>();
		Set<String> set = new HashSet<String>();
		while ((string = bf.readLine())!=null) {
			sb.append(string+"\n");
			list.add(string);
			set.add(string);
		}
		bf.close();
		return sb.toString();
	}
	
	public static LinkedList<String> readlist(String fileName) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader(fileName));
		LinkedList<String> list = new LinkedList<String>();
		String string;
		while((string = bf.readLine())!=null){
			list.add(string);
		}
		bf.close();
		return list;
	}
	
	public static Set<String> readSet(String fileName) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader(fileName));
		Set<String> set = new HashSet<String>();
		String string;
		while((string = bf.readLine())!=null){
			set.add(string);
		}
		bf.close();
		return set;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(read("E:/EclipseWorkMybatisLearn/center/src/main/java/learn/center/thinkInJava/unit18/demon03/test.txt"));
		System.out.println("----------------------");
		LinkedList<String> list=readlist("E:/EclipseWorkMybatisLearn/center/src/main/java/learn/center/thinkInJava/unit18/demon03/test.txt");
		for (int i = list.size()-1; i >=0; i--) {
			System.out.println(list.get(i));
		}
		System.out.println("-----------------------");
		Set<String> set = readSet("E:/EclipseWorkMybatisLearn/center/src/main/java/learn/center/thinkInJava/unit18/demon03/test.txt");
		System.out.println(set.toString());
	}
}
