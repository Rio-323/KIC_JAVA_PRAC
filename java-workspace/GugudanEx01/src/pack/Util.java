package pack;

public class Util {
	public void viewGugudan(int startDan, int endDan) {
		for(int i = startDan; i <= endDan; i++) {
			for(int j = 1; j < 10; j++) {
				System.out.println(i + " X " + j + " = " + (i*j));
			}
			System.out.println();
		}
	}
}
