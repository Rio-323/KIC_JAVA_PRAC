import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStreamEx01 {
	public static void main(String[] args) {
		// FileInputStream - input / byte / 1차 스트림
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/IOEx01/src/test1.txt");
			
			int data = fis.read();
			System.out.println(data);
			System.out.println((char)data);
			
			data = fis.read();
			System.out.println((char)data);
			
			byte[] datas = new byte[5];
			fis.read(datas);
			System.out.println((char)datas[0]);
			System.out.println((char)datas[4]);
			
		} catch (FileNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally {
			try { fis.close(); } catch (IOException e) { System.out.println("[Error] : " + e.getMessage()); }
		}
		
		
	}
}
