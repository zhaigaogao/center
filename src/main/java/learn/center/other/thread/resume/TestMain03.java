package learn.center.other.thread.resume;

public class TestMain03 {
	public static void main(String[] args) {
		
		Thread thread = new Thread(){
			public int i=0;
			public void run() {
				while(true){
					i++;
					System.out.println("i="+1);
				}
			};
		};
		thread.start();
		System.out.println("main end !");
	}
}
