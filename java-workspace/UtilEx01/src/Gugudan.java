import java.util.Scanner;

public class Gugudan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("출력하고자 하는 구구단의 단 수를 입력해주세요(종료를 원한다면 'exit' 입력) : ");
			String gugu = sc.nextLine();
			
			if(!gugu.equals("exit")) {
				int gugu1 = Integer.parseInt(gugu);
				for(int i = 1; i <= 9; i++) {
					System.out.printf("%d X %d = %d\n", gugu1, i, (gugu1*i));
				}
			} else {
				System.out.println("종료");
				break;
			}
		}
		
		sc.close();

	}

}
