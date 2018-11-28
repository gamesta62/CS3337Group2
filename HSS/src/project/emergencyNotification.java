package project;

import java.util.concurrent.TimeUnit;

public class emergencyNotification {
	String notitification;
	int time;
	String notifBody;
	
	public emergencyNotification() {	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public int getTime() {
		return time;
	}
	
	public String notifyByText(String num,int alertType) {
		//seperating alert types by numbers. 
		//1 = Forced Entry Attempt
		//2 = Excessive Failed Keypad Attempts
		//3 = motion sensor detected
		if (alertType == 1) {
			return "Sending alert via text to " + num + " about forced entry attempt.";
		} else if (alertType ==2) {
			return "Sending alert via text to " + num + " about excessive failed keypad attempts.";
		} else if (alertType == 3) {
			return "Sending alert via text to " + num + " about tripped motion sensors.";
		} else {
			return "ERROR. INVALID INPUT";
		}
	}
	
	public String notifyByEmail(String email, int alertType) {
		//seperating alert types by numbers. 
		//1 = Forced Entry Attempt
		//2 = Excessive Failed Keypad Attempts
		//3 = motion sensor detected
		if (alertType == 1) {
			return "Sending alert via email to " + email + " about forced entry attempt.";
		} else if (alertType ==2) {
			return "Sending alert via email to " + email + " about excessive failed keypad attempts.";
		} else if (alertType == 3) {
			return "Sending alert via email to " + email + " about tripped motion sensors.";
		}
		else {
			return "ERROR. INVALID INPUT";
		}
	}
	
	public String notifyGeneral(int alertType) {
		//seperating alert types by numbers. 
		//1 = Forced Entry Attempt
		//2 = Excessive Failed Keypad Attempts
		//3 = motion sensor detected
		if (alertType == 1) {
			return "Sending alert about forced entry attempt.";
		} else if (alertType == 2) {
			return "Sending alert about excessive failed keypad attempts.";
		} else if (alertType == 3) {
			return "Sending alert about tripped motion sensors.";
		}
		else {
			return "ERROR. INVALID INPUT";
		}
	}
	
	public String notify911() throws InterruptedException{
		TimeUnit.SECONDS.sleep(time);
		return "Calling 911 services...";
	}

}
