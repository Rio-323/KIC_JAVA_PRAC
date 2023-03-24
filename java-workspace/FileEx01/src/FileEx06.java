import java.io.File;
import java.io.IOException;

public class FileEx06 {

	public static void main(String[] args) {
		// 디렉토리 관련
		// mkdir() - make directory
		File file = new File("c:/java/dir1");
		File file1 = new File("c:/java/dir2");
//		if(file.mkdir()) {
//			System.out.println("성공");
//		} else {
//			System.out.println("실패");
//		}
		
		// file.renameTo(file1);
		
		// file1.delete();
		
		
		try {
			File file2 = new File("c:/java/test2.txt");
			file2.createNewFile();
			System.out.println("파일 생성");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
