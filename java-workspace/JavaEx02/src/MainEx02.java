import pack.Child;
// import pack.Parent;

public class MainEx02 {

	public static void main(String[] args) {
//		Parent p1 = new Parent();
//		Parent p2 = new Parent("홍길동", 60);
//		
//		
//		System.out.println(p2.getName());
//		System.out.println(p2.getAge());
		
		Child c1 = new Child();
		c1.viewParent();
		
		for(int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}

}
