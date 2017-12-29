package learn.center.thinkInJava.unit05.Final;

public class TestMain {
	public static void main(String[] args) {
		FinalClass finalClass1 = new FinalClass();
		Object object=finalClass1;
		FinalClass finalClass2=finalClass1;
		System.out.println(object.toString());
		System.out.println(finalClass2.toString());
		System.out.println("***************************");
		children tets = new children();
		System.out.println(tets.parentMethod());
		System.out.println("***************************");
		
		//private int k = printInit()
	}
}
