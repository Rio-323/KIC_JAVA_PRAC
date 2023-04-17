import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSonEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//{} => 동종의 데이터 
		String strJson = "{\"data1\" :[1, 2, 3, 4], \"data2\" : [\"10\",\"20\",\"30\",\"40\"]}";
		
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject obj = (JSONObject)parser.parse(strJson);
			
			JSONArray arr1 = (JSONArray)obj.get("data1");
			System.out.println(arr1);
			
			JSONArray arr2 = (JSONArray)obj.get("data2");
			System.out.println(arr2);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
