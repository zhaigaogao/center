package learn.center.thinkInJava.unit10.demo02;

public class parcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private class PContents implements Contents{
		private int i=11;
		public int value() {
			// TODO Auto-generated method stub
			return i;
		}
	}
	private class PDestination implements Destination{
		private String label;
		public String readlabel() {
			// TODO Auto-generated method stub
			return label;
		}
		private PDestination(String whereTo){
			label=whereTo;
		}
	}
	
	/**
	 * 
	 * @discription {此处Destination被PDestination实现，所以返回为向上转型的PDestination实例对象}
	 * @author zhaieryuan  
	 * @created 2017年3月15日 上午11:00:35
	 * @param s
	 * @return
	 */
	public Destination destination(String s){
		return new PDestination(s);
	}
	public Contents contents(){
		return new PContents();
	}
}
