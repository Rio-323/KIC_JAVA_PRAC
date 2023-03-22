package poly4;

enum Tea {
	COFFEE, BLACK_TEA, GREEN_TEA
}

public class EnumMethodTest {

	public static void main(String[] args) {
		Tea[] teaArray = Tea.values();
		for(Tea tea : teaArray) {
			String strName = tea.name();
			System.out.printf("이름 : %s%n", strName);
			System.out.printf("등장 순서 : %d%n", tea.ordinal());
			
			// 문자열을 다시 Enum 타입으로
			Tea reTea = Tea.valueOf(strName);
			System.out.printf("원래 객체와 같은가? : %b%n", reTea.equals(tea));
			System.out.println();
		}

	}

}
