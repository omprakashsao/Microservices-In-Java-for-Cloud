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
@WebServlet("/test2")
public class FirstServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		String name = request.getParameter("username");
		String age = request.getParameter("age");
		out.println("<h1>Your Name is :: "+name+"</h1>");
		out.println("<h1>Your Age is :: "+age+"</h1>");
		out.println("<form action='./test3' method='get'>");
		out.println("<table><input type='hidden' name='username' value='"+name+"'><input type='hidden' name='userage' value='"+age+"'><tr><th>Enter Your Address</th>");
		out.println("<td><input type='text' name='address' ></td></tr>");
		out.println("</form>");
		out.close();
		
	}



}
