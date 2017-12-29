package learn.center.other.thread.volatil;

public class TestMain {
	public static void main(String[] args) {
		Demon02 printString = new Demon02();
		printString.printStringMethod();
		System.out.println("我要停止她！ stopThread = "+Thread.currentThread().getName());
		
		System.out.println("开始执行false结束当前的循环");
		printString.setIsContinuePrint(false);
	}
}
