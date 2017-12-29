package learn.center.other.thread.bank;

public class PersonB extends Thread{
	Bank bank;
	
	public PersonB(Bank bank){
		this.bank = bank;
	}
	
	public void run(){
		try {
			while(Bank.money>200){
				bank.ATM(200);
				sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
