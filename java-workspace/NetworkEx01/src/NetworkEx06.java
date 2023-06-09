import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetworkEx06 {

	public static void main(String[] args) {
		BufferedReader br = null;
		
		try {
//			URLConnection conn = new URL("https://news.daum.net/").openConnection();
			
			HttpURLConnection conn = (HttpURLConnection)new URL("https://news.daum.net/").openConnection();
			
//			int responseCode = conn.getResponseCode();
//			System.out.println(responseCode); // ex) 404오류 코드
			
			if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				System.out.println(conn.getRequestMethod());
				System.out.println(conn.getResponseMessage());
				
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
			} else {
				System.out.println("접속 에러");
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
