
public class ExceptionEx07 {
	public void method1(int num) {
		System.out.println("메서드 시작");
		
		if(num >= 100) {
			System.out.println("100보다 크다");
		} else {
			// System.out.println("100보다 작다");
			// 강제 예외 발생
			try {
				throw new Exception("100보다 작다");
			} catch(Exception e) {
				System.out.println("[Error] : " + e.getMessage());
			}
			
		}
		
		System.out.println("메서드 끝");
	}

	public static void main(String[] args) {
		ExceptionEx07 ee = new ExceptionEx07();
		ee.method1(10);
		ee.method1(200);
	}

}
