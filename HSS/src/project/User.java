package project;

public class User {
	String name;
	String phoneNumber;
	String email;
	boolean notifyByText;
	boolean notifyByEmail;
	int id;
	
	public User() {}
	
	public User(String name) {
		super();
		this.name = name;
	}
	
	public boolean isNotifyByText() {
		return notifyByText;
	}

	public void setNotifyByText(boolean notifyByText) {
		this.notifyByText = notifyByText;
	}

	public boolean isNotifyByEmail() {
		return notifyByEmail;
	}

	public void setNotifyByEmail(boolean notifyByEmail) {
		this.notifyByEmail = notifyByEmail;
	}

	public User(int id, String user, String phone, String email) {
		this.name = user;
		this.phoneNumber = phone;
		this.email=email;
		this.id=id;
	}
	
	public User(int id, String user, String phone, String email, boolean receiveText, boolean receiveEmail) {
		this.name = user;
		this.phoneNumber = phone;
		this.email=email;
		this.notifyByEmail=receiveEmail;
		this.notifyByText=receiveText;
		this.id=id;
	}

	public String getName() {
		return name;
	}

	public void setName(String user) {
		this.name = user;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

}
