import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStreamEx02 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/IOEx01/src/test1.txt");
			
			// 전체 파일 내용 읽기
			int data = 0;
			while((data = fis.read())!= -1) {
				System.out.print((char)data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try { fis.close(); } catch (IOException e) { e.printStackTrace();}
		}
	}

}
