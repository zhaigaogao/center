package learn.center.other.thread.controller;

public class BLogin extends Thread{
	
	
	@Override
	public void run() {
		super.run();
		
		LoginServlet.doPost("B", "bbbbbb");
		
		System.out.println("ThreadId = "+this.currentThread().getId()+"ThreadName="+this.currentThread().getName());
	}
}
