package learn.center.thinkInJava.unit12;
public class testException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			extException.extp01();
		} catch (extException e) {
			// TODO: handle exception
			System.out.println("-----------------------------");
			for (StackTraceElement stm : e.getStackTrace()) {
				System.out.println(stm.getFileName());
				System.out.println(stm.toString());
			}
		}
		
		System.out.println("-----------------------------");
		System.out.println("执行方法结束");
	}
}
