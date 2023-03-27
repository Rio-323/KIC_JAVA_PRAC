import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;
import java.util.Set;

public class PropertiesTestWithFile {
	private final static String PROP_FILE_PATH = "./config.properties";
	
	private static void saveToFile() {
		Properties props = new Properties();
		props.setProperty("id", "andy");
		props.setProperty("pass", "1234");
		props.setProperty("addr", "192.168.0.2");
		props.setProperty("이름", "홍길동");
		System.out.println("속성 확인 : " + props);
		
		try(FileWriter output = new FileWriter(PROP_FILE_PATH)) {
			props.store(output, "System Config");
		} catch(Exception e) {
			System.out.println("[Error] : " + e.getMessage());
		}
	}
	
	private static void loadFromFile() {
		Properties props = new Properties();
		try(FileReader input = new FileReader(PROP_FILE_PATH)) {
			props.load(input);
			Set<String> keys = props.stringPropertyNames();
			
			for(String key : keys) {
				System.out.println(key + " : " + props.getProperty(key));
			}
		} catch(Exception e) {
			System.out.println("[Error] : " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		saveToFile();
		loadFromFile();

	}

}
