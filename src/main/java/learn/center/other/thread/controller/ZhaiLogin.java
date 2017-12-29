package learn.center.other.thread.controller;

public class ZhaiLogin extends Thread{
	@Override
	public void run() {
		super.run();
		LoginServlet.doPost("zhai", "aaa");
		System.out.println("ThreadId = "+this.currentThread().getId()+"ThreadName="+this.currentThread().getName());
	}
}
