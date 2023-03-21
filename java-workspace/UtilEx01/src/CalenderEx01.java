import java.util.Calendar;

public class CalenderEx01 {

	public static void main(String[] args) {
		// Calendar calender1 = new Calendar;
		Calendar calender1 = Calendar.getInstance();
		System.out.println(calender1.toString());
		System.out.println(calender1.get(calender1.YEAR));
		System.out.println(calender1.get(calender1.MONTH) + 1);
		System.out.println(calender1.get(calender1.DATE));
		
		// 일요일 : 1
		System.out.println(calender1.get(calender1.DAY_OF_WEEK));
	}

}
