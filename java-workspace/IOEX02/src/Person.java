import java.io.Serializable;

public class Person implements Serializable {
	private String name;
	private String phone;
	private String age;
	private String address;
	
	
	public Person(String name, String phone, String age, String address) {
		super();
		this.name = name;
		this.phone = phone;
		this.age = age;
		this.address = address;
	}

	public String getName() {
		return name;
	}


	public String getPhone() {
		return phone;
	}


	public String getAge() {
		return age;
	}


	public String getAddress() {
		return address;
	}
	
}
