import java.io.Serializable;

public class Person1 implements Serializable {
	private static final long serialVersionUID = 3075830113306886480L;
	private String name;
	private int age;
	private transient String ssn;
	private LoginInfo lInfo;
	
	
	public Person1(String name, int age, String ssn, String userId, String userPass) {
		super();
		this.name = name;
		this.age = age;
		this.ssn = ssn;
		this.lInfo = new LoginInfo(userId, userPass);
	}


	@Override
	public String toString() {
		return "Person1 [name = " + name + ", age = " + age + ", ssn = " + ssn + ", lInfo = " + lInfo + "]";
	}
}
