package learn.center.other.thread.bank;

public class PersonA extends Thread{
	
	Bank bank;
	
	public PersonA(Bank bank){
		this.bank=bank;
	}
	
	public void run(){
		try {
			while (Bank.money>100) {
				bank.Counter(100);
				sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
