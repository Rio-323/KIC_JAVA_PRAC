import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SystemEx04 {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("시작 단수 : ");

			int startDan = Integer.parseInt(br.readLine());
			
			System.out.print("끝 단수 : ");
			
			int endDan = Integer.parseInt(br.readLine());
			System.out.println();
			
			for(int i = startDan; i <= endDan; i++) {
				for(int j = 1; j < 10; j++) {
					System.out.println(i + " X " + j + " = " + (i*j));
				}
				System.out.println();
			}
			
			System.out.println("입력완료");
		} catch (IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally { if(br != null) try { br.close(); } catch (IOException e) { System.out.println("[Error] : " + e.getMessage()); } }
	}

}
