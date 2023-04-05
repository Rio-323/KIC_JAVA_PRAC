package pack8;

public class ClientMain {

	public static void main(String[] args) {
		Account account = new Account();
		
		Thread t1 = new Thread(new Client(account));
		Thread t2 = new Thread(new Client(account));
		
		t1.start();
		t2.start();
	}

}
