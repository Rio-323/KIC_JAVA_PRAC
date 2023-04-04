package pack6;

public class Gugudan implements Runnable {
	
	private int dan;
	

	public Gugudan(int dan) {
		this.dan = dan;
	}


	@Override
	public void run() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("[Error] : " + e.getMessage());
		}
		
		for(int i = 1; i < 10; i++) {
			System.out.printf("%s X %s = %s%n", dan, i, (dan * i));
		}
	}

}
