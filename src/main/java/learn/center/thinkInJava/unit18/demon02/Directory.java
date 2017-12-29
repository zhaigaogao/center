package learn.center.thinkInJava.unit18.demon02;

import java.io.File;
import java.io.FilenameFilter;

public class Directory {
	public static File[] local(File dir,String regex){
		return dir.listFiles(new FilenameFilter() {
			
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return false;
			}
		});
	}
}
