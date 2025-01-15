package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/test3")
public class FirstServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("HEADER INFORMATION");
		 
		 Enumeration<String> headerNames = request.getHeaderNames();
	     out.println("<table align='center' border=3px>");
	     out.println("<tr><th>ATTRIBUTENAME</th><th>ATTRIBUTEVALUE</th></tr>");
	     while (headerNames.hasMoreElements()) {
	    	 out.println("<tr>");
	    	 String headerName =  (String)headerNames.nextElement();
	    	 Object value =request.getHeader(headerName);
	    	 out.println("<td>"+headerName+"</td>");
	    	 out.println("<td>"+value+"</td>");
	    	 out.println("</tr>");
	     }
	     
	     out.println("</table >");
		
		
		out.close();
	}

}
