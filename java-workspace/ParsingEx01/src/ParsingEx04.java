import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParsingEx04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		
		try {
			URLConnection conn = new URL( "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20230409" ).openConnection();
			br = new BufferedReader( new InputStreamReader( conn.getInputStream() ) );
				
			String line = br.readLine();
				
			JSONParser parser = new JSONParser();
			JSONObject root = (JSONObject)parser.parse( line );
				
			JSONObject boxOfficeResult = (JSONObject)root.get( "boxOfficeResult" );
			JSONArray weeklyBoxOfficeLists = (JSONArray)boxOfficeResult.get( "weeklyBoxOfficeList" );
				
			for( int i=0 ; i<weeklyBoxOfficeLists.size() ; i++ ) {
				JSONObject weeklyBoxOffice = (JSONObject)weeklyBoxOfficeLists.get( i );
				System.out.printf( "%s\t%s\t%s%n", weeklyBoxOffice.get( "rank" ), weeklyBoxOffice.get( "movieCd" ), weeklyBoxOffice.get( "movieNm" ) );
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( br != null ) try { br.close(); } catch ( IOException e ) {}
		}

	}
}

		
		    
	