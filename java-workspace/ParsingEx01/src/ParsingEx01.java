import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ParsingEx01 {

	public static void main(String[] args) {
		// parsing - 문서분석
		BufferedReader br = null;
		try {
			URLConnection conn = new URL("https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=f5eef3421c602c6cb7ea224104795888&targetDt=20230413").openConnection();
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line = br.readLine();
			// System.out.println(line);
			
			line = line.replaceAll("><", ">\n<");
			// System.out.println(line);
			
			String[] lines = line.split("\n");
			
			for(String data : lines) {
				if(data.trim().startsWith("<rank>")) {
					System.out.print(data.trim().replaceAll("<rank>", "").replaceAll("</rank>", "") + "\t");
				}
				
				if(data.trim().startsWith("<movieNm>")) {
					System.out.println(data.trim().replaceAll("<movieNm>", "").replaceAll("</movieNm>", ""));
				}
			}
			
		} catch (MalformedURLException e) {
			System.out.println("[Error]" + e.getMessage());
		} catch (IOException e) {
			System.out.println("[Error]" + e.getMessage());
		} finally { 
			if(br != null) { try { br.close(); } catch (IOException e) { System.out.println("[Error]" + e.getMessage()); }}
		}
	}

}
