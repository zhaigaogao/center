package learn.center.other.thread.resume;

public class SynchronizedObject {
	synchronized public void printString(){
		System.out.println("begin");
		if(Thread.currentThread().getName().equals("zhai")){
			System.out.println("zhai线程永远被 suspend 了！");
			
			Thread.currentThread().suspend();
		}
		
		System.out.println("end");
	}
}
