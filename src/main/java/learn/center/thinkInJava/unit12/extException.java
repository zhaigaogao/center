package learn.center.thinkInJava.unit12;

public class extException extends Exception{
	
    /**  描述   (@author: zhaieryuan) */      
	    
	private static final long serialVersionUID = 1L;
	private String Msg;
	private Object data;
	
	public extException(String msg){
		super();
	}
	public extException(){
		super();
	}
	public String getMsg() {
		return Msg;
	}
	public void setMsg(String msg) {
		Msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "extException [Msg=" + Msg + ", data=" + data + "]";
	}
	public static void extp01() throws extException{
		System.out.println("执行异常extp01");
		extException e=new extException();
		e.setData("执行自定义异常");
		e.setMsg("执行自定义异常");
		e.toString();
		throw e;
	}
	public static void extp02() throws extException{
		System.out.println("执行异常extp02");
		extException e=new extException();
		e.setData("执行自定义异常");
		e.setMsg("执行自定义异常");
		e.toString();
		throw e;
	}
}
