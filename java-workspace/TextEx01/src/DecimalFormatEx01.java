import java.text.DecimalFormat;
import java.text.ParseException;

public class DecimalFormatEx01 {

	public static void main(String[] args) {
		DecimalFormat format = new DecimalFormat("$#,###.#");
		
		double dblNum1 = 1234.5;
		double dblNum2 = 1234.56;
		double dblNum3 = 234.5;
		
		String strNum1 = format.format(dblNum1);
		String strNum2 = format.format(dblNum2);
		String strNum3 = format.format(dblNum3);
		
		System.out.println(strNum1);
		System.out.println(strNum2);
		System.out.println(strNum3);
		
		String strNum4 = "$1,234.5";
		double parseNum;
		
		try {
			parseNum = (double)format.parse(strNum4);
			System.out.println(parseNum);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
