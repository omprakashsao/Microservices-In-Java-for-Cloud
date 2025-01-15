package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(description = "working with GET and POST request", urlPatterns = { "/test" })
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("Loding : loading .class file");
	}
	
	public FirstServlet() {
		System.out.println("Instantiation : Servlet Intiatatiation");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("run doGet()...");
		
		  response.setContentType("text/html");
		  
		  PrintWriter out =response.getWriter();
		  out.println("<h1>GET Method....</h1>");
	      out.close();	 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("run doPost()...");
		
		  response.setContentType("text/html");
		  
		  PrintWriter out =response.getWriter();
		  out.println("<h1>POST Method....</h1>");
	      out.close();	 
		
	}

}
