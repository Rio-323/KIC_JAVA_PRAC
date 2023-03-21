import java.util.ArrayList;

public class ArrayListEx03 {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		Person p1 = new Person("1001", "홍길동");
		Person p2 = new Person("1002", "박문수");
		
		// Person -> Object
		al.add(p1);
		al.add(p2);

		// System.out.println(al);
		
		for (int i = 0; i < al.size(); i++) {
			Person p = (Person)al.get(i);
			System.out.print(p.getHakbun() + "\t");
			System.out.println(p.getName());
		}
	}

}
