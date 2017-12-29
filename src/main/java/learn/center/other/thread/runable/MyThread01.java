package learn.center.other.thread.runable;

public class MyThread01 extends Thread{
	
	@SuppressWarnings("unused")
	private int count = 5;
	private String key="aa";
	@Override
	public void run() {
		super.run();
		
		synchronized (key) {
			count--;
			System.out.println("由"+this.currentThread().getName()+" 计算，count = "+count);
		}
	}
	
	/**
	 *  synchronized 可以用钥匙进行锁，也可以对方法活代码片段进行锁
	 * @author zhaieryuan
	 * @date 2017年12月4日 上午10:49:41
	 */
	synchronized public void run2() {
		super.run();
		count--;
		System.out.println("由"+this.currentThread().getName()+" 计算，count = "+count);
	}
}
