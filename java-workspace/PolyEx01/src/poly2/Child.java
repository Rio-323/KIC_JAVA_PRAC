package poly2;

public class Child implements InterA, InterB {

	@Override
	public void methodB() {
		System.out.println("methodB 호출");
	}

	@Override
	public void methodA() {
		System.out.println("methodA 호출");
	}

}
