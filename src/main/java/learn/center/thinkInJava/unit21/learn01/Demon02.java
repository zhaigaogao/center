package learn.center.thinkInJava.unit21.learn01;

public class Demon02 {
	
	private int taskCount ; 
	
	/**
	 * 创建构造方法
	 * @author zhaieryuan
	 * @date 2017年9月18日 下午5:00:05
	 */
	public Demon02() {
		System.out.println("我是构造方法啊");
		//Demon02 demon02 = new Demon02();
	}
	
	/**
	 * 创建类的静态快资源
	 * 
	 */
	static{
	    int taskCount = 4;
		
		int id = taskCount++;
		System.out.println("这是我的静态快！");
		System.out.println(id);
	}
	public static void main(String[] args) {
		Demon02 demon02 =new Demon02();
		System.out.println(demon02.taskCount);
	}
}
