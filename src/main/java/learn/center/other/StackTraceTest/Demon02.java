package learn.center.other.StackTraceTest;

/**
 * 枚举类型和内部类敞亮定义数据字典信息
 * @author zhaieryuan
 * @date 2017年12月29日 上午10:49:04
 */
public class Demon02 {
	
	public enum SIZE{
		small(180,"S"),middle(190,"M"),large(200,"L");
		private int sg;
		private String size;
		private SIZE(int sg,String size){
			this.sg = sg;
			this.size = size;
		}
		public int getSg() {
			return sg;
		}
		public void setSg(int sg) {
			this.sg = sg;
		}
		public String getSize() {
			return size;
		}
		public void setSize(String size) {
			this.size = size;
		}
	}
	
	public class AuditOrderApp {
		public static final String AUDIT_TYPE_ORDER = "0"; //在线下单
		public static final String AUDIT_TYPE_PASS = "1"; //审批通过
		public static final String AUDIT_TYPE_ADD = "2";  //审批加签
		public static final String AUDIT_TYPE_BACK = "3"; //审批驳回
		public static final String AUDIT_TYPE_CANCEL = "4"; //取消订单
	}
	
	public static void main(String[] args) {
		System.out.println(Demon02.SIZE.middle.sg);
		System.out.println(Demon02.SIZE.middle.size);
		
		System.out.println(Demon02.AuditOrderApp.AUDIT_TYPE_ADD);
	}
}

