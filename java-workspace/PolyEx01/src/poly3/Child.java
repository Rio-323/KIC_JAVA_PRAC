package poly3;

public class Child extends Parent implements InterB {

	@Override
	public void methodA() {
		System.out.println("Child methodA 호출");
	}

	@Override
	public void methodB() {
		System.out.println("Child methodB 호출");
	}
	
	@Override
	public void methodC() {
		System.out.println("Child methodC 호출");
	}
	
}
