package learn.center.other.thread.controller;

public class TestMain {
	public static void main(String[] args) {
		
		ZhaiLogin zhaiLogin = new ZhaiLogin();
		zhaiLogin.start();
		System.out.println("Zhai isAlive = " + zhaiLogin.isAlive());
		BLogin bLogin = new BLogin();
		bLogin.start();
		System.out.println("bLogin isAlive = " + bLogin.isAlive());
	}
}
