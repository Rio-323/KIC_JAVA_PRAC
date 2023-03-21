import java.io.IOException;
public class ProcessBuilderEx01 {

	public static void main(String[] args) throws IOException {
		// ProcessBuilder processBuilder = new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe", "www.google.com");
		// processBuilder.start();
		
		// 메모장 실행시켜보기		
		ProcessBuilder processBuilder2 = new ProcessBuilder("C:\\Windows\\System32\\notepad.exe");
		processBuilder2.start();
	}

}
