package project.Modules3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Lock
 */
@WebServlet("/project.Modules3/Lock")
public class Lock extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	@SuppressWarnings("unchecked")
	private HSSEntry getEntry(int id) {
		List<HSSEntry> x = (List<HSSEntry>) getServletContext().getAttribute("HSS");
		for(HSSEntry entry: x)
			if(entry.getID() == id) return entry;
		
		return null;
	}
	

	
	public void init(ServletConfig config) throws ServletException {
		super.init(config); //dont forget this line
	
		//get a reference to the servlet context (Application Scope)
		ServletContext context = this.getServletContext();
	
		//Create a local primitive value for the counter
		int count = 0;
		//set the inital value of the vote counter to 0
		context.setAttribute("Locker", count);
		
		
		int counter = 0;
		context.setAttribute("WrongPassword", counter);
}

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = this.getServletContext();
	
		//get a reference to the current count
		int currentCount = (int)context.getAttribute("Locker");	
		//increment the count by 1
		currentCount++;
		//Update the context with the new value
		context.setAttribute("Locker", currentCount);
		
		
		if(currentCount % 2 != 0) {
			request.getRequestDispatcher( "/project.Modules3/Locked.jsp" ).forward(
		             request, response );
		}else {
			 request.getRequestDispatcher( "/project.Modules3/Lock.jsp" ).forward(
		             request, response );
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String password = request.getParameter( "password" );
        
    	HSSEntry entry = getEntry(1);
        
    	ServletContext context = this.getServletContext();
		int wrongPassword = (int)context.getAttribute("WrongPassword");

		int Count = (int)context.getAttribute("Locker");	
	
		
		
   
        	if(entry.password.equals(password)) {
        		wrongPassword = 0;
        		context.setAttribute("WrongPassword", wrongPassword);
        		response.sendRedirect("SmartLocker");
        	     
        	}else {
        		wrongPassword++;
        		Count--;
        		context.setAttribute("Locker", Count);
        		context.setAttribute("WrongPassword", wrongPassword);
        		
        		request.getRequestDispatcher( "/project.Modules3/Lock.jsp" ).forward(
    		             request, response );
        		
        		
        		
    		
        	}
        	
        	
        
        
	}

}

