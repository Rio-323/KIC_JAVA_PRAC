import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {
	List<Object> list = new ArrayList<>();
	List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
	
	public void createTest() {
		list.add("Hello");
		list.add("Hello"); // 동일 데이터 추가
		list.add(null); // null 추가
		list.addAll(integers); // 다른 Collection요소 추가
		list.add(integers); // 다른 Collection 추가
		list.add(0, new Object()); // 끼워 넣기
		System.out.println("추가 후 내용 출력 : " + list);
	}
	
	public void retrieveTest() {
		// 반복을 이용한 요소 조회
		for(int i = 0; i < list.size(); i++) { // 리스트 조회
			System.out.println(i + " : " +list.get(i));
		}
		
		// 포함 여부 활용
		if(list.contains("Hello")) { // 객체의 포함 여부
			System.out.println("Hello의 위치는 : " + list.indexOf("Hello")); // 객체의 위치 조회
		}
		// 서브 리스트 활용
		List<Object> sub = list.subList(3, 5);
		System.out.println("sub의 내용 : " + sub);
		System.out.println("sub의 내용을 다가지고 있는가? : " + list.containsAll(sub));
	}
	
	public void updateTest() {
		list.set(1, "updated");
		System.out.println("업데이트 후 : " + list);
	}
	
	public void deleteTest() {
		list.remove(0); // 특정 위치의 객체 삭제
		list.remove("Hello"); // 특정 객체가 있다면 처음 객체 삭제
		// 타입이 Integer인 경우 삭제
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) instanceof Integer) {
				list.remove(i);
			}
		}
		
		System.out.println("삭제 후 : " + list);
		list.clear(); // 리스트 초기화
		System.out.println("초기화 후 : " + list);
	}
	
	public static void main(String[] args) {
		ArrayListTest alt = new ArrayListTest();
		alt.createTest();
		alt.retrieveTest();
		alt.updateTest();
		alt.deleteTest();
	}
	
//	결과값에서는 2, 4, [1, 2, 3, 4, 5]가 남아있는 것을 확인할 수 있는데, 
//	이는 remove 메서드를 활용하여 list에서 타입이 Integer인 데이터를 삭제할 때 발생하는 문제입니다. 
//	인덱스 2에서 2가 삭제되면서, 그 이후의 데이터들의 인덱스가 하나씩 당겨져서 4가 3의 인덱스로 바뀌게 되고, 
//	subList를 활용하여 추출한 리스트는 이와 같은 변화에 따라 원래 의도했던 데이터가 아닌 다른 데이터가 포함되게 됩니다. 
//	이러한 문제는 remove 메서드를 활용하는 대신 Iterator나 for-each문 등을 활용하여 데이터를 삭제하는 것으로 해결할 수 있습니다.
	
}
