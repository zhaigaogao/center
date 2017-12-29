package learn.center.other.thread.task;

public class MyThread01 extends Thread{
	private Task task;
	public MyThread01(Task task) {
		super();
		this.task = task;
	}
	@Override
	public void run() {
		super.run();
		
		CommonUtils.beginTime1 = System.currentTimeMillis();
		task.doLongTimeTask();
		CommonUtils.endTime1 =  System.currentTimeMillis();
	}
}
