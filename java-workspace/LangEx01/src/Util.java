
public class Util {
	private String name;

	public Util(String name) {
		this.name = name;
	}

	public String capitalizeName() {
		String[] strArr = this.name.split(" ");
		String result = "";
		
		for (int i = 0; i < strArr.length; i++) {
			result += strArr[i].substring(0,1).toUpperCase() + strArr[i].substring(1) + " ";
		}
		
		return result;
	}
}
