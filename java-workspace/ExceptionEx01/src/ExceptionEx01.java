
public class ExceptionEx01 {

	public static void main(String[] args) {
		System.out.println("시작");
		
		// int num1 = 10;
		int num1 = 0;
		int num2 = 20;
		
		if(num1 != 0) {
			int result  = num2 / num1;
			System.out.println(result);
		} else {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		
		
		System.out.println("끝");
	}

}
