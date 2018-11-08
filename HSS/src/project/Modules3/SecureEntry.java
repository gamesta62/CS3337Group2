package project.Modules3;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/project.Modules3/SecureEntry")
public class SecureEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	/*
	 
				HSS shall ask user for permission to unlock door for guest
				HSS shall deny entry when user declines guest’s attempts
				HSS shall detect any unauthorized entry attempts
				HSS shall detect any attempts of forced entry through the door or windows
				HSS shall secure locks after multiple failed keypad attempts
				HSS shall trigger alarms when forced entry is detected

	 */
	
	//https://www.programcreek.com/java-api-examples/index.php?source_dir=webcam-capture-master/webcam-capture/src/main/java/com/github/sarxos/webcam/WebcamMotionDetector.java
   //https://gist.github.com/six519/743e32c9879ffea299b0b175823adc88
	//https://github.com/sarxos/webcam-capture/blob/master/webcam-capture/src/example/java/MultipointMotionDetectionExample.java
	//https://github.com/sarxos/webcam-capture/blob/master/webcam-capture/src/example/java/TakeSnapshotFromVideoExample.java
	public void init(ServletConfig config) throws ServletException {
		super.init(config); //dont forget this line

		
	
}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		boolean entry;
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
