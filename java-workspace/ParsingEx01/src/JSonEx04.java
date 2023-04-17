import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSonEx04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//{} => 동종의 데이터 
		String strJson = "[{\"name\" : \"홍길동\", \"city\" : \"서울\"}, {\"name\" : \"박문수\", \"city\" : \"경기\"}]";
		
		JSONParser parser = new JSONParser();
		
		try {
			JSONArray arr = (JSONArray) parser.parse(strJson);
			
			for(int i=0; i<arr.size(); i++) {
				JSONObject object =(JSONObject)arr.get(i);			
			
			String name = (String)object.get("name");
			System.out.println(name);
			
			String city =(String)object.get("city");
			System.out.println(city);
			}
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
	}
		
	}
