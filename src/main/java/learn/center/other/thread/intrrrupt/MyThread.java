package learn.center.other.thread.intrrrupt;

public class MyThread extends Thread{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		for(int i=0;i<=500000;i++){
			if(this.interrupted()){
				System.out.println("已经停止了状态，我要退出了");
				break;
			}
			System.out.println("i=" + (i+i));
		}
	}
}
