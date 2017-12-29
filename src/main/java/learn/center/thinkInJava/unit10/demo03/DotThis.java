package learn.center.thinkInJava.unit10.demo03;

public class DotThis {
	
	void f() {
		System.out.println("DotThis.f()");
	};
	
	public class Inner{
		public DotThis outer(){
			return DotThis.this;
		}
	}
}
