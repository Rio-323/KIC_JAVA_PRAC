import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetworkEx06 {

	public static void main(String[] args) {
		BufferedReader br = null;
		
		try {
			URLConnection conn = new URL("https://news.daum.net/").openConnection();
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null;
			
			boolean flag = false;
			while((line = br.readLine()) != null) {
				
				if(line.contains("class=\"link_txt\" data-tiara-layer=\"article_main\"")) {
					flag = true;
				} else if(line.contains("</a>")) {
					flag = false;
				}
				
				if(flag) {
					System.out.println(br.readLine().trim() + System.lineSeparator());
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { 
			if(br != null) { try { br.close(); } catch (IOException e) { e.printStackTrace(); }}
		}
	}
}
