package pack;

public class Child extends Parent {
	@Override // Annotation
	public void viewParent() {
		System.out.println("Child의 viewParent()");
	}
}
