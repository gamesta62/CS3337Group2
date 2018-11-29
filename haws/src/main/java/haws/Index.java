package project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		User owner = new User(0,"Joe Smith","1-323-746-1284","jsmith@email.com");
		owner.setNotifyByEmail(true);
		owner.setNotifyByText(true);
		
		ArrayList<User> entries = new ArrayList<User>();
		entries.add(new User(1,"Jane Doe", "1-213-156-8946","jdoe@email.com"));
		entries.add(new User(2,"John Doe", "", "johndoe@email.com",false,true));
		entries.add(new User(3,"Jennifer Smith", "1-626-761-5468", "",true,false));
		
		getServletContext().setAttribute("owner", owner);
		getServletContext().setAttribute("entries", entries);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
