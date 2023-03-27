import java.io.Serializable;

public class LoginInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userId;
	private transient String userPass;
	
	public LoginInfo(String userId, String userPass) {
		super();
		this.userId = userId;
		this.userPass = userPass;
	}

	@Override
	public String toString() {
		return "LoginInfo [userId = " + userId + ", userPass = " + userPass + "]";
	}
}
