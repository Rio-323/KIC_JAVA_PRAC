import java.util.ArrayList;

public class ArrayListEx02 {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(5);
		
		for (int i = 0; i < al.size(); i++) {
			if(al.get(i) instanceof Integer) {
				// System.out.println(al.get(i));
				
				al.remove(i);
			}
		}
		
		System.out.println(al);
	}

}
