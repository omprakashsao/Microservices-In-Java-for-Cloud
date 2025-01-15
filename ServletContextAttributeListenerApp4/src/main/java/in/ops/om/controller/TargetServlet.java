package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextAttributeDemoListener
 */
@WebServlet("/test")
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("RequestProcessing:: TargetServlet.doGet()");
		
		ServletContext context = request.getServletContext();
		
		//Add Attribute
		context.setAttribute("Name", "Om Prakash Sao");
		context.setAttribute("block", "H34");
		context.setAttribute("std", "extreme");
		
		// Update Attribute
		context.setAttribute("block", "34");
		
		//  Remove Attribute
		context.removeAttribute("std");

		PrintWriter out = response.getWriter();
		out.println("Operation on Servlet....");
		
		out.close();
	}

}
