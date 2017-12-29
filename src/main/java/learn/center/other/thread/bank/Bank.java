package learn.center.other.thread.bank;

public class Bank {
	//设置账户金额为900元
	static int money=900;
	
	/**
	 * 柜台取钱方法 一次去除100元
	 * @param money
	 * @author zhaieryuan
	 * @date 2017年11月30日 上午11:19:14
	 */
	public void Counter(int money){
		Bank.money -=money;
		System.out.println("A取走了"+money+"元，账户还剩"+Bank.money+"元");
	}
	
	public void ATM(int money){
		Bank.money -=money;
		System.out.println("B取走了"+money+"元，账户还剩"+Bank.money+"元");
	}
}
