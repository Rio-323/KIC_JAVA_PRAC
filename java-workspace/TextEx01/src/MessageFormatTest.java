import java.text.MessageFormat;
import java.text.ParseException;

public class MessageFormatTest {

	public static void main(String[] args) throws ParseException{
		String pattern = "이름 : {0}, Java : {1}, HTML : {2}, Script : {3}";
		String src = "홍길동 : 100 : 90 : 85, 임꺽정 : 90 : 95 : 70, 장길산 : 75: 85 : 90";
		String[] studentInfo = src.split(",");
		
		for(String student : studentInfo) {
			System.out.println(MessageFormat.format(pattern, student.split(":")));
		}
	}

}
