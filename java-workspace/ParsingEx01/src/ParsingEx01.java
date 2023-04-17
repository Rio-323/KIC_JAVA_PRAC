import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MulticastSocket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.MalformedInputException;

import javax.sound.sampled.Line;

public class ParsingEx01 {
	
	public static void main(String[] args) {
		// parsing - 문서 분석
		
		BufferedReader br = null;
		
		try {
			URLConnection conn = new URL("https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.xml?key=f5eef3421c602c6cb7ea224104795888&targetDt=20230409").openConnection();
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line = br.readLine();
			
			line = line.replaceAll("><", ">\n<");
			System.out.println(line);
		   
		    
		    String[] lines = line.split("\n"); 		    
		    for(String data1 : lines) {
		    	if(data1.trim().startsWith("<rank>")) {
		    		System.out.println(
		    				data1.trim().replaceAll("<rank>", "")
		    				.replaceAll("</rank>", ""));
		    	}
		    	if(data1.trim().startsWith("<movieNm>")) {
		    		System.out.println(data1.trim()
		    				.replaceAll("<moiveNm>", "")
		    				.replaceAll("</movieNm>", ""));
		    	}
		    }
		    
		    
		} catch (MalformedInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(br != null) try {br.close();} catch(IOException e) {}
		}
	}

}
