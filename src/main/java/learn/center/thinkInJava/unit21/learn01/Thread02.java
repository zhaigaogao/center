package learn.center.thinkInJava.unit21.learn01;

public class Thread02 implements Runnable{

	public static int beans=20;
	
	public void run(int beans) {
		this.beans=beans;
	}
	public void run() {
		for (int i = 0; i < beans; beans--) {
			System.out.println("beans="+beans);
		}
	}
	public static void main(String[] args) {
		Thread02 thread02=new Thread02();
		Thread02 thread03=new Thread02();
		thread02.run();
		thread03.run();
	}
}
