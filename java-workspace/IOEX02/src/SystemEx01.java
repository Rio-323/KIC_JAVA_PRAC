import java.io.IOException;
import java.io.InputStream;

public class SystemEx01 {

	public static void main(String[] args) {
		// 키보드 입력	
		InputStream is = null;
		try {
			is = System.in;
			System.out.print("데이터 입력 : ");
			System.out.println((char)is.read());
			System.out.println((char)is.read());
			System.out.println((char)is.read());
			
			System.out.println("입력완료");
		} catch (IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally { if(is != null) try { is.close(); } catch (IOException e) { System.out.println("[Error] : " + e.getMessage()); } }
	}

}
