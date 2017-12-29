package learn.center.genertic.class01;

public class Pair<T,K> {
	private T age;
	
	private K name;
	
	private K className;

	public T getAge() {
		return age;
	}

	public void setAge(T age) {
		this.age = age;
	}

	public K getName() {
		return name;
	}

	public void setName(K name) {
		this.name = name;
	}

	public K getClassName() {
		return className;
	}

	public void setClassName(K className) {
		this.className = className;
	}
	
	
}
