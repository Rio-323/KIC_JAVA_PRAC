import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStreamEx03 {
	public static void main(String[] args) {
		
		// FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		try {
			// fis = new FileInputStream("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/IOEx01/src/test1.txt");
			// bis = new BufferedInputStream(fis);
			bis = new BufferedInputStream(new FileInputStream("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/IOEx01/src/test1.txt"));
			
			int data = 0;
			while((data = bis.read()) != -1) {
				System.out.println((char)data);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally {
			if(bis != null) try { bis.close(); } catch (IOException e) { System.out.println("[Error] : " + e.getMessage()); }
		}
		
		
	}
}
