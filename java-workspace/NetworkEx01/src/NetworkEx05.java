import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkEx05 {

	public static void main(String[] args) {
		InputStream is = null;
		
		try {
			URL url = new URL("https://news.daum.net/");
			is = url.openStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8")); 
			String line = null;
			boolean flag = false;
			while ((line = br.readLine()) != null) {
				// <ul class="list_newsissue">
				// </ul>
				// equals
				// contains / startsWith / endsWith
				// index of
				
				// class="link_txt" data-tiara-layer="article_main"
				// </a>
				
                
//				if(line.contains("<ul class=\"list_newsissue\">")) {
//					flag = true;
//				} else if(line.contains("</ul>")) {
//					flag = false;
//				}
				
				if(line.contains("class=\"link_txt\" data-tiara-layer=\"article_main\"")) {
					flag = true;
				} else if(line.contains("</a>")) {
					flag = false;
				}
				
				if(flag) {
					System.out.println(br.readLine().trim());
					System.out.println();
				}
				
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { if(is != null) { try { is.close(); } catch (IOException e) { e.printStackTrace(); }}
		}
	}
}
