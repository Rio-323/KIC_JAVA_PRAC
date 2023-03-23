import java.util.Arrays;
import java.util.List;

public class ArraysEx01 {

	public static void main(String[] args) {
		String[] arrs = {"aaa", "bbb", "ccc"};
		
		System.out.println(Arrays.toString(arrs));
		// "toString" 메서드는 객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴하는 메소드
		
		Arrays.fill(arrs, "xxx");
		System.out.println(Arrays.toString(arrs));
		
		Arrays.fill(arrs, 0, 2, "yyy");
		System.out.println(Arrays.toString(arrs));
		
		String[] arrs1 = {"aaa", "bbb", "ccc"};
		
		String[] arrs2 = {"aaa", "bbb", "ccc"};
		
		System.out.println(arrs1 == arrs2);
		
		System.out.println(Arrays.equals(arrs1, arrs2));
		
		Integer[] arrNums = {5, 2, 3, 1, 4};
		Arrays.sort(arrNums);
		System.out.println(Arrays.toString(arrNums));
		
		// List <-> 배열
		List<String> lists  = Arrays.asList(arrs1);
		System.out.println(lists);
	}

}
