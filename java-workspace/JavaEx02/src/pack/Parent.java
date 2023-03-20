package pack;

public class Parent {
	private String name;
	private int age;
	
	public Parent() {
		System.out.println("Parent() 호출");
	}
	
	// overloading 생성자
	public Parent(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	public void viewParent() {
		System.out.println("Parent의 viewParent()");
	}
}
