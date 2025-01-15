package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidateSessionServlet
 */
@WebServlet("/test2")
public class BookInformationServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
	  PrintWriter out = 	response.getWriter();
	 HttpSession session =  request.getSession(false);
	 if(session == null) {
		 out.println("<h1 style='color:red '>No Information is available.....</h1>");
	 }
	 else {
		 out.println("CART INFORMATION");
		 
		 Enumeration<String> attributeNames = session.getAttributeNames();
	     out.println("<table align='center' border=3px>");
	     out.println("<tr><th>ATTRIBUTENAME</th><th>ATTRIBUTEVALUE</th></tr>");
	     while (attributeNames.hasMoreElements()) {
	    	 out.println("<tr>");
	    	 String attributeName =  (String)attributeNames.nextElement();
	    	 Object value =session.getAttribute(attributeName);
	    	 out.println("<td>"+attributeName+"</td>");
	    	 out.println("<td>"+value+"</td>");
	    	 out.println("</tr>");
	     }
	     
	     out.println("</table >");
			 }
	 
	 
	 
	 
	 
	}

}
