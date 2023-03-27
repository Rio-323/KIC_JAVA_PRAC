import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {

	public static void main(String[] args) {
		File target = new File("./Person.dat");
		
		Person1 person1 = new Person1("홍길동", 20, "111111-2222222", "hong", "1234");
		
		Object readed;
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(target));
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(target));
			
			oos.writeObject(person1);
			readed = ois.readObject();
			
			if(readed != null && readed instanceof Person1) {
				Person1 casted = (Person1)readed;
				System.out.println(casted);
			}
		} catch (FileNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		}
		
	}

}
