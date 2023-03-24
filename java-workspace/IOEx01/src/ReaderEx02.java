import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderEx02 {

	public static void main(String[] args) {
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/IOEx01/src/test1.txt"));
			
			// 1자
//			int data = 0;
//			while((data = br.read()) != -1) {
//				System.out.println((char)data);
//			}
			
			// br.readLine() - 엔터키까지 기준
			
			String str = "";
			
			while((str = br.readLine()) != null) {
				System.out.println(str);
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
