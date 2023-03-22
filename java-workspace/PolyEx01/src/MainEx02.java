
public class MainEx02 {

	public static void main(String[] args) {
		// Person p1 = new Person();
		Person p1 = new Employee1();
		// Employee1 e1 = (Employee1)p1;
		// e1.viewEmployee();
		
		System.out.println(p1 instanceof Person);
		System.out.println(p1 instanceof Employee1);
		
		if(p1 instanceof Employee1) {
			Employee1 e1 = (Employee1)p1;
			e1.viewEmployee();
		} else {
			System.out.println("형 변환 불가");
		}
	}

}
