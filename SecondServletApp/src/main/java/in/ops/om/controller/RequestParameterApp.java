package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class MyServlet
 */
@WebServlet(description = "Working with Request Parameter", urlPatterns = { "/input" }, loadOnStartup = 10)
public class RequestParameterApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Loding :  .class file of Myservlet....");
	}
	
	public RequestParameterApp() {
		System.out.println("Instatiation ......");
		
	}
	
	@Override
	public void init() {
	  System.out.println("Intialization.....");
	}
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet doPost()....");
		
		response.setContentType("text/html");
		
       
	String name   =	request.getParameter("username");
	String age = request.getParameter("student age");
	String contact=  request.getParameter("phone no.");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	// Dynamic Response
	
	  PrintWriter out =response.getWriter();
	  
	  out.println("<table><tr><td>NAME</td><td>ID</td><td>STATUS</td></tr>");
	  out.println("<tr><td>"+name+"</td><td>"+id+"</td><td>"+"succesful"+"</td></tr></table>");
	  out.close();
	}

	@Override
	public void destroy() {
		System.out.println("servlet delete");
	}
	
	
	

}
