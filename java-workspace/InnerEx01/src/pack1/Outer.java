package pack1;

public class Outer {
	private int x1 = 100;
	public int x2 = 100;
	
	// 인스턴스 inner 클래스 선언
	class Inner {
		private int y1 = 200;
		public int y2 = 200;
		
		public void viewInner() {
			System.out.println(x1);
			System.out.println(x2);
			System.out.println(y1);
			System.out.println(y2);
		}
	}
	
	public Outer() {
		System.out.println("Outer : " + this);
	}
}