package learn.center.thinkInJava.unit18.demon03;

import java.io.File;
import java.util.Arrays;

public class DirList {
	public static void main(String[] args) {
		File path = new File("src");
		String[] list;
//		if(args.length==0){
//			list=path.list();
//		}else {
//			list=path.list(new DirFilter(args[0]));
//		}
		list=path.list();
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}
}
