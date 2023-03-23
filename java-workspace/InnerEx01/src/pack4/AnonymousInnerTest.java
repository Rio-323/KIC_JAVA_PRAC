package pack4;
interface SomeInterface {
	void printInfo();
}

public class AnonymousInnerTest {
	int iMember = 1;
	static int cMember = 2;
	
	void method(SomeInterface si) {
		si.printInfo();
	}
	
	public static void main(String[] args) {
		AnonymousInnerTest lit = new AnonymousInnerTest();
		int localVar = 3;
		lit.method(new SomeInterface() {
			
			@Override
			public void printInfo() {
				//System.out.println("외부 인스턴스 멤버변수 : " + iMember);
				System.out.println("외부 클래스 멤버변수 : " + cMember);
				System.out.println("외부 로컬 변수 : " + localVar);
				
			}
		});
	}
}
