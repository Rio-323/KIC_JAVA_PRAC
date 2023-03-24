import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyEx01 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/IOEx01/src/image1.png");
			fos = new FileOutputStream("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/IOEx01/src/image2.png");
			
			int data = 0;
			while((data = fis.read()) != -1) {
				fos.write(data);
			}
			
			System.out.println("복사 성공");
		} catch (FileNotFoundException e) {
			System.out.println("[Errpr] : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[Errpr] : " + e.getMessage());
		}finally {
			if(fos != null) try { fos.close(); fis.close(); } catch (IOException e) { System.out.println("[Errpr] : " + e.getMessage()); }
		}
	}

}
