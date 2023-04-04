package pack5;

public class MainEx {

	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1();
		Mythread2 t2 = new Mythread2();
		
		System.out.println(t1.getPriority());
		t1.setPriority(7);
		
		System.out.println("시작");
		t1.start();
		t2.start();
		System.out.println("끝");
	}

}
