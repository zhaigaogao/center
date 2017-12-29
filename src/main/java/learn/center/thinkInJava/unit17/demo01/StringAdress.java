package learn.center.thinkInJava.unit17.demo01;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

public class StringAdress {
	private String s;
	public StringAdress(String s){
		this.s=s;
	}
	public StringAdress(){};
	public String ToString(){
		return super.toString()+" "+s;
	}
}
