import java.io.File;

public class FileEx02 {

	public static void main(String[] args) {
		File file1 = new File("C:/java");
		System.out.println(file1.exists());
		
		File file2 = new File("C:/java/test1.txt");
		System.out.println(file2.exists());
		
		System.out.println(file2.isDirectory());
		System.out.println(file2.isFile());
		
		System.out.println(file2.isHidden());
	}

}
