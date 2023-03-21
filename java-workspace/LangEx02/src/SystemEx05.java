
public class SystemEx05 {

	public static void main(String[] args) {
		int[] src = {1, 2, 3, 4, 5};
		
		// shadow copy - 주소값 복사
		int[] dest1 = src;
		System.out.println(src[0]);
		System.out.println(dest1[0]);
		
		// System.arraycopy
		int[] dest2 = {0, 0, 0, 0, 0};
		System.arraycopy(src, 0, dest2, 0, src.length);
		
		for(int i = 0; i < dest2.length; i++) {
			System.out.println(dest2[i]);
		}
		
		System.out.println(src);
		System.out.println(dest2);
	}

}
