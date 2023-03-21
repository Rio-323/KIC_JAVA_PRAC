import java.util.Scanner;

public class ScannerEx02 {

	public static void main(String[] args) {
		Scanner  sc = new Scanner(System.in);
		
		System.out.print("아이디 : ");
		String msg1 = sc.nextLine();
		System.out.print("비밀번호 : ");
		String msg2 = sc.nextLine();
		
		System.out.println("msg1 : " + msg1);
		System.out.println("msg2 : " + msg2);
		sc.close();
	}

}
