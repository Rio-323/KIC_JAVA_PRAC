import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ArrayListEx01 {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>();
		al.add("홍길동");
		al.add("박문수");
		al.add("이몽룡");
		
		System.out.println(al);
		
		al.remove(0);
		System.out.println(al);
		
		Vector<String> v = new Vector<>();
		v.add("홍길동");
		v.add("박문수");
		v.add("이몽룡");
		
		System.out.println(v);
		
		v.remove(0);
		System.out.println(v);
		
		// 다형 / 추상의 원리
		List<String> l1 = new ArrayList<>();
		l1.add("홍길동");
		l1.add("박문수");
		l1.add("이몽룡");
		
		System.out.println(l1);
		
		List<String> l2 = new Vector<>(); 
		l2.add("홍길동");
		l2.add("박문수");
		l2.add("이몽룡");
		
		System.out.println(l2);
	}

}
