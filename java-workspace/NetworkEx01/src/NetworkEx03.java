import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkEx03 {

	public static void main(String[] args) {
		InputStream is = null;
		
		try {
			URL url = new URL("https://m.naver.com");
			is = url.openStream();
			
			int data = 0;
			while((data = is.read()) != -1) {
				System.out.print((char)data);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { if(is != null) { try { is.close(); } catch (IOException e) { e.printStackTrace(); }}
		}
	}
}
