package learn.center.other.StackTraceTest;


import java.util.ArrayList;
import java.util.List;

import learn.center.other.onblog.varargus.Student;


public class Demon{
	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		List<PrimaryStudent> primaryStudents = new ArrayList<PrimaryStudent>();
		for(int i=0;i<=10;i++){
			if(i%2==0){
				Student student = new Student();
				student.setAge(Long.valueOf(i));
				student.setName("demon"+i);
				students.add(student);
			}else{
				PrimaryStudent primaryStudent  = new PrimaryStudent();
				primaryStudent.setAge(Long.valueOf(i));
				primaryStudent.setAreaName("江苏省"+i);
				primaryStudent.setClassCode(String.valueOf(i));
				primaryStudent.setClassName("低年级");
				primaryStudent.setName("demon"+i);
				primaryStudents.add(primaryStudent);
			}
		}
		
		students.addAll(primaryStudents);
		
		System.out.println(students.toString());
	}
}
