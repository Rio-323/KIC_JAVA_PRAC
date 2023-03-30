import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LottoStatistics {

	public static void main(String[] args) {
		BufferedReader br = null;
		int[] counts = new int[45];
		
		try {
			br = new BufferedReader(new FileReader("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/IOEx01/src/lotto(1~1059).csv"));
			
			String str = "";
			while ((str = br.readLine()) != null) {
				str = str.replace(".", "");
				String[] arr = str.split(",");
				
				for(int i = 0; i < arr.length; i++) {
					int number = Integer.parseInt(arr[i]);
					if(number >= 1 && number <= 45) {
						counts[number - 1]++;
					}
				}
			}
			
			for(int i = 0; i < counts.length; i++) {
				System.out.println((i+1) + ": " + counts[i] + "\n");
			}
			
			System.out.println("출력완료");
			
		} catch (FileNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally { try { if (br != null) br.close(); } catch (IOException e) {System.out.println("[Error] : " + e.getMessage());} }
	}

}

