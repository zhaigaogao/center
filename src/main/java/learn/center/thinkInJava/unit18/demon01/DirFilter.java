package learn.center.thinkInJava.unit18.demon01;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;


public class DirFilter implements FilenameFilter{
	private Pattern pattern;
	
	public DirFilter(String regex){
		pattern=Pattern.compile(regex);
	}
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return pattern.matcher(name).matches();
	}
	
}
