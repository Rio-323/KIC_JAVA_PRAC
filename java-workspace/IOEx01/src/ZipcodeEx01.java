import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ZipcodeEx01 {

	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			br = new BufferedReader(new FileReader("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/IOEx01/src/subject.csv"));
			bw = new BufferedWriter(new FileWriter("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/IOEx01/src/서초구.txt"));
			
			String str = "";
			while ((str = br.readLine()) != null) {
                if (str.contains("서초구")) {
                	str = str.replace(",", " ");
                	bw.write(str + System.lineSeparator());
                }
            }
			
		} catch (FileNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally {
			try { br.close(); bw.close(); } catch (IOException e) { System.out.println("[Error] : " + e.getMessage()); }
		}

	}

}
