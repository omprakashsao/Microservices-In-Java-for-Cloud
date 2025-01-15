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
@WebServlet("/test1")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		out.println("<h1>Your Name is :: "+name+"</h1>");
		out.println("<form action='./test2' method='get'>");
		out.println("<table><input type='hidden' name='username' value='"+name+"'><tr><th>Enter Your Age</th>");
		out.println("<td><input type='text' name='age' ></td></tr>");
		out.println("</form>");
		out.close();
		
	}



}
