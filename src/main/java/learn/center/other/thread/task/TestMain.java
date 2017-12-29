package learn.center.other.thread.task;

public class TestMain {
	public static void main(String[] args) {
		Task task = new Task();
		MyThread01 thread01 = new MyThread01(task);
		thread01.start();
		
		MyThread02 thread02 = new MyThread02(task);
		thread02.start();
		
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long beginTime = CommonUtils.beginTime1;
		if(CommonUtils.beginTime2 < CommonUtils.beginTime1){
			beginTime =  CommonUtils.beginTime2;
		}
		
		long endTime = CommonUtils.endTime1;
		if(CommonUtils.endTime2 > CommonUtils.endTime1){
			endTime = CommonUtils.endTime2;
		}
		
		System.out.println("耗时： "+((endTime - beginTime)/1000)+"秒");
	}
}
