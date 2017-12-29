package learn.center.other.thread.yield;

public class TestMain {
	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.start();
		System.out.println("main end !");
	}
}
