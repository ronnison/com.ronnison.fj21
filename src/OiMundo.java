

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OiMundo
 */
@WebServlet("/OiMundo")
public class OiMundo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void service (HttpServletRequest req, HttpServletResponse resp) 
     throws ServletException, IOException{
    	PrintWriter out = resp.getWriter();
    	out.println("<html>");
    	out.println("<body>");
    	out.println("Minha primeira Servlet!");
    	out.println("</body>");
    	out.println("</html>");
    }

}
