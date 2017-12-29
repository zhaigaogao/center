package learn.center.other.thread.controller;

public class LoginServlet {
	private static String usernameRef;
	private static String passwordRef;
	
	/**
	 * 构造方法
	 * 
	 * @author zhaieryuan
	 * @date 2017年12月4日 上午11:10:49
	 */
	public LoginServlet(){
		System.out.println("初始化Servlet模拟器");
		
	}
	
	synchronized public static void doPost(String username,String password){
		try {
			usernameRef = username;
			if(username.equals("zhai")){
				Thread.sleep(5000);
			}
			passwordRef = password;
			System.out.println("username = "+usernameRef+" password =  "+passwordRef);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("LoginServlet->doPost:启动异常");
		}
	}
}
