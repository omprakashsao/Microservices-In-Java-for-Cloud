package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestHeaderInfoApp
 */
@WebServlet(description = "Geting RequestHeader information", urlPatterns = { "/header" },loadOnStartup = 4)
public class RequestHeaderInfoApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Loding :  .class file of Myservlet....");
	}
	
	public RequestHeaderInfoApp() {
		System.out.println("Instatiation ......");
		
	}
	
	@Override
	public void init()  {
		System.out.println("Servlet Intializer....");
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@SuppressWarnings("unused")
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       response.setContentType("text/html");
       
    Enumeration<String> headerNames =   request.getHeaderNames();
    
   PrintWriter out = response.getWriter();
   out.println("<h1>REQUEST HEADER INFORMATION</h1>");
   out.println("<table style='border= 2px solid blue'><tr><td>Header Name</td><td>Description</td></tr>");
   while(headerNames.hasMoreElements()) {
	   out.println("<tr>");
	   
	   String key =(String)headerNames.nextElement();
	   String value = request.getHeader(key);
	   out.println("<td>"+key+"</td>");
	   out.println("<td>"+value+"</td>");
	   out.println("</tr>");
   }
       out.println("</table>");
		
	}

}
