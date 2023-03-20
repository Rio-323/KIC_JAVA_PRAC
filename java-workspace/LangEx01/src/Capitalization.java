
public class Capitalization {
	public static void main(String[] args) {
//		String data = "hong gil dong";
//		String[] strArr = data.split(" ");
//		String result = "";
//		
//		for (int i = 0; i < strArr.length; i++) {
//			result += strArr[i].substring(0,1).toUpperCase() + strArr[i].substring(1) + " ";
//		}
//		
//		System.out.println(result);
		
		Util u = new Util("hong gil dong");
		System.out.println(u.capitalizeName());
	}
}
