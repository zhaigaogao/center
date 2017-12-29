package learn.center.other.thread.resume;

public class TestMain {
	public static void main(String[] args) {
		try {
			MyThread myThread = new MyThread();
			myThread.start();
			Thread.sleep(5000);
			
			//A段
			myThread.suspend();
			System.out.println("A= " + System.currentTimeMillis() + " i=" + myThread.getI());
			Thread.sleep(5000);
			System.out.println("A= " + System.currentTimeMillis() + " i=" + myThread.getI());
			
			
			//B
			myThread.suspend();
			System.out.println("B= " + System.currentTimeMillis() + " i=" + myThread.getI());
			Thread.sleep(5000);
			System.out.println("B= " + System.currentTimeMillis() + " i=" + myThread.getI());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
