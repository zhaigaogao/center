package learn.center.other.thread.tickets;

public class MainClass {

	public static void main(String[] args) {
		Station station1=new Station("窗口1");
		Station station2=new Station("窗口2");
		Station station3=new Station("窗口3");
		station3.start();
		station1.start();
		station2.start();
		
	}

}
