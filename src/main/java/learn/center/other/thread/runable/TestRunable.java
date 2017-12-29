package learn.center.other.thread.runable;

public class TestRunable {
	public static void main(String[] args) {
		
		MyRunnable myRunnable = new MyRunnable();
		System.out.println("启动main方法");
		
		Thread thread = new Thread(myRunnable,"zhai");
		thread.start();
		System.out.println("thread="+thread.getName());
		myRunnable.run();
	}
}
