import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDataFormatTest {

	public static void main(String[] args) throws ParseException {
		String source = "2020년 12월 25일";
		System.out.println(source + "를 요일 정보까지 출력하려면?");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
		
		Date parsed = format.parse(source);
		format.applyPattern("yyyy년 MM월 dd일(E)");
		System.out.println(format.format(parsed));
		
	}

}
