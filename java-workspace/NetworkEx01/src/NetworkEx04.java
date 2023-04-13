import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkEx04 {

	public static void main(String[] args) {
		InputStream is = null;
		
		try {
			URL url = new URL("https://m.naver.com");
			is = url.openStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8")); 
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { if(is != null) { try { is.close(); } catch (IOException e) { e.printStackTrace(); }}
		}
	}
}
