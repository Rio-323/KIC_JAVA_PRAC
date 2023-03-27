import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FilesEx02 {

	public static void main(String[] args) {
		Path target = Paths.get("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/IOEx01/src/서초구.txt");
		
		try {
			List<String> lines = Files.readAllLines(target);
			
			for(String line : lines) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		}
	}

}
