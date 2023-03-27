import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx01 {

	public static void main(String[] args) {
		RandomAccessFile raf = null;
		
		try {
			// read / write
			raf = new RandomAccessFile("./score.dat", "rw");
			
			int[] scores = {
					1, 100, 90, 90,
					2, 7, 90, 100,
					3, 100, 100, 100
			};
			
			for (int i = 0; i < scores.length; i++) {
				raf.writeInt(scores[i]);
				System.out.println("파일 포인터 : " + raf.getFilePointer());
			}
			
			System.out.println("저장 완료");
			
			raf.seek(0);
			
			while(true) {
				System.out.println(raf.readInt());
			}
		} catch (EOFException e) {
			System.out.println("읽기 종료");
		} catch (FileNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally { if(raf != null) try { raf.close(); } catch (IOException e) { System.out.println("[Error] : " + e.getMessage()); } }
	}

}
