package learn.center.reflective;

import learn.center.other.onblog.varargus.Student;

public class Learn01 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Student student = new Student();
		student.setAge(Long.valueOf(23));
		student.setName("翟二远");
		System.out.println(student.getClass().getName());
		
		Class student2 = Class.forName(Student.class.getName());
		Class student3 = Student.class;
		Object bean = student2.newInstance();
		
		System.out.println(Student.class.getSimpleName());
		
		System.out.println(Student.class.getName());
	}
}
