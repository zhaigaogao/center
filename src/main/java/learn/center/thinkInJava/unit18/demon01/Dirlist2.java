package learn.center.thinkInJava.unit18.demon01;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Dirlist2 {
	public static FilenameFilter filter(final String regex){
		return new FilenameFilter() {
			private Pattern pattern=Pattern.compile(regex);
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return pattern.matcher(name).matches();
			}
		};
	}
	public static void main(String[] args) {
		File path=new File("./src/main/java/learn/center/thinkInJava");
		String[] list;
		if(args.length==0){
			list=path.list();
		}else {
			list=path.list(filter(args[0]));
		}
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		for(String item : list){
			System.out.println(item);
		}
	}
}
