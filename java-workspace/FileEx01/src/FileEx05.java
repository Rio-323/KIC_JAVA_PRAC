import java.io.File;

public class FileEx05 {

	public static void main(String[] args) {
		File file = new File("c:/java");
		
		String[] lists = file.list();
		
		for(String list : lists) {
			File subdir = new File("c:/java", list);
			
			if(subdir.isDirectory()) {
				System.out.println("[" + list + "]");
			} else {
				System.out.println(list);
			}
		}
	}

}
