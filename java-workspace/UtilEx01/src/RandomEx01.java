import java.util.Random;

public class RandomEx01 {

	public static void main(String[] args) {
		// seeding
		Random r1 = new Random(System.currentTimeMillis());
		System.out.println(r1); // 참조값
		
		System.out.println(r1.nextInt());
		System.out.println(r1.nextInt(10));
		System.out.println(r1.nextInt(45) + 1);
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 6; j++) {
				System.out.print((r1.nextInt(45) + 1) + "\t");
			}
			System.out.println();
		}
	}

}
