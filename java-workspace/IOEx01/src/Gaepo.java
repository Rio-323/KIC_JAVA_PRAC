import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Gaepo {

	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력하실 동 이름을 작성해주세요 : ");
		String dongName = sc.nextLine();
		
		if(dongName.length() < 2) {
			System.out.println("2글자 이상 입력해주세요. (프로그램을 종료합니다.)");
			sc.close();
			System.exit(0);
		} else {
			System.out.println("txt파일이 생성되었습니다.");
		}
		
		
		
		try {
			br = new BufferedReader(new FileReader("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/IOEx01/src/subject.csv"));
			bw = new BufferedWriter(new FileWriter("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/IOEx01/src/donName.txt"));
			
			String str = "";
			while ((str = br.readLine()) != null) {
                if (str.contains(dongName)) {
                	str = str.replace(",", " ");
                	bw.write(str + System.lineSeparator());
                }
            }
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally {
			try { br.close(); bw.close(); } catch (IOException e) { System.out.println("[Error] : " + e.getMessage()); }
		}

	}

}
