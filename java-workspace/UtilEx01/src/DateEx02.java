import java.util.Date;

public class DateEx02 {

	public static void main(String[] args) {
		Date d1 = new Date(2023 - 1900, 3 - 1, 1);
		System.out.println(d1.toLocaleString());
		
		// 2023년 12월 24일의 요일
		Date d2 = new Date(2023 - 1900, 13 - 1, 24);
		switch (d2.getDay()) {
		case 0 : System.out.println("일요일"); break;
		case 1 : System.out.println("월요일"); break;
		case 2 : System.out.println("화요일"); break;
		case 3 : System.out.println("수요일"); break;
		case 4 : System.out.println("목요일"); break;
		case 5 : System.out.println("금요일"); break;
		case 6 : System.out.println("토요일"); break;
		}
	}

}
