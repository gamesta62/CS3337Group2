package project.module2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Image")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    Controller controller  = (Controller)getServletContext().getAttribute("controller");
	    
	    byte[] imageBytes = controller.getFirstRecord().getPicture();

	    response.setContentType("image/png");

	    response.setContentLength(imageBytes.length);

	    response.getOutputStream().write(imageBytes);

	    
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
