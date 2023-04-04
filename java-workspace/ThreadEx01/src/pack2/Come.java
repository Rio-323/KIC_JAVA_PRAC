package pack2;

public class Come  extends Thread {

	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println("come : " + i);
		}
	}
	
}
