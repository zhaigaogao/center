package learn.center.thinkInJava.unit21.learn01;

public class Demon {
	
	private static int taskCount=0;
	private  final int id=taskCount++;
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Demon demon = new Demon();
			System.out.println(demon.id);;
		}
	}
}
