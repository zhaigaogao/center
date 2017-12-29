package learn.center.other.thread.resume;

public class TestMain02 {
	public static void main(String[] args) {
		
		try {
			
			final SynchronizedObject object = new SynchronizedObject();
			
			Thread thread01 = new Thread(){
				public void run() {
					object.printString();
				};
			};
			thread01.setName("zhai");
			thread01.start();
			
			Thread.sleep(2000);
			Thread thread02 = new Thread(){
				public void run() {
					
					System.out.println("thread02 启动了，但是进入不了printString方法，只打印了一个begin!");
					
					System.out.println("因为printSting方法被zhai线程锁定，并且永远的suspend暂停了！");
					object.printString();
				};
			};
			thread02.setName("zhai");
			thread02.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
