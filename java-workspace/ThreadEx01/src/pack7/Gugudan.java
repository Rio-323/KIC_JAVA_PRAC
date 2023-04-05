package pack7;

public class Gugudan implements Runnable {
	private int dan;
	
	public Gugudan(int dan) {
		this.dan = dan;
	}

	@Override
	public void run() {
		for(int i = 1; i <= 9; i++) {
			System.out.printf("%s  X %s = %s\n", dan, i, (dan * i));
		}
	}

}
