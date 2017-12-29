package learn.center.thinkInJava.unit05.Array;

public class Demon01 {
	
	public Demon01(String[] params) {
		for (String string : params) {
			System.out.println(string);
		}
	}
	
	public static void main(String[] args) {
		String[] params={"a","b","c"};
		Demon01 demon01 = new Demon01(params);
		System.out.println(demon01.toString());
		
		
		System.out.println("------------------");
		
		Demon01[] classArray={new Demon01(params),new Demon01(params),new Demon01(params)};
		for (Demon01 demon012 : classArray) {
			System.out.println(demon012.toString());
		}
	}
}

