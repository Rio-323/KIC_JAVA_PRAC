package pack2;

public class Go extends Thread {

	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println("go : " + i);
		}
	}
	
}
