import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyEx02 {

	public static void main(String[] args) {
		
		// 속도를 향상시키기 위해 사용
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/IOEx01/src/image1.png"));
			bos = new BufferedOutputStream(new FileOutputStream("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/IOEx01/src/image2.png"));
			
			
			int data = 0;
			while((data = bis.read()) != -1) {
				bos.write(data);
			}
			
			System.out.println("복사 성공");
		} catch (FileNotFoundException e) {
			System.out.println("[Errpr] : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[Errpr] : " + e.getMessage());
		}finally {
			if(bis != null) try { bos.close(); bis.close(); } catch (IOException e) { System.out.println("[Errpr] : " + e.getMessage()); }
		}
	}

}
