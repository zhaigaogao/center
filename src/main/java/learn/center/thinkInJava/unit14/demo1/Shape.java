package learn.center.thinkInJava.unit14.demo1;

public abstract class Shape {
	void draw(){
		System.out.println(this.toString()+".draw()");
	};
	abstract public String toString();
}
