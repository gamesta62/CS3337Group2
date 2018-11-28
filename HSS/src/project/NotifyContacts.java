package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NotifyContacts
 */
@WebServlet("/NotifyContacts")
public class NotifyContacts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotifyContacts() {
        super();
        // TODO Auto-generated constructor stub
    }

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
			if (entry.isNotifyByEmail() == true && alertType==1) {
				notify.notifyByEmail(entry.getEmail(), alertType);
				notified.add(entry);
			}
			if (entry.isNotifyByText() == true && alertType==2) {
				notify.notifyByText(entry.getPhoneNumber(), alertType);
				notified.add(entry);
			}
		}
		getServletContext().setAttribute("notified", notified);
		PrintWriter out = response.getWriter();  
		response.setContentType("text/html");  
		out.println("<script type=\"text/javascript\">");  
		out.println("alert('deadbeef');");  
		out.println("</script>");
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
