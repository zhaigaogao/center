package learn.center.thinkInJava.unit20.learn01;

import java.lang.reflect.Method;

public class zhuejie01 {
	 @MyTarget
	 public void doSomething()
	 {
	  System.out.println("hello world");
	 }
	 
	 public static void main(String[] args) throws Exception
	 {
	  Method method = zhuejie01.class.getMethod("doSomething",null);
	  if(method.isAnnotationPresent(MyTarget.class))//如果doSomething方法上存在注解@MyTarget，则为true
	  {
	   System.out.println(method.getAnnotation(MyTarget.class));
	  }
	  }
}
