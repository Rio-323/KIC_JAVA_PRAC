import java.util.Properties;
import java.util.Set;

public class PropertiesEx02 {

	public static void main(String[] args) {
		Properties prop = System.getProperties();
		
		Set<String> names = prop.stringPropertyNames();
		for(String name : names) {
			System.out.println(name);
		}
		
		// Eclipse JRE버전을 가지고옴
		System.out.println(System.getProperty("java.version"));
		System.out.println(System.getProperty("java.home"));
	}

}
