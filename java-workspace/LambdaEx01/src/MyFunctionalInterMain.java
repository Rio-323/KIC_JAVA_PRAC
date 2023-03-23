
public class MyFunctionalInterMain {

	public static void main(String[] args) {
		new MyFunctionalInter() {
			
			@Override
			public void method() {
				System.out.println("method1 호출");
				
			}
		}.method();
		
		// 인터페이스를 객체 변수 선언 -> lambda
		MyFunctionalInter f = new MyFunctionalInter() {
			
			@Override
			public void method() {
				System.out.println("method2 호출");
			}
		};
		
		f.method();
		
		MyFunctionalInter f1 = () -> {
			System.out.println("method3 호출");
		};
		f1.method();
		
		MyFunctionalInter f2 = () -> System.out.println("method4 호출");
		f2.method();
	}

}
