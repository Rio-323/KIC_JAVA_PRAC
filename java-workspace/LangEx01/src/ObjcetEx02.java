
public class ObjcetEx02 {

	public static void main(String[] args) {
		int a1 = 10;
		int a2 = 10;
		
		// 내용 값을 비교
		System.out.println(a1 == a2);
		
		// 주소 값을 비교
		Object o1 = new Object();
		Object o2 = new Object();
		System.out.println(o1 == o2);
		
		String str1 = new String("박문수");
		String str2 = new String("박문수");
		
		System.out.println(str1 == str2);
		
		// 내용 값(멤버필드) 비교
		System.out.println(o1.equals(o2));
		System.out.println(str1.equals(str2));
		
	}

}
