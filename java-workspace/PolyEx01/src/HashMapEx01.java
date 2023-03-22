import java.util.HashMap;

public class HashMapEx01 {

	public static void main(String[] args) {
		HashMap<String, String> hm = new HashMap<>();
		hm.put("a", "홍길동");
		hm.put("b", "박문수");
		hm.put("c", "이몽룡");
		
		System.out.println(hm);
		System.out.println(hm.size());
		
		hm.put("d", "장길산");
		System.out.println(hm);
		System.out.println(hm.size());
		
		hm.put("c", "임꺽정");
		System.out.println(hm);
		
		System.out.println(hm.get("a"));
		System.out.println(hm.get("b"));
		
		hm.remove("c");
		System.out.println(hm);
		
		hm.clear();
		System.out.println(hm);
	}

}
