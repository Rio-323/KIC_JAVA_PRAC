package pack4;

public class Outer {

	public static void main(String[] args) {
		int y = 100;
		new InnerB() {
			
			@Override
			public void viewInner() {
				System.out.println(x);
				System.out.println(y);
			}
		}.viewInner(); // 일회용 선언하면서 사용.

	}

}
