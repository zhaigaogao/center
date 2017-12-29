package learn.center.thinkInJava.unit05.Final;

public class Insert {
	private int i=9;
	protected int j;
	
	public Insert() {
		System.out.println("i = "+i+", j = "+j);
		j=39;
	}
	private static int x1 = printInit("static Insert.x1 inittialized");
	
	static int  printInit(String s){
		System.out.println(s);
		return 47;
	}
}
