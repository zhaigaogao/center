package learn.center.other.thread.tickets;

public class Station extends Thread{
	
	/**
	 * 通过构造方法给线程赋名字
	 * @param name
	 * @author zhaieryuan
	 * @date 2017年11月30日 上午10:36:53
	 */
	public Station(String name) {
		super(name);
	}
	
	//为确保票数一致，给所有站台定义可售卖的总票数
	public static int tickets = 20;
	
	//创建一把进门的今天钥匙
	
	static Object object = "zhai";
	
	
	public void run(){
		while(tickets>0){
			synchronized (object) {
				try {
					if(tickets>0){
						System.out.println(getName()+"卖出了第"+tickets+"张票");
						tickets--;
						sleep(1000);
						System.out.println(isInterrupted());
					}else{
						System.out.println(getName()+"票卖完了");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
