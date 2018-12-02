package project;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 * Servlet implementation class NotifyContacts
 */
@WebServlet("/NotifyContacts")
public class NotifyContacts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	private static final String ACCOUNT_SID = "AC6ea007184c5295ef4b30b5cabca9c87d";
	private static final String AUTH_TOKEN = "345194ef263302f78b9094b1db44b729";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int alertType = Integer.parseInt(request.getParameter("alertType"));
		emergencyNotification notify = new emergencyNotification();
		ArrayList<User> entries = (ArrayList<User>) getServletContext().getAttribute("entries");
		ArrayList<User> notified = new ArrayList<User>();
		for (User entry:entries) {
			if (entry.isNotifyByEmail() == true) {
				notify.notifyByEmail(entry.getEmail(), alertType);
				notified.add(entry);
				//used example online to send emails to contacts
				Properties props = System.getProperties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");

				Session session = Session.getInstance(props,
						  new javax.mail.Authenticator() {
							protected PasswordAuthentication getPasswordAuthentication() {
								return new PasswordAuthentication("demolucus@gmail.com", "hackrus123");
							}
						  });

				if (!entry.getEmail().contains("email.com")) {
					try {
						// Create a default MimeMessage object.
						MimeMessage message = new MimeMessage(session);
						// Set From: header field of the header.
						message.setFrom(new InternetAddress("demolucus@gmail.com"));
						// Set To: header field of the header.
						message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(entry.getEmail()));
						// Set Subject: header field
						message.setSubject("HSS - " + notify.notifyTopic(alertType));
						// Now set the actual message
						message.setText(notify.notifyGeneral(alertType));
						// Send message
						Transport.send(message);
						System.out.println("Sent message successfully....");
					} catch (MessagingException mex) {
						throw new RuntimeException(mex);
					}
				}
			}
			if (entry.isNotifyByText() == true) {
				notify.notifyByText(entry.getPhoneNumber(), alertType);
				if (!notified.contains(entry))
					notified.add(entry);
				Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

				if (entry.getPhoneNumber().equals("13233606193")) {
					Message message = Message.creator(new PhoneNumber("13233606193"), // To number
							new PhoneNumber("+13235535355"),                  // From number
							notify.notifyGeneral(alertType)).create();                  // Message Body
				}
			}
		}
		getServletContext().setAttribute("notified", notified);
		System.out.println("Notifications sent");
		response.sendRedirect("NotifiedContacts");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
