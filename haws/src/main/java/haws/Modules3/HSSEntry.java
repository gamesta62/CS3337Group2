package project.Modules3;

public class HSSEntry {
	String password;
	int id; 
	public HSSEntry(int IDIn, String passwordIn) {
		password = passwordIn;
		id = IDIn;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}

}
