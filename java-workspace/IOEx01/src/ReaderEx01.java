import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderEx01 {

	public static void main(String[] args) {
		FileReader br = null;
		
		try {
			br = new FileReader("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/IOEx01/src/test1.txt");
			
			int data = 0;
			while((data = br.read()) != -1) {
				System.out.println((char)data);
			}
		} catch (FileNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally {
			try { br.close(); } catch (IOException e) { System.out.println("[Error] : " + e.getMessage()); }
		}

	}

}
