package project;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

//this class was found online and slightly edited to fit the project.

/**
 *Simple countdown timer demo of java.util.Timer facility.
 */

public class Countdown {
	static int interval;
	static Timer timer;
	static int secs;
	
	public Countdown() {}
	
	public static boolean startTime() {
//	    Scanner sc = new Scanner(System.in);
//	    System.out.print("Input seconds => : ");
//	    String secs = sc.nextLine();
	    int delay = 1000;
	    int period = 1000;
	    timer = new Timer();
	    interval = secs;
	    System.out.println(secs);
	    timer.scheduleAtFixedRate(new TimerTask() {

	        public void run() {
	            System.out.println(setInterval());

	        }
	    }, delay, period);
	    if (secs==0)
	    return true;
	    else return false;
	}

	private static final int setInterval() {
	    if (interval == 1)
	        timer.cancel();
	    return --interval;
	}
	
	public void setSecs(int secs) {
		this.secs=secs;
	}
}
