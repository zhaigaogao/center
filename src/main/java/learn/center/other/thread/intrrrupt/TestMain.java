package learn.center.other.thread.intrrrupt;

public class TestMain {
	public static void main(String[] args) {
		try {
			MyThread myThread = new MyThread();
			
			myThread.start();
			Thread.sleep(2000);
			myThread.interrupt();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
 