package pack1;

public class MyFunctionalInterMain {

	public static void main(String[] args) {
		MyFunctionalInter f;
		f = () -> {
			System.out.println("method 호출"); // 인터페이스 내부에 메서드는 단 한개만 존재해야함.
		};

	}

}
