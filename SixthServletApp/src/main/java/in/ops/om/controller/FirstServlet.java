package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */

public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = 	response.getWriter();
		
		ServletContext context = getServletContext();
		Enumeration<String> parameterNames = context.getInitParameterNames();
		
		out.println("<table border='1px' bgcolor= cyan>");
		out.println("<tr><th>Name</th><th>VALUE</th></tr>");
		while(parameterNames.hasMoreElements()) {
			String parameterName =parameterNames.nextElement();
			String value = context.getInitParameter(parameterName);
			
			out.println("<tr><td>"+parameterName+"</td><td>"+value+"</tr>");
			
			
		}
		out.println("</table>");
		out.close();
	}

}
