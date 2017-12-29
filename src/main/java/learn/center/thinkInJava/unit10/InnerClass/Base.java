package learn.center.thinkInJava.unit10.InnerClass;

/**
 * 在匿名内部类中进行创建构造方法
 * @author Administrator
 *
 */
abstract class Base {
	
	public Base(int i){
		System.out.println("Base 构造函数  constructor i = "+i);
	}
	
	public abstract void f();
}
