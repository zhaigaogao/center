package learn.center.redis.test;

import learn.center.other.onblog.varargus.Student;

public class SingleTon {
	private static final Student student = new Student();
	
	public static void main(String[] args) {
		long current = System.currentTimeMillis();
		student.setAge(Long.parseLong("12"));
		student.setName("债高原红");
		
		
		Student student = new Student();
		student.setAge(Long.parseLong("13"));
		student.setName("债高原红14");
		
		System.out.println(student.toString());
		long end = System.currentTimeMillis();
		System.out.println(end-current);
	}
}
