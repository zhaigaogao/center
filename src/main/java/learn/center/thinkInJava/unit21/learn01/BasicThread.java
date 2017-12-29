package learn.center.thinkInJava.unit21.learn01;

public class BasicThread{
	public static void main(String[] args) {
		Thread thread = new Thread(new Thread01());
		thread.start();
		System.out.println("Waiting for LiftOff!");
	}
}
