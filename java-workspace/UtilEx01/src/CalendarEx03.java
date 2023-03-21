import java.util.Calendar;

public class CalendarEx03 {

	public static void main(String[] args) {
		int year = 2023;
		int month = 3;
		
		Calendar startCalendar = Calendar.getInstance();
		Calendar endCalendar = Calendar.getInstance();
		
		startCalendar.set(year, month - 1, 1);
		endCalendar.set(year, month, 1 - 1);
		
		int startDayOfWeek = startCalendar.get(Calendar.DAY_OF_WEEK);
		int endDate = endCalendar.get(Calendar.DATE);
		// 마지막날 요일 - 디자인적인 필요.
		
		System.out.println(" SU MO TU WE TH FR SA");
		for(int i = 1; i  < startDayOfWeek; i++) {
			System.out.print("   ");
		}
		
		for(int i = 1, n = startDayOfWeek; i <= endDate; i++, n++) {
			System.out.print((i < 10) ? "  " + i : " " + i );
			if(n % 7 == 0) {
				System.out.println();
			}
		}
	}

}
