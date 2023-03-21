
public class SystemEx02 {

	public static void main(String[] args) {
		// timeStamp
		System.out.println(System.currentTimeMillis());
		System.out.println(System.nanoTime());
		
		long time1 = System.currentTimeMillis();
		
		int sum = 0;
		for(int i = 0; i < 1_000_000; i++) {
			sum += i;
		}
		
		long time2 = System.currentTimeMillis();
		System.out.println("실행시간 : " + (time2 - time1));
	}

}
