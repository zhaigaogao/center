package learn.center.other.StackTraceTest;

import learn.center.other.onblog.varargus.Student;

public class PrimaryStudent extends Student{

	/** 
	 * 
	 */
	private static final long serialVersionUID = -7151076578221946704L;
	
	private String className;
	
	private String classCode;
	
	private String areaName;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
}
