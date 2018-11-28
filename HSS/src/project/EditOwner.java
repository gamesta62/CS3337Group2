package project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditOwner
 */
@WebServlet("/EditOwner")
public class EditOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/EditOwner.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User owner = (User) getServletContext().getAttribute("owner");
			emergencyNotification beta = (emergencyNotification) getServletContext().getAttribute("delay");

			//String name = request.getParameter("name");
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
			int time = Integer.parseInt(request.getParameter("time"));

			//owner.setName(name);
			owner.setPhoneNumber(phoneNumber);
			owner.setEmail(email);
			owner.setNotifyByEmail(getEmail);
			owner.setNotifyByText(getText);
			beta.setTime(time);

		}catch(Exception e) {

		}
		finally {
			response.sendRedirect("OwnerSettings");
		}
	}

}
