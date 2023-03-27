import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamEx01 {

	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("./object.dat"));
			
			String[] names = {"홍길동", "박문수", "이몽룡"};
			int[] ages = {55, 23, 47};
			double[] weights = {71.4, 67.9, 58.6};
			
			oos.writeObject(names);
			oos.writeObject(ages);
			oos.writeObject(weights);
			
			System.out.println("출력 완료");
		} catch (FileNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		}finally { if(oos != null) try { oos.close(); } catch (IOException e) { System.out.println("[Error] : " + e.getMessage()); } }
	}

}
