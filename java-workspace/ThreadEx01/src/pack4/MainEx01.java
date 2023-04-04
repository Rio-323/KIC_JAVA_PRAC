package pack4;

public class MainEx01 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 1; i <= 10; i++) {
					System.out.println("go : " + i);
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 1; i <= 10; i++) {
					System.out.println("come : " + i);
				}
			}
		});
		
		System.out.println("시작");
		t1.start();
		t2.start();
		System.out.println("끝");
	}
}
