package learn.center.thinkInJava.unit05.random;

import java.util.Random;

/**
 * @author Administrator
 *
 */
public class demon01 {
	public static void main(String[] args) {
		Random random = new Random();
		//random.setSeed(10);
		System.out.println(Math.round(Math.random()*10));
		System.out.println(random.nextInt());
	}
}
