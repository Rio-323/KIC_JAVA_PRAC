import java.io.File;

public class FileEx01 {

	public static void main(String[] args) {
		// File
		// 파일 / 디렉토리
		// 경로 - 절대경로 / 상대경
		File file1 = new File("C:\\java");
		
		// 절대경로
		File file2 = new File("./java");
		File file3 = new File("./test.txt");
		
		File file4 = new File("c:/java/test.txt");
		
		File file5 = new File("c:/java/", "test.txt");
	}

}
