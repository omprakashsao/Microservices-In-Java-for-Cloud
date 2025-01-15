package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	PrintWriter out =	response.getWriter();
	 System.out.println("Request Object class "+ request.getClass().getCanonicalName());
	 System.out.println("Response Object class "+response.hashCode());
	 
	 request.setAttribute("name", "om prakash");
	 request.setAttribute("class", "4th");
	 request.setAttribute("block", "233");
	 
	 out.println("Output from the FirstServlet......");
	 
	 
	 
	                 RequestDispatcher rd =request.getRequestDispatcher("/second");
	                 rd.forward(request, response);
	                 
	                 out.close();
	                 
	                 System.out.println("below line of forward statement to Second Servlet....");
	                 System.out.println(12/0);
	}

}
