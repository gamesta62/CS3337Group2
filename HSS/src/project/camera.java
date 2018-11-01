package project;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/camera")
public class camera extends HttpServlet implements cameraAPI{
	private static final long serialVersionUID = 1L;
	private InputStream photoData = null;
	
    public camera() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter output = response.getWriter();
		output.print(this.photoData);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
    @Override
    public void access(InputStream data) {
        this.photoData = data;
    }
    
    @Override
    public InputStream getData() {
        return this.photoData;
    }
    
    @Override
    public void takePicture() {
        // not yet
    }
    
    @Override
    public boolean hasData() {
        
        if (this.photoData == null) 
            return false;
        else
            
    }

}
