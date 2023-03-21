import java.util.Calendar;
import java.util.Date;

public class CalenderEx02 {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(2023, 3 - 1, 1);
		System.out.println(c.getTime());
		
		// 특정 기간이 지난 후
		c.add(Calendar.DATE, 3);
		
		// Date date = c.getTime();
		System.out.println(c.getTime().toLocaleString());
		
		c.add(Calendar.MONTH, -6);
		System.out.println(c.getTime().toLocaleString());
	}

}
