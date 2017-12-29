package learn.center.thinkInJava.unit17.demo01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FillingList {
	public static void main(String[] args) {
		List<StringAdress> list=new ArrayList<StringAdress>(
				Collections.nCopies(4, new StringAdress("Hello")));
		System.out.println(list);
		System.out.println("******************");
		System.out.println("listSize="+list.size());
		System.out.println("******************");
		Collections.fill(list, new StringAdress("Word"));
		System.out.println(list);
	}
}
