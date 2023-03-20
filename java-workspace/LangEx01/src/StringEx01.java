
public class StringEx01 {

	public static void main(String[] args) {
		// 문자열 저장 클래스
		// String
		// StringBuffer / StringBuilder
		
		
		// 선언
		String str1 = "Hello String";
		String str2 = new String("Hello String");
		char[] charArray = {'H', 'e', 'l', 'l', 'o', ' ', 'S', 't', 'r', 'i', 'n', 'g'};
		String str3 = new String(charArray);
		
		// toString()
		// equals() - 내용 값 비교
		System.out.println(str1.length());
		// 문자열 -> 문자 추출
		System.out.println(str1.charAt(0));
		
		// 마지막 문자 출력
		System.out.println(str1.charAt(str1.length() - 1));
		
		// 문자열 -> 부분 문자열 추출
		System.out.println(str1.substring(2));
		System.out.println(str1.substring(2, 4));
		
		// 문자 위치
		System.out.println(str1.indexOf('l'));
		System.out.println(str1.lastIndexOf('l'));
		
		// 문자열 존재 여부(contains, endsWith)
		System.out.println(str1.startsWith("He"));
		
		// 문자열 치환
		System.out.println(str1.replaceAll("Hello", "안녕"));
		
		// 문자열 결합 : +
		System.out.println(str1.concat(" 안녕"));
		
		// 대소문자
		System.out.println("hello".toUpperCase());
		System.out.println("HELLO".toLowerCase());
		
		// 공백제거
		String str11 = "     Hello     String     ";
		System.out.println(str11.length());
		String str12 = str11.trim();
		System.out.println(str12.length());
		System.out.println(str12);
		
		// 구분자 단위 분리
		String str21 = "apple, banana, pineapple, kiwi";
		String[] strArr = str21.split(", ");
		
		for(int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
		
		// 구분자 단위 결합
		String str22 = String.join(", ", strArr);
		System.out.println(str22);
		
		// 형식이 있는 문자열
		String str31 = String.format("%s-%s-%s", "aaa", "bbb", "ccc");
		System.out.println(str31);
	}

}
