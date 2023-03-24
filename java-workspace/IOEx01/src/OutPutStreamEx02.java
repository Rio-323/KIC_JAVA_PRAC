import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutPutStreamEx02 {

	public static void main(String[] args) {
		// FileOutputStream fos = null;
		
		BufferedOutputStream bos = null;
		
		try {
			// fos = new FileOutputStream("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/IOEx01/src/test2.txt", true);
			bos = new BufferedOutputStream(new FileOutputStream("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/IOEx01/src/test2.txt", true));
			
			bos.write('a');
			bos.write('b');
			bos.write('\n');
			bos.write('c');
			// 출력 내용 없음
			// 파일이 없으면 만듬.
			System.out.println("출력완료");
		} catch (FileNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally {
			if(bos != null) try { bos.close(); } catch (IOException e) { e.printStackTrace();}
		}

	}

}
