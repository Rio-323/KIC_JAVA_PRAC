
public class ObjectEx01 {

	public static void main(String[] args) {
		Object o1 = new Object();
		
		// 객체 변수를 출력한다는 의미는 System.out.println(o1.toString());과 같은 의미이다.
		// override
		// toString() -> 내용(멤버 필드) 출력
		System.out.println(o1);
		System.out.println(o1.toString());
		System.out.println(o1.getClass().getName());
		System.out.println(o1.hashCode());
		System.out.println(Integer.toHexString(o1.hashCode()));
		System.out.printf("%x\n", o1.hashCode());
		System.out.println();
		
		Person p = new Person(100, "홍길동", 20);
		
		//toString() - Object 클래스에서 상속
		System.out.println(p);
		System.out.println(p.toString());
		// System.out.println(p.viewData());
		System.out.println();
		
		String str = new String("Hello Java");
		
		System.out.println(str);
		System.out.println(str.toString());
	}

}
