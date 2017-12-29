package learn.center.other.thread.sync;

public class ThreadA extends Thread{
	private MyObject object;
	@Override
	public void run() {
		super.run();
		object.methodA();
	}
	
	public ThreadA(MyObject object){
		this.object = object;
	}
	
	
}
