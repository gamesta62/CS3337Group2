package project.Modules3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainPage
 */
@WebServlet("/project.Modules3/MainPage")
public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 public void init( ServletConfig config ) throws ServletException
	    {
	        super.init( config );

	        // create some test data for display
	        List<HSSEntry> entries = new ArrayList<HSSEntry>();

	        entries.add( new HSSEntry( 1, "1234" ) );

	        // and other servlets.
	        getServletContext().setAttribute( "HSS", entries );
	    }
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher( "/project.Modules3/MainPage.jsp" ).forward(
	             request, response );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
