package learn.center.thinkInJava.unit14.demo1;

import java.util.Arrays;
import java.util.List;


public class Test {
	public static void main(String[] args) {
		List<Shape> shapes=Arrays.asList(new Circle(),new Square(),new Triangle());
		for(Shape shape : shapes){
			shape.draw();
		}
		System.out.println("----------------------------------");
		System.out.println(Circle.class);
		System.out.println("----------------------------------");
		String unKnoName=getClassName(Circle.class);
		System.out.println(unKnoName);
		System.out.println("----------------------------------");
		
	}
	public static String getClassName(Class<?> c){
		String className=c.getName();
		return className;
	}
}
