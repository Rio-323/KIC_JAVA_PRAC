package prac;
class Parent {
	
	public void viewParent() {
		System.out.println("hi");
	}
}

class Child extends Parent {

//	@Override
//	public void viewParent() {
//		System.out.println("child viewParent()");
//	}
	
	public void viewChild() {
		System.out.println("viewChild");
	}
	
}

public class MainEx02 {

	public static void main(String[] args) {
		Parent p = new Parent();
		Child c = new Child();
		
//		p.viewParent();
//		c.viewChild();
//		c.viewParent();

		Parent p1 = new Child();
		Child c1 = (Child)p1;
		
		//p1.viewParent();
		c1.viewChild();
		c1.viewParent();
	}

}
