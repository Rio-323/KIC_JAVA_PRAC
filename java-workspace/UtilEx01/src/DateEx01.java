import java.util.Date;

public class DateEx01 {

	public static void main(String[] args) {
		java.util.Date d1 = new java.util.Date();
		Date d2 = new Date();
		
		// 참조값 X -> 내용 출력(toString()이 오버라이딩 되어있다.)
		System.out.println(d1);
		System.out.println(d2);		
		
		// deprecated
		System.out.println(d2.toLocaleString());
		
		// 년 - 월 - 일 분리 출력
		String strDate = d2.toLocaleString();
		System.out.println(strDate.substring(0, 4));
		System.out.println(d2.getYear() + 1900);
		System.out.println(d2.getMonth() + 1);
		System.out.println(d2.getDate());
		// 일요일 : 0
		System.out.println(d2.getDay());
		
		// getDay -> 한글 출력
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
