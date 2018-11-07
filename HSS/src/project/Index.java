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
		
		User owner = new User("Joe Smith","1-323-746-1284","jsmith@email.com");
		owner.setNotifyByEmail(true);
		owner.setNotifyByText(true);
		
		ArrayList<User> entries = new ArrayList<User>();
		entries.add(new User("Jane Doe", "1-213-156-8946","jdoe@email.com"));
		
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
		if (null == getServletContext().getAttribute("owner"))
			System.out.println("we fucked up");
		else System.out.println("we gucci");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
