package pack3;

public class Go implements Runnable {

	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println("go : " + i);
		}

	}

}
