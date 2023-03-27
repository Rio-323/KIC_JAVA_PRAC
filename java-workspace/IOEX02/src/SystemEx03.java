import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SystemEx03 {

	public static void main(String[] args) {
		// 키보드 입력	
		// InputStream is = null;
		// InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			// is = System.in;
			// isr = new InputStreamReader(System.in);
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("데이터 입력 : ");
//			System.out.println((char)br.read());
//			System.out.println((char)br.read());
//			System.out.println((char)br.read());
			
			System.out.println(br.readLine());
			
			System.out.println("입력완료");
		} catch (IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally { if(br != null) try { br.close(); } catch (IOException e) { System.out.println("[Error] : " + e.getMessage()); } }
	}

}
