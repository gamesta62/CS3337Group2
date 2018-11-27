package project.module2;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Module2/Image")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    Controller controller  = (Controller)getServletContext().getAttribute("controller");
	    
	    int id = -1;
	    
	    if (request.getParameter("id") != null)
	        id = Integer.parseInt(request.getParameter("id"));
	    
	    if (id == -1) {
	        response.sendRedirect("Index");
	        return;
	    }
	    
	    byte[] imageBytes = (byte[])controller.getPicture(id);

	    response.setContentType("image/png");

	    response.setContentLength(imageBytes.length);
	    
	    OutputStream out = response.getOutputStream();
	    out.write(imageBytes); // image is of byte[] type.
	    out.flush();
	    out.close();
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
