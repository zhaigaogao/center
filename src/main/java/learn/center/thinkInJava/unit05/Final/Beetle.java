package learn.center.thinkInJava.unit05.Final;

public class Beetle extends Insert{
	private int k=printInit("Beet.k initialized");
	
	public Beetle(){
		System.out.println("k = " + k);
		System.out.println("j = "+j);
	}
	private static int x2=printInit("static Beetle.x2 initialized");
	
	public static void main(String[] args) {
		System.out.println("Beetle constructor");
		Beetle beetle =new Beetle();
	}
}
