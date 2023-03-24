import java.io.File;
import java.io.IOException;

public class FileEx03 {

	public static void main(String[] args) {
		File file = new File("c:/java/test1.txt");
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getPath());
		
		File file1 = new File("./");
		System.out.println(file1.getPath());
		
		try {
			// 절대 경로를 알려줌.
			System.out.println(file1.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
