import java.util.ArrayList;

public class ArrayListEx01 {

	public static void main(String[] args) {
		// List 계열의 Collection Framework
		ArrayList al1 = new ArrayList();
		ArrayList al2 = new ArrayList(100);
		
		// String -> Object
		al1.add("홍길동");
		al1.add("박문식");
		al1.add("이몽룡");
		
		// 배열과 유사한 형식으로 저장되어 있음
		System.out.println(al1);
		System.out.println(al1.size());
		
		String data1 = (String)al1.get(0);
		String data2 = (String)al1.get(1);
		
//		System.out.println(data1);
//		System.out.println(data2);
		
		for(int i = 0; i < al1.size(); i++) {
			System.out.println((String)al1.get(i));
		}
	}

}
