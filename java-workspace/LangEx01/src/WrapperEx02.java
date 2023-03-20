
public class WrapperEx02 {

	public static void main(String[] args) {
		int i11 = 10;
		int i12 = 20;
		int sum = i11 + i12;
		System.out.println(sum);
		
		// Wrapper 클래스 - 기본 자료형처럼 사용 가능
		Integer i21 = Integer.valueOf("10");
		Integer i22 = Integer.valueOf("20");
		
		// unboxing
		int sum1 = i21 + i22;
		System.out.println(sum1);

	}

}
