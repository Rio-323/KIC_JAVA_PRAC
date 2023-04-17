import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSonEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//{} => 동종의 데이터 
		String strJson = "{\"data1\" : \"value1\", \"data2\" : \"value2\"}";
		
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject obj = (JSONObject)parser.parse(strJson);
			
			String data1 = (String)obj.get("data1");
			System.out.println(data1);
			
			String data2 = (String)obj.get("data2");
			System.out.println(data2);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
