import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
	Set<Object> hset = new HashSet<Object>();
	
	private void addMethod() {
		hset.add(Integer.valueOf(1));
		hset.add("Hello");
		hset.add("Hello");
		hset.add(null);
		hset.add(1);
		hset.add(new Phone("010-000-1234"));
		hset.add(new Phone("010-000-1234"));
		System.out.println("데이터 결과 추가 : " + hset);
	}
	
	private void retrieveMethod() {
		System.out.println("데이터 개수 : " + hset.size());
		
		for(Object sobj : hset) {
			System.out.println("데이터 조회 : " + sobj);
		}
	}
	
	private void removeMethod() {
		hset.remove("Hello");
		System.out.println("데이터 삭제 결과 : " + hset);
	}

	public static void main(String[] args) {
		HashSetTest hst = new HashSetTest();
		hst.addMethod();
		hst.retrieveMethod();
		hst.removeMethod();
	}

}
