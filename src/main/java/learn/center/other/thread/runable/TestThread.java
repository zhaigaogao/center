package learn.center.other.thread.runable;

public class TestThread {
	public static void main(String[] args) {
		
		MyThread01 myThread01 = new MyThread01();
		
		Thread a = new Thread(myThread01,"A");
		Thread b = new Thread(myThread01,"B");
		Thread c = new Thread(myThread01,"C");
		Thread d = new Thread(myThread01,"D");
		a.start();
		b.start();
		c.start();
		d.start();
	}
}
