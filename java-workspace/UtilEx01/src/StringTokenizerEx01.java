import java.util.StringTokenizer;

public class StringTokenizerEx01 {

	public static void main(String[] args) {
		String strData1 = "사과 참외 수박 딸기";
		StringTokenizer st1 = new StringTokenizer(strData1);
//		System.out.println(st1.countTokens());
//		System.out.println(st1.nextToken());
//		System.out.println(st1.nextToken());
//		System.out.println(st1.nextToken());
//		System.out.println(st1.nextToken());
		
		while(st1.hasMoreTokens()) {
			System.out.println(st1.nextToken());
		}
		System.out.println();
		
		String strData2 = "사과&참외&수박&딸기";
		StringTokenizer st2 = new StringTokenizer(strData2, "&");
		
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
		System.out.println();
		
		String strData3 = "x = 100 * (200 + 300) / 2";
		StringTokenizer st3 = new StringTokenizer(strData3, "+-*/=()");
		while(st3.hasMoreTokens()) {
			System.out.println(st3.nextToken());
		}
		System.out.println();
	}

}
