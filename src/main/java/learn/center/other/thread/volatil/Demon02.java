package learn.center.other.thread.volatil;

public class Demon02 implements Runnable{
	
	private boolean isContinuePrint = true;
	public boolean  Demon02() {
		return isContinuePrint;
	}
	
	public void setIsContinuePrint(boolean isContinuePrint){
		this.isContinuePrint = isContinuePrint;
	}
	
	public void printStringMethod(){
		try {
			while (isContinuePrint == true) {
				System.out.println("return printStringMethod threadName= "+Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		printStringMethod();
	}

}
