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





@WebServlet("/project.Modules3/LockSetting")
public class LockSetting extends HttpServlet {
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
		context.setAttribute("counter", count);
	

}

	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.getRequestDispatcher( "/project.Modules3/LockSetting.jsp" ).forward(
		             request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
        	String password = request.getParameter( "password" );
        	String oldPassword = request.getParameter( "oldPassword" );
        	ServletContext context = this.getServletContext();
        	HSSEntry entry = getEntry(1);
    	    
        
    		int currentCount = (int)context.getAttribute("counter");	
    		currentCount++;
    		context.setAttribute("counter", currentCount);
    		
    	boolean hasError = false;
  
		
		
		
		
		if(password.isEmpty()){
			context.setAttribute("emptyPassword", "Please entered a valid password");
			hasError = false;
		}else {
			context.setAttribute("emptyPassword", "");
		}

		if(!entry.password.equals(oldPassword)) {
			context.setAttribute("errorMessage", "You entered wrong password");
			hasError = false;		
		}else {
			context.setAttribute("errorMessage", "");
		}
		
		
		if(entry.password.equals(oldPassword) && !password.isEmpty()) {
			entry.setPassword(password);
			hasError = true;
		}
		
		if(hasError) {
			response.sendRedirect("SmartLocker");
		}else {
			request.getRequestDispatcher( "/project.Modules3/LockSetting.jsp" ).forward(
		             request, response );
		}
	
	}

}
