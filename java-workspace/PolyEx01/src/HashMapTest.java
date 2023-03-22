import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
	Map<String, String> hMap = new HashMap<>();
	
	private void addMethod() {
		System.out.println("추가 결과 : " + hMap.put("andy", "1234"));
		System.out.println("추가 결과 : " + hMap.put("andy", "4567"));
		hMap.put("henry", "4567");
		hMap.put("kate", "9999");
		System.out.println(hMap);
	}
	
	private void retrieveMethod() {
		System.out.println("총 Entity 개수 : " + hMap.size());
		
		Set<String> keys = hMap.keySet();
		
		for(String key : keys) {
			System.out.println("키 : " + key + ", 값 : " + hMap.get(key));
		}
		
		String targetNumber = "4567";
		Set<Map.Entry<String, String>> entrySet = hMap.entrySet();
		
		for(Map.Entry<String, String> entry : entrySet) {
			if(entry.getValue().equals(targetNumber)) {
				System.out.println("번호가 " + targetNumber + "인 사람 " + entry.getKey());
			}
		}
		
		System.out.println("kate의 전화번호가 있는가? " + hMap.containsKey("kate"));
	}
	
	private void removeMetod() {
		hMap.remove("andy");
		System.out.println(hMap);
	}

	public static void main(String[] args) {
		HashMapTest hmt = new HashMapTest();
		hmt.addMethod();
		hmt.retrieveMethod();
		hmt.removeMetod();
	}

}
