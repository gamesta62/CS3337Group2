package project.module2;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Module2/Index")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
        Controller controller = new Controller();
        
        getServletContext().setAttribute("controller", controller);
        
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    Controller controller  = (Controller)getServletContext().getAttribute("controller");
	    
	    int code;
	    if (request.getParameter("code")!= null) {
	        code = Integer.parseInt(request.getParameter("code"));
	        switch(code) {
	            case 101:
	                controller.activeDevices();
	                break;
	            case 102:
                    controller.motionTest();
                    break;
	            case 103:
	                request.getRequestDispatcher("/project.Modules2/keypad.jsp").forward(request, response);
	                //controller.keyPadTest(123456);
                    break;
	            case 104:
	                int loc = -3;
	                if(request.getParameter("location")!=null)
	                    loc = Integer.parseInt(request.getParameter("location"));
	                if (loc != -3 && loc != -1 && loc != 99)
	                    controller.setPassword(loc);
	                else if (loc == -1)
	                    controller.setPassword(-1);
	                else if (loc == 99) {
	                    controller.keyPadTest(controller.getPassword());
	                    controller.setPassword(-3);
	                    response.sendRedirect("Index");
	                    return;
	                }
	                request.getRequestDispatcher("/project.Modules2/keypad.jsp").forward(request, response);
	                break;
	            case 105:
	            	String f1 = "", f2 = "", t1 = "", t2 = "";
	            	if(request.getParameter("date1")!=null) {
	            		f1 = request.getParameter("date1").substring(0, 2);
	            		if (f1.substring(0,1).equals("0"))
	            			f1 = f1.substring(1,2);
	            		f2 = request.getParameter("date1").substring(3, 5);
	            		if (f2.substring(0,1).equals("0"))
	            			f2 = f2.substring(1,2);
	            	}
	            	if(request.getParameter("date2")!=null) {
	            		t1 = request.getParameter("date2").substring(0, 2);
	            		if (t1.substring(0,1).equals("0"))
	            			t1 = t1.substring(1,2);
	            		t2 = request.getParameter("date2").substring(3, 5);
	            		if (t2.substring(0,1).equals("0"))
	            			t2 = t2.substring(1,2);
	            	}
	            	if (f1!="" && f2!="" && t1!="" && t2!="")
	            	controller.searchRecords(Integer.parseInt(f1), Integer.parseInt(f2),
	            			Integer.parseInt(t1), Integer.parseInt(t2));
	            	break;
	            default:
	                break;
	        }
	        response.sendRedirect("Index");
            return;
	    }
	        
        request.getRequestDispatcher("/project.Modules2/main.jsp").forward(request, response);
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
