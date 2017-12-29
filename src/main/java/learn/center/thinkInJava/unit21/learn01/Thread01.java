package learn.center.thinkInJava.unit21.learn01;

public class Thread01 implements Runnable{

	protected int countDown=10;
	
	private static int taskCount=0;
	
	private final int id=taskCount++;
	 
	public Thread01(){
		
	}
    public Thread01(int countDown){
		this.countDown=countDown;
	}
    public String status(){
    	if(taskCount==0){
    		System.out.println(taskCount);
    	}else if(taskCount==0){
    		System.out.println(taskCount);
    	}else if(taskCount==1){
    		System.out.println(taskCount);
    	}else if(taskCount==2){
    		System.out.println(taskCount);
    	}else if(taskCount==3){
    		System.out.println(taskCount);
    	}else if(taskCount==4){
    		System.out.println(taskCount);
    	}else if(taskCount==5){
    		System.out.println(taskCount);
    	}else if(taskCount==6){
    		System.out.println(taskCount);
    	}
    	return "#"+id+"("+(countDown>0?countDown:"Thread01!")+"),"+"taskCount = "+taskCount;
    }
	public void run() {
		// TODO Auto-generated method stub
		while(countDown-->0){
			System.out.println(status());
			Thread.yield();
		}
	}
	
	public static void main(String[] args) {
		Thread01 launch = new Thread01();
		launch.run();
	}
}
