import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterEx02 {

	public static void main(String[] args) {
		BufferedWriter bw = null;
		
		try {
			// 가속화된 출력
			bw = new BufferedWriter(new FileWriter("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/IOEx01/src/test2.txt"));
			
			bw.write("abc");
			bw.write("\n");
			bw.write("cde");
			bw.write("\n");
			bw.write("가나다");
			
			System.out.println("출력 완료");
		} catch (IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally {
			try { bw.close(); } catch (IOException e) { System.out.println("[Error] : " + e.getMessage()); }
		}

	}

}
