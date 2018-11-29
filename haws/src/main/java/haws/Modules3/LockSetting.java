package project.Modules3;

import java.io.IOException;
import java.util.List;

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
	

       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.getRequestDispatcher( "/project.Modules3/LockSetting.jsp" ).forward(
		             request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			boolean hasError = false;
        	String password = request.getParameter( "password" );
        	String oldPassword = request.getParameter( "oldPassword" );
        	
        	HSSEntry entry = getEntry(1);
    	    
   
        	
    		if(entry.getPassword() != oldPassword) {
    			hasError = true;
    		}
    		
		if(hasError) {
			entry.setPassword(password);
			response.sendRedirect("SmartLocker");
		}else {
			
			request.getRequestDispatcher( "/project.Modules3/LockSetting.jsp" ).forward(
		             request, response );
		}
	
	}

}
