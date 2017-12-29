package learn.center.other.thread.volatil;

public class Demo01 {
	private boolean isContinuePrint = true;
	
	public boolean isContinuePrint(){
		return isContinuePrint;
	}
	
	public void setPrintStringMethod(boolean isContinuePrint){
		this.isContinuePrint = isContinuePrint;
	}
	
	public void printStringMethod(){
		try {
			while(isContinuePrint == true){
				System.out.println("run printStringMethod threadName="+Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
