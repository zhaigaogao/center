package learn.center.thinkInJava.unit21.learn01;

public class MoreBasicThread {
	public static void main(String[] args) {
		
		
		
		for(int i=0;i<=5;i++){
			new Thread(new Thread01()).start();
		}
		System.out.println("Waiting for LiftOff!");
	}
	
	/**
	 * 问题1：
	 * 同样是在循环中创建线程实体，
	 * 代码片段一执行的是创建实体后的start方法。由于时间片的调度不同
	 * 在输出结果中可以看到，对创建的线程调度的id结果是不一样的
	 * 
	 * 问题2:
	 * 线程调度中id是怎样被赋值的
	 * 要知道Thread01中id是final类型，一旦被初始化，线程的值将是不可改变的
	 * 所以问题就是线程的调度是怎么初始化值的。
	 */
}
