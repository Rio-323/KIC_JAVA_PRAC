import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutPutStreamEx01 {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/IOEx01/src/test2.txt");
			
			
			fos.write('a');
			fos.write('b');
			fos.write('\n');
			fos.write('c');
			// 출력 내용 없음
			// 파일이 없으면 만듬.
			System.out.println("출력완료");
		} catch (FileNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally {
			try { fos.close(); } catch (IOException e) { e.printStackTrace();}
		}

	}

}
