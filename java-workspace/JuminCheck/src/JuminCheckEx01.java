
public class JuminCheckEx01 {

	public static void main(String[] args) {
		
		
		String str = "주민번호";
		int[] number = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
		int tot = 0;
		
		// 입력값 검사
		if(str.length() == 0) {
			System.out.println("형식을 다시 확인해주세요");
		} else {
			String strJumin = str.replaceAll("-", "");
			
			int num01 = Integer.parseInt(strJumin.substring(0, 1)) * 2;
			int num02 = Integer.parseInt(strJumin.substring(1, 2)) * 3;
			int num03 = Integer.parseInt(strJumin.substring(2, 3)) * 4;
			int num04 = Integer.parseInt(strJumin.substring(3, 4)) * 5;
			int num05 = Integer.parseInt(strJumin.substring(4, 5)) * 6;
			int num06 = Integer.parseInt(strJumin.substring(5, 6)) * 7;
			int num07 = Integer.parseInt(strJumin.substring(6, 7)) * 8;
			int num08 = Integer.parseInt(strJumin.substring(7, 8)) * 9;
			int num09 = Integer.parseInt(strJumin.substring(8, 9)) * 2;
			int num10 = Integer.parseInt(strJumin.substring(9, 10)) * 3;
			int num11 = Integer.parseInt(strJumin.substring(10, 11)) * 4;
			int num12 = Integer.parseInt(strJumin.substring(11, 12)) * 5;
			
			int lastNum = Integer.parseInt(strJumin.substring(12, 13));
			
			int sum = num01 + num02 + num03 + num04 + num05 + num06 + num07 + num08 + num09 + num10 + num11 + num12;
			
			int resultNum = (11 - (sum % 11)) % 10;
			
			if(lastNum == resultNum) {
				System.out.println("주민등록 형식이 맞음");
			} else {
				System.out.println("주민등록 형식이 아님");
			}
		}
		

	}

}
