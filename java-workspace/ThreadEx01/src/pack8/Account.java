package pack8;

public class Account {
	// 계좌 잔고
	private int balance = 1000;

	public int getBalance() {
		return balance;
	}

	// 인출 메서드
	// synchronized -> 자원이 공유되는 문제점을 해결
	public synchronized void withdraw(int money) {
		if(balance >= money) {
			try {
				Thread.sleep(1000);
				balance -= money;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("잔고가 없습니다.");
		}
	}
}
