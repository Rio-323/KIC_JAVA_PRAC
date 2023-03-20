
public class EqualsTest {
	private static void testString() {
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		
		System.out.println("String : " + (s1 == s2) + " : " + s1.equals(s2));
	}
	
	private static void testPhone() {
		Phone p1 = new Phone("01000000000");
		Phone p2 = new Phone("01000000000");
		
		System.out.println("Phone : " + (p1 == p2) + " : " + p1.equals(p2));
	}
	
	public static void main(String[] args) {
		testString();
		testPhone();
	}

}
