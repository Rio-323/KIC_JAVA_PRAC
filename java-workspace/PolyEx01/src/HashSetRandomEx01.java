import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HashSetRandomEx01 {

	public static void main(String[] args) {
//		Set<Integer> hset = new HashSet<Integer>();
//		Random r = new Random();
//		
//		for(int i = 0; i < 6; i++) {
//			if(hset.size() < 6) {
//				hset.add(r.nextInt(45) + 1);
//			}
//		}
//		
//		for(int data : hset) {
//			System.out.print(data + "\t");
//		}
		
		Random r = new Random(System.currentTimeMillis());
//		System.currentTimeMillis()는 현재 시간을 밀리초(milliseconds) 단위로 반환하는 Java의 메서드입니다.
//
//		Random 클래스의 생성자는 시드(seed)값을 받아서 무작위 수 생성을 시작합니다. 시드값이 같으면 생성된 무작위 수의 순서가 항상 같기 때문에, 
//		일반적으로 시드값을 변화시키기 위해 현재 시간을 사용합니다.
//
//		즉, Random(System.currentTimeMillis())는 현재 시간을 시드값으로 사용하여 Random 클래스의 객체를 생성하는 것입니다. 
//		이렇게 함으로써 매번 실행할 때마다 다른 시드값으로 무작위 수를 생성할 수 있습니다.
		
		
		
		HashSet<Integer> lottos = new HashSet<>();
		
		for(int i = 1; i <= 5; i++) {
			
			// 무한 루프
			while(true) {
				lottos.add(r.nextInt(45) + 1);
				if(lottos.size() == 6) {
					break;
				}
			}
			
			System.out.println(lottos.toString());
			// set 비우기
			lottos.clear();
		}
	}

}
