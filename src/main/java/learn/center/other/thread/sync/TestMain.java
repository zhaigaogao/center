package learn.center.other.thread.sync;

public class TestMain {
	public static void main(String[] args) {
		MyObject object = new MyObject();
		ThreadA threadA = new ThreadA(object);
		threadA.setName("a");
		ThreadB threadB = new ThreadB(object);
		threadB.setName("b");
		threadA.start();
		threadB.start();
	}
}
