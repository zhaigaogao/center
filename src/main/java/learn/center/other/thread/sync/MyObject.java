package learn.center.other.thread.sync;

public class MyObject{
	
	synchronized public void methodA()
	{
		try {
			System.out.println("Thread begin !");
			System.out.println("当前线程是"+Thread.currentThread().getName());
			System.out.println("Thread end !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void methodB(){
		try {
			System.out.println("Thread begin !");
			System.out.println("当前线程是"+Thread.currentThread().getName());
			System.out.println("Thread end !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
