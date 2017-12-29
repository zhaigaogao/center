package learn.center.other.StackTraceTest;

public class Demon03 {
	
	static{
		System.out.println("调用静态代码块-------------1");
	}
	
	public Demon03(){
		System.out.println("调用构造方法-------------2");
	}
	
	public static void method(){
		System.out.println("调用静态方法-------------3");
	}
	
	public static void main(String[] args) {
		System.out.println("------------start------------");
		Demon03.method();
		System.out.println("-------------end-------------");
	}
}
