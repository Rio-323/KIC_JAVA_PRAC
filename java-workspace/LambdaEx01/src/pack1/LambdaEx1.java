package pack1;
@FunctionalInterface
interface FunctionalInterface1 {
	void methodA();
}

public class LambdaEx1 {
	public static void useFlMethod(FunctionalInterface1 f1) {
		f1.methodA();
	}

	public static void main(String[] args) {
		useFlMethod(new FunctionalInterface1() {
			
			@Override
			public void methodA() {
				System.out.println("익명의 내부 클래스 형태");
			}
		});
		useFlMethod( () -> {
			System.out.println("람다식 이용1");
		});
		
		useFlMethod(() -> System.out.println("람다식 이용2"));
	}

}
