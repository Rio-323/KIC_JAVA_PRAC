import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class HashMapEx02 {

	public static void main(String[] args) {
		HashMap<String, String> hm = new HashMap<>();
		hm.put("a", "홍길동");
		hm.put("b", "박문수");
		hm.put("c", "이몽룡");
		
		Set<String> keys = hm.keySet();
		
		System.out.println(keys);
		
		for(String key : keys) {
			System.out.println(key + " : " + hm.get(key));
		}
		
		Collection<String> values = hm.values();
		
		for(String value : values) {
			System.out.println(value);
		}
	}

}
