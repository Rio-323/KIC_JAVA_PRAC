
public class MainEx01 {

	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person();
		
		// 다형
		// Person salary(X) - Employee Salary(O)
		p1.salary();
		p2.salary();
		
		System.out.println(p1 instanceof Person);
		System.out.println(p1 instanceof Employee1);
		System.out.println(p1 instanceof Employee2);
		System.out.println(p1 instanceof Object);
	}

}
