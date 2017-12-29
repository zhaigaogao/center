package learn.center.thinkInJava.unit18.demon03;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirFilter implements FilenameFilter{
	private Pattern pattern;
	/**
	 * 构造方法
	 * @param regex
	 */
	public DirFilter(String regex){
		pattern=Pattern.compile(regex);
	}
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}

}
