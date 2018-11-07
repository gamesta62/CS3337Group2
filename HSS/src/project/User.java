package project;

public class User {
	String name;
	String phoneNumber;
	String email;
	boolean notifyByText;
	boolean notifyByEmail;
	
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

	public User(String user, String phone, String email) {
		this.name = user;
		this.phoneNumber = phone;
		this.email=email;
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

}
