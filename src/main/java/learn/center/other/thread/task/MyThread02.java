package learn.center.other.thread.task;

public class MyThread02 extends Thread{
	private Task task;
	public MyThread02(Task task) {
		super();
		this.task = task;
	}
	
	@Override
	public void run() {
		super.run();
		CommonUtils.beginTime2 = System.currentTimeMillis();
		task.doLongTimeTask();
		
		CommonUtils.endTime2 = System.currentTimeMillis();
	}
}
