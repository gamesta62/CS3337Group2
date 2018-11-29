package project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditContact
 */
@WebServlet("/EditContact")
public class EditContact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected User getEntry(int id) {
		ArrayList<User> entries = (ArrayList<User>) getServletContext().getAttribute("entries");
		for (User entry:entries) {
			if (entry.getId() == id) {
				return entry;
			}
		}
		return null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Parse an integer out of the 'id' parameter
			int id = Integer.parseInt(request.getParameter("id"));

			User entryToEdit = getEntry(id);

			if (entryToEdit != null) {

				// If we find a match, let's attach the message to the 'request' object
				//  and forward the object to a view for display
				request.setAttribute("entry", entryToEdit);
				request.getRequestDispatcher("/WEB-INF/EditContact.jsp").forward(request, response);			

			}

		}catch(Exception e) {
			// If we have a parse error, let's redirect back to GuestBook
			response.sendRedirect("EmergencyContacts");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			User entry = getEntry(id);

			String name = request.getParameter("name");
			String phoneNumber = request.getParameter("phoneNumber");
			String email = request.getParameter("email");
			boolean getEmail;
			if (request.getParameter("getEmail").equals("1"))
				getEmail=true;
			else getEmail=false;
			boolean getText;
			if (request.getParameter("getText").equals("1"))
				getText=true;
			else getText=false;

			entry.setName(name);
			entry.setPhoneNumber(phoneNumber);
			entry.setEmail(email);
			entry.setNotifyByEmail(getEmail);
			entry.setNotifyByText(getText);

		}catch(Exception e) {

		}
		finally {
			response.sendRedirect("EmergencyContacts");
		}
	}

}
