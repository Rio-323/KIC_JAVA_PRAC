import java.io.CharArrayReader;
import java.io.IOException;
import java.util.Arrays;

public class CharArrayReaderEx01 {

	public static void main(String[] args) {
		
		// 메모리에서 스트림 기능이 가능
		char[] memory = {'안', '녕', ' ', 'j', 'a', 'v', 'a'};
		
		try(CharArrayReader charArray = new CharArrayReader(memory)) {
			char[] buffer = new char[5];
			
			int read = 0;
			while((read = charArray.read(buffer)) > 0) {
				System.out.println(Arrays.toString(buffer));
			}
		} catch(IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		}
	}

}
