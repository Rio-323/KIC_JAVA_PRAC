import java.util.Scanner;

public class ScannerEx01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 : ");
		// 공백 전 까지 입력을 받아드림.
		// String msg = sc.next();
		
		// 엔터키까지 입력을 받아들임
		String msg = sc.nextLine();
		
		System.out.println("msg : " + msg);
		sc.close();
	}

}
