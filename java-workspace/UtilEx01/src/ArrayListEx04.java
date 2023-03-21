import java.util.ArrayList;

public class ArrayListEx04 {

	public static void main(String[] args) {
		ArrayList al1 = new ArrayList();
		al1.add("홍길동");
		al1.add(new Person("1001", "홍길동"));
		
		// 데이터 가공, 출력
//		for(int i = 0; i < al1.size(); i++) {
//			String s = (String)al1.get(i);
//			System.out.println(s);
//		}
		
		// Generic 형식 -> Collection(Class / Method) 내부의 자료형 선언
		ArrayList<String> al2 = new ArrayList<>(); 
		
		al2.add("홍길동");
		// al2.add(new Person("1001", "홍길동")); -> 형태가 맞지 않음
		al2.add("박문수");
		for(int i = 0; i < al2.size(); i++) {
			String s = al2.get(i);
			System.out.println(s);
		}
	}

}
