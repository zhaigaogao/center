package learn.center.thinkInJava.unit10.demo03;

public class Demon03 {
	
	public Person person(){
		
		return new Person(){
			private String job="学生";
			
			public String out(){
				return job;
			}
		};
	}
	
	public static void main(String[] args) {
		Demon03 demon03 = new Demon03();
		
		Person person = demon03.person();
		System.out.println(person.toString());
	}
}
