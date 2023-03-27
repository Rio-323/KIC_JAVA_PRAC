import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectOutputStreamEx02 implements Serializable {

	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("./object2.dat"));
			
			Person p = new Person("홍길동", "010-111-1111", "20", "서울시");
			Person p1 = new Person("박문수", "010-222-2222", "20", "서울시");
			Person p2 = new Person("임꺽정", "010-333-3333", "20", "서울시");
			
			oos.writeObject(p);
			oos.writeObject(p1);
			System.out.println("출력 완료");
		} catch (FileNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally { if(oos != null) try { oos.close(); } catch (IOException e) { System.out.println("[Error] : " + e.getMessage()); } }
	}

}
