package pack3;

public class Outer {
	public void viewOuter() {
		int x = 100;
		
		class Inner {
			private int y1 = 200;
			public int y2 = 200;
			
			public void viewInner() {
				System.out.println("x : " + x);
				System.out.println("y1 : " + y1);
				System.out.println("y2 : " + y2);
			}
		}
		
		Inner inner = new Inner();
		inner.viewInner();
	}
}
