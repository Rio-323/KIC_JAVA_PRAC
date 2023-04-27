package pack1;

public class MemberDTO {
	private String id;
	private String password;
	
	public String getId() {
		System.out.println("getId() 호출");
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		System.out.println("getPassword() 호출");
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
