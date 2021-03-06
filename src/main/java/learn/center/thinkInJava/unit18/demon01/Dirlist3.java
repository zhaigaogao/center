package learn.center.thinkInJava.unit18.demon01;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Dirlist3 {
	public static void main(final String[] args) {
		File path=new File(".");
		String[] list;
		if(args.length==0){
			list=path.list();
		}else {
			list=path.list(new FilenameFilter() {
				private Pattern pattern=Pattern.compile(args[0]);
				public boolean accept(File dir, String name) {
					// TODO Auto-generated method stub
					return pattern.matcher(name).matches();
				}
			});
		}
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		for(String item : list){
			System.out.println(item);
		}
	}
}
