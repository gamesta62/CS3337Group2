package project;

public class emergencyNotification {
	String notitification;
	int time;
	String notifBody;
	
	public String notifyByText(String name, int num,int alertType) {
		//seperating alert types by numbers. 
		//1 = Forced Entry Attempt
		//2 = Excessive Failed Keypad Attempts
		
		if (alertType == 1) {
			return "Sending alert to " + name + " via text to " + num + " about forced entry attempt.";
		} else if (alertType ==2) {
			return "Sending alert to " + name + " via text to " + num + " about excessive failed keypad attempts.";
		} else {
			return "ERROR. INVALID INPUT";
		}
	}
	
	public String notifyByEmail(String name, String email, int alertType) {
		//seperating alert types by numbers. 
		//1 = Forced Entry Attempt
		//2 = Excessive Failed Keypad Attempts
		
		if (alertType == 1) {
			return "Sending alert to " + name + " via email at " + email + " about forced entry attempt.";
		} else if (alertType ==2) {
			return "Sending alert to " + name + " via email at " + email + " about excessive failed keypad attempts.";
		} else {
			return "ERROR. INVALID INPUT";
		}
	}
	
	public String notify911() {
		return "Calling 911 services...";
	}

}
