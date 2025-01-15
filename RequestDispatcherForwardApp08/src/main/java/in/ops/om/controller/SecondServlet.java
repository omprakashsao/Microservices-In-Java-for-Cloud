package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	PrintWriter out =	response.getWriter();
	 System.out.println("Request Object class "+ request.getClass().getCanonicalName());
	 System.out.println("Response Object class "+response.hashCode());
	 
	 out.println("Output from the SecondServlet......");
	 
	 Enumeration<String> attributeNames = request.getAttributeNames();
     out.println("<table align='center' border=3px>");
     out.println("<tr><th>ATTRIBUTENAME</th><th>ATTRIBUTEVALUE</th></tr>");
     while (attributeNames.hasMoreElements()) {
    	 out.println("<tr>");
    	 String attributeName =  (String)attributeNames.nextElement();
    	 Object value =request.getAttribute(attributeName);
    	 out.println("<td>"+attributeName+"</td>");
    	 out.println("<td>"+value+"</td>");
    	 out.println("</tr>");
     }
     
     out.println("</table >");
	 out.close();
	 
	              
	                 
	                
	}

}
