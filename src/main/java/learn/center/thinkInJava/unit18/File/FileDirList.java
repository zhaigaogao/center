package learn.center.thinkInJava.unit18.File;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileDirList {
	public static List<String> FileList(){
		List<String> list = new ArrayList<String>();
		File file = new File(".");
		String arry[] = file.list(new DirFilter(""));
		for(String item : arry){
			list.add(item);
		}
		return list;
	}
	
	public static List<File> FilesList(){
		List<File> list = new ArrayList<File>();
		File file = new File(".");
		File[] arry = file.listFiles(new DirFileFilter(""));
		for(File item : arry){
			list.add(item);
		}
		return list;
	}
}
