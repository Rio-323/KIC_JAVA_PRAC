import java.util.ArrayList;

public class ArrayListEx02 {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add("홍길동");
		al.add("박문식");
		al.add("이몽룡");
		
		System.out.println(al.toString());
		
		// 추가
		al.add(2, "장길산");
		System.out.println(al.toString());
		
		// 수정
		al.set(0, "이몽룡");
		System.out.println(al.toString());
		
		// 삭제
		al.remove(0);
		System.out.println(al.toString());
		
		al.clear();
		System.out.println(al.toString());
		System.out.println(al.size());
	}

}
