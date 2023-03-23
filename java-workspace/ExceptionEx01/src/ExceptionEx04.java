
public class ExceptionEx04 {

	public static void main(String[] args) {
		System.out.println("시작");
		
		String name = null;
		int num1 = 0;
		int num2 = 10;
		
		try {
			System.out.println(name.length());
		} catch (NullPointerException e) {
			System.out.println("객체 생성 후 메서드 사용");
		}
		
		try {
			System.out.println(num2 / num1);
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		
		System.out.println("끝");
	}

}
