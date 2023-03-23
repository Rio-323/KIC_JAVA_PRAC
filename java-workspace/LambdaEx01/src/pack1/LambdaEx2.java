package pack1;
@FunctionalInterface
interface FuntionalInterface2 {
	void methodB(String msg);
}

public class LambdaEx2 {
	public static void useFlMethod(FuntionalInterface2 fi) {
		fi.methodB("홍길동");
	}

	public static void main(String[] args) {
		useFlMethod((String msg) -> {
			System.out.println("람다식 이용1 : " + msg);
		});
		
		useFlMethod(msg -> System.out.println("람다식 이용2 : " + msg));
	}

}
