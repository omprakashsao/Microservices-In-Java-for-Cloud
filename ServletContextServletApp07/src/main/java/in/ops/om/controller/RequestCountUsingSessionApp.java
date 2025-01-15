package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HitCountAppUsingContextScope
 */
@WebServlet("/rscount")
public class RequestCountUsingSessionApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		   HttpSession session = request.getSession();
		Integer value =(Integer)session.getAttribute("hitcount");
	
			if(value == null) {
				value = 1;
			}
			else {
				value++;
			}
		
			
		    
		    session.setAttribute("hitcount", value);
		    out.println("<h1>no. of request in a session is :: "+value+"</h1>");
	}

}
