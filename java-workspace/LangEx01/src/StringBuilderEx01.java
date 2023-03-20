
public class StringBuilderEx01 {

	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder(100);
		StringBuilder sb3 = new StringBuilder("Hello StringBuilder");
		
		// buffer의 크기
		System.out.println(sb1.capacity());
		System.out.println(sb2.capacity());
		System.out.println(sb3.capacity());
		
		// 저장 문자열의 길이
		System.out.println(sb1.length());
		System.out.println(sb2.length());
		System.out.println(sb3.length());
		
		System.out.println(sb3.charAt(0));
		System.out.println(sb3.substring(4));
		
		// indexOf / lastIndexOf
		// replace
		// append / insert / delete
		
		StringBuilder builder = new StringBuilder("사봉-용산-사가정-용마산");
		builder.append("-중곡");
		System.out.println(builder); // 맨 뒤에 -중곡 추가
		
		builder.insert(3, "면목-");
		System.out.println(builder); // '사봉-' 뒤에 '면목' 추가
		
		builder.delete(5, 8);
		System.out.println(builder); // '-용산' 삭제
		
		builder.replace(0, 1, "상");
		System.out.println(builder); // '사'를 '상'으로 변경
		
		System.out.println(sb3.reverse());
	}

}
