
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
	
	public void method2(int num) throws Exception {
		System.out.println("메서드 시작");
		
		if(num >= 100) {
			System.out.println("100보다 크다");
		} else {
			throw new Exception("100보다 작다");
		}
		
		System.out.println("메서드 끝");
	}
	
	public void method3(int num) throws CustomException {
		System.out.println("메서드 시작");
		
		if(num >= 100) {
			System.out.println("100보다 크다");
		} else {
			throw new CustomException("100보다 작다");
		}
		
		System.out.println("메서드 끝");
	}

	public static void main(String[] args) {
		ExceptionEx07 ee = new ExceptionEx07();
		ee.method1(10);
		ee.method1(200);
		try {
			ee.method2(10);
		} catch(Exception e) {
			System.out.println("[Error] : " + e.getMessage());
		}
		
		try {
			ee.method3(10);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("[Error] : " + e.getMessage());
		}
		
	}

}
