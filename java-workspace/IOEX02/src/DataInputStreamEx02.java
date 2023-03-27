import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInputStreamEx02 {

	public static void main(String[] args) {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream("./value.dat"));
			
			System.out.println(dis.readInt());
			System.out.println(dis.readUTF());
			System.out.println(dis.readFloat());
		} catch (FileNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally { if(dis != null) try { dis.close(); } catch (IOException e) { System.out.println("[Error] : " + e.getMessage()); } }
	}

}
