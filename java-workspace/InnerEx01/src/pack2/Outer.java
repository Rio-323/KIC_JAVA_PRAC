package pack2;

public class Outer {
	private int x1 = 100;
	public int x2 = 100;
	
	public Outer() {
		System.out.println("Outer : " + this);
	}
	
	static class Inner {
		private int y1 = 200;
		public int y2 = 200;
		
		public void viewInner() {
			// System.out.println(x1); - static으로 클래스를 선언할 경우 초기에 메모리 영역으로 올라가기 때문에 시점이 달라서 출력할 수 없다.
			// System.out.println(x2);
			System.out.println(y1);
			System.out.println(y2);
		}
	}
}
