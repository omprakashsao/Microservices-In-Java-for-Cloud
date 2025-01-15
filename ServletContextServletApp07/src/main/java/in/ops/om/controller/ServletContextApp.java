package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextApp
 */
@WebServlet("/attribute")
public class ServletContextApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         PrintWriter out = response.getWriter();
         
      ServletContext context = getServletContext();
      context.setAttribute("name", "Om Prakash");
      context.setAttribute("class", "5th");
      context.setAttribute("birth", "3432");
      
      
      
      //delete attribute
      context.removeAttribute("birth");
      //Updation attribute
      context.setAttribute("name", "Om Prakash Sao");
     Enumeration<String> attributeNames = context.getAttributeNames();
     
     
        
         
         out.println("<table align='center' border=3px>");
         out.println("<tr><th>ATTRIBUTENAME</th><th>ATTRIBUTEVALUE</th></tr>");
         while (attributeNames.hasMoreElements()) {
        	 out.println("<tr>");
        	 String attributeName =  (String)attributeNames.nextElement();
        	 Object value =context.getAttribute(attributeName);
        	 out.println("<td>"+attributeName+"</td>");
        	 out.println("<td>"+value+"</td>");
        	 out.println("</tr>");
         }
         
         out.println("</table >");
         
         
	}

}
