package pack3;

public class MainEx01 {

	public static void main(String[] args) {
		Go g = new Go();
		Come c = new Come();
		
		Thread t1 = new Thread(g);
		Thread t2 = new Thread(c);
		
		System.out.println("시작");
		t1.start();
		t2.start();
		System.out.println("끝");
	}

}
