
public class JuminCheckEx02 {

	public static void main(String[] args) {
		
		String str = "980323-1621716";
		int[] number = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
		int tot = 0;
		
		if(str.length() == 0) {
			System.out.println("형식을 다시 확인해주세요");
		} else {
			String strJumin = str.replaceAll("-", "");
			
			for (int i = 0; i < strJumin.length() - 1; i++) {
				tot += Integer.parseInt(strJumin.substring(i, i + 1)) * number[i];
			}

			int lastNum = Integer.parseInt(strJumin.substring(12, 13));
			
			int resultNum = (11 - (tot % 11)) % 10;
			
			if(lastNum == resultNum) {
				System.out.println("주민등록 형식이 맞음");
			} else {
				System.out.println("주민등록 형식이 아님");
			}	
		}
	}
}


