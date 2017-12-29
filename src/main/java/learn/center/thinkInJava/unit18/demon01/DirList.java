package learn.center.thinkInJava.unit18.demon01;

import java.io.File;
import java.util.Arrays;

public class DirList {
	public static void main(String[] args) {
		File path=new File("./src/main/java/learn/center/thinkInJava");
		System.out.println(path.toPath());
		String[] list;
		System.out.println(args.length);
		if(args.length==0){
			list=path.list();
		}else {
			list=path.list(new DirFilter(args[0]));
		}
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : list) {
			System.out.println(dirItem);
		}
	}
}
