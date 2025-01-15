package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HitCountAppUsingContextScope
 */
@WebServlet("/hitcount")
public class HitCountAppUsingContextScope extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		   ServletContext context = getServletContext();
		    Integer value =(Integer)context.getAttribute("hitcount");
		    if(value == null) {
		    	value = 1;
		    }
		    else {
		    	value++;
		    }
		    
		    context.setAttribute("hitcount", value);
		    out.println("<h1>no. of hitcount is :: "+value+"</h1>");
	}

}
