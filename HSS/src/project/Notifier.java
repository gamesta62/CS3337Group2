package project;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Notifier	{

	private static final String ACCOUNT_SID = "AC6ea007184c5295ef4b30b5cabca9c87d";
	private static final String AUTH_TOKEN = "345194ef263302f78b9094b1db44b729";

	private Properties props;

	public Notifier() {
		props = System.getProperties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	}

	public void notify(User user, String notification) {
		if (user.isNotifyByEmail() == true) {
			notifyByEmail(user, notification);
		}

		if (user.isNotifyByText() == true) {
			notifyByText(user, notification);
		}
	}

	public void notifyByText(User user, String notification) {
		Message message = Message.creator(new PhoneNumber(user.getPhoneNumber()),
				new PhoneNumber("+13235535355"),
				notification).create();
	}

	public void notifyByEmail(User user, String notification) {
		Session session = Session.getInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("demolucus@gmail.com", "***");
				}
			});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("demolucus@gmail.com"));
			message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(user.getEmail()));
			message.setSubject("HSS - Alert Notification");
			message.setText(notification);
			Transport.send(message);
		} catch (MessagingException mex) {
			throw new RuntimeException(mex);
		}
	}
}
