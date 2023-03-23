package pack2;

public class StaticInnerTest {
	
	static class StaticInner {
		private int iMember = 10;
		private static int sMember = 0;
		
		private void innerMethod() {
			StaticInnerTest sit = new StaticInnerTest();
			System.out.println("om : " + sit.oMember + ", im : " + iMember);
		}
	}
	
	private int oMember = 1;
	
	private void outerMethod() {
		StaticInner inner = new StaticInner();
		inner.iMember = 100;
		inner.innerMethod();
	}

	public static void main(String[] args) {
		StaticInner inner = new StaticInner(); // static 내부 클래스는 외부 클래스를 선언하지 않아도 선언 가능.
		inner.innerMethod();

	}

}
