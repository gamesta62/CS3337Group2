package project.module2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import module2.API.dataStoreAPI;

@WebServlet("/dataSaver")
public class dataSaver extends HttpServlet implements dataStoreAPI{
	
	private static final long serialVersionUID = 1L;

	public dataSaver() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

    @Override
    public boolean checkAllInfo() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void store() {
        // TODO Auto-generated method stub
        
    }

}
