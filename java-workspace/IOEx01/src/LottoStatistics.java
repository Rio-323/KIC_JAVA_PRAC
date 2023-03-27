import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LottoStatistics {

	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		int[] counts = new int[45];
		
		try {
			br = new BufferedReader(new FileReader("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/IOEx01/src/lotto(1~1059).csv"));
			bw = new BufferedWriter(new FileWriter("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/IOEx01/src/lottostatistics.txt"));
			
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
				bw.write((i+1) + ": " + counts[i] + "\n");
			}
			
			System.out.println("Statistics generated successfully");
			
		} catch (FileNotFoundException e) {
			System.err.println("Error: file not found");
		} catch (IOException e) {
			System.err.println("Error: could not read/write file");
		} finally { try { if (br != null) br.close(); if (bw != null) bw.close(); } catch (IOException e) { System.err.println("Error: could not close file"); } }
	}

}

