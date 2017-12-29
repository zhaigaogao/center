package learn.center.kyro.learn;

import java.util.ArrayList;
import java.util.List;

import learn.center.kyro.utils.RedisSerializeUtils;
import learn.center.other.onblog.varargus.Student;

public class TestMemorySer {
	public static void main(String[] args) throws Exception {
		List<Student> students = new ArrayList<Student>();
		for (int i = 0; i < 10; i++) {
			Student student = new Student();
			student.setAge(Long.parseLong(String.valueOf(i)));
			student.setName("seriz:"+i);
			students.add(student);
		}
		System.out.println(students.toString());
		long startTime = System.currentTimeMillis();
		byte[] seriliazaVByte = RedisSerializeUtils.kryoSerialize(students);
		long endTime = System.currentTimeMillis()-startTime;
		System.out.println("耗时："+endTime+"毫秒");
		System.out.println(seriliazaVByte);
		
	}
}
