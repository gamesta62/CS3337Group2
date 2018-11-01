package project;

public class User {
	private String user;
	private int phoneNumber;
	private String email;
	
	public User(String user, int phone, String email) {
		this.user = user;
		this.phoneNumber = phone;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
