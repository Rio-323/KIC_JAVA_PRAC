package poly4;
interface StaticMethodInterface {
	static void staticMethod() {
		System.out.println("static 메서드");
	}
}
public class StaticMethodTest {
	public static void main(String[] args) {
		StaticMethodInterface.staticMethod();
	}
}
