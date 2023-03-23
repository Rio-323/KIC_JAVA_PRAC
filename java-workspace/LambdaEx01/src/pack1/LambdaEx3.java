package pack1;
@FunctionalInterface
interface FunctionalInterface3 {
	String methodB(String msg);
}
public class LambdaEx3 {
	public static void useFlMethod(FunctionalInterface3 fi) {
		System.out.println(fi.methodB("홍길동"));
	}

	public static void main(String[] args) {
		useFlMethod((String msg) -> {
			return "람다식 이용1 : " + msg;
		});
		useFlMethod(msg -> "람다식 이용2 : " + msg);

	}

}
