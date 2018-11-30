package project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/textexample")
public class TextExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String ACCOUNT_SID = "AC6ea007184c5295ef4b30b5cabca9c87d";
	private static final String AUTH_TOKEN = "345194ef263302f78b9094b1db44b729";
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		Message message = Message.creator(new PhoneNumber("13233606193"), // To number
				new PhoneNumber("+13235535355"),                  // From number
				"D A N K").create();                  // Message Body

		System.out.println(message.getSid());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}