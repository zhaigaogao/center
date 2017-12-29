package learn.center.thinkInJava.unit14.demo3;

public class Individual implements Comparable<Individual>{

	private static long counter=0;
	private static long id=counter++;
	private String name;
	/**
	 * 
	 * 构造函数
	 * @discription {有参构造}
	 * @author zhaieryuan 
	 * @created 2017年3月6日 下午4:06:44
	 */
	public Individual(String name){
		this.name=name;
	}
	/**
	 * 
	 * 构造函数
	 * @discription {无参构造}
	 * @author zhaieryuan 
	 * @created 2017年3月6日 下午4:06:44
	 */
	public Individual(){
		
	}
	public String toString(){
		return getClass().getSimpleName()+(name==null ? "":" "+name);
	}
	
	public long id(){
		return id;
	}
	public boolean equals(Object o){
		return o instanceof Individual && id== ((Individual)o).id;
	}
	
	public int hasCode(){
		int result=17;
		if(name !=null){
			result =37*result+name.hashCode();
		}
		return result;
	}
	
	public int compareTo(Individual arg) {
		// TODO Auto-generated method stub
		String first=getClass().getSimpleName();
		String argFirst=arg.getClass().getSimpleName();
		int firstCompare=first.compareTo(argFirst);
		if(firstCompare !=0){
			return firstCompare;
		}
		if(name !=null && arg.name !=null ){
		    int secondCompare =name.compareTo(arg.name);
		    if(secondCompare != 0){
		    	return secondCompare;
		    }
		}
		return (arg.id < id ? -1 :(arg.id==id?0:1));
	}

}
