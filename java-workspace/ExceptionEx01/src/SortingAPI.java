import java.util.Arrays;

public class SortingAPI {

	public static void main(String[] args) {
		String[] arr = {"Java", "is", "A", "PIE"};
		Arrays.sort(arr);
		
		System.out.println("정렬 후");
		
		for(String i : arr) {
			System.out.printf("%s\t",i);
		}
		
		// ASCII 코드 값으로 정렬
		// 배열을 문자열로 정렬할 때, 대문자와 소문자가 구분되지 않고 모든 대문자가 먼저 정렬된 후 소문자가 정렬됩니다. 
		// 따라서 "A"는 "a"보다 우선적으로 정렬되어 "A"가 "Java"보다 먼저 위치하게 됩니다.
	}
}
