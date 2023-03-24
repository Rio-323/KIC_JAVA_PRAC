import java.io.File;
import java.io.IOException;
import java.util.Date;

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
		
		// 생성(수정) 일자
		// 파일 크기
		System.out.println(file.length());
		// timeStamp
		System.out.println(file.lastModified());
		
		Date data = new Date(file.lastModified());
		System.out.println(data.toLocaleString());
	}

}
