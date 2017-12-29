package learn.center.thinkInJava.unit10.InnerClass;

public class AnonymoueConstructor {
	public static Base getBase(int i){
		return new Base(i) {
			
			{
				System.out.println("");
			}
			@Override
			public void f() {
				// TODO Auto-generated method stub
				System.out.println("");
			}
		};
	}
}
