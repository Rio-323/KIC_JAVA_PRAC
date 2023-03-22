import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

public class PropertiesEx01 {

	public static void main(String[] args) {
		// HashMap 게열
		// <String, String>
		Properties prop = new Properties();
		prop.setProperty("timeout", "30");
		prop.setProperty("language", "kor");
		prop.setProperty("size", "10");
		
		System.out.println(prop);
		System.out.println(prop.size());
		
		Enumeration e = prop.propertyNames();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		
		Set<String> names = prop.stringPropertyNames();
		for(String name : names) {
			System.out.println(name);
		}
	}

}
