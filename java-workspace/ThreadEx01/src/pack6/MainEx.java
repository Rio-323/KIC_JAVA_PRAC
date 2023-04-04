package pack6;

public class MainEx {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Gugudan(2));
		Thread t2 = new Thread(new Gugudan(4));
		Thread t3 = new Thread(new Gugudan(6));
		
		t1.start();
		t2.start();
		t3.start();
	}

}
