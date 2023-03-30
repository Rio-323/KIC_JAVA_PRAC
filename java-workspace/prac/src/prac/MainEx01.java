package prac;

class Parent1 {
	private String name;
	String age;
	String address;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

abstract class Parent2 {
	abstract void viewParent2();
}

class Child2 extends Parent2 {

	@Override
	void viewParent2() {
		
	}
	
}

public class MainEx01 {

	public static void main(String[] args) {
		Parent1 p1 = new Parent1();
		Child2 c2 = new Child2();
		c2.viewParent2();
		// System.out.println(p1.name);
		System.out.println(p1.age);
		p1.setName("이몽룡");
		System.out.println(p1.getName());
		
	}

}
