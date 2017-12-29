package learn.center.other.StackTraceTest;

import java.util.Scanner;

public class StackTraceTest {
	
	public static int factorial(int n){
		System.out.println("工厂方法 : "+n);
		Throwable throwable = new Throwable();
		StackTraceElement[] frames = throwable.getStackTrace();
		for(StackTraceElement f : frames){
			System.out.println(f);
		}
		
		int r;
		if(n<=1){
			r=1;
		}else {
			r=n*factorial(n-1);
		}
		System.out.println("return "+r);
		return r;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("----------请输出：n------------");
		int n=in.nextInt();
		factorial(n);
		System.out.println("-----------执行结束------------");
	}
}
