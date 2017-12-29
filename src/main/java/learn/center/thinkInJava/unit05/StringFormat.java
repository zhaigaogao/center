package learn.center.thinkInJava.unit05;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringFormat {
	public static void main(String[] args) {
		System.out.println(String.format("%010d", 25));

		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		System.out.println(sdf.format(new Date()));
		Integer mmInteger=Integer.valueOf(sdf.format(new Date()));
		System.out.println(mmInteger);
	}
}
