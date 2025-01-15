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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
       PrintWriter out =	response.getWriter();
       System.out.println("\nRequest Object :  "+ request.getClass().getName() );
       System.out.println("Response Object:  "+request.getClass().getName());
       
       request.setAttribute("Name", "Om Prakash");
       request.setAttribute("class", "5th");
       
       out.println("<h1>Output from FirstServlet.....</h1>");
       RequestDispatcher rd =request.getRequestDispatcher("/second");
       rd.include(request, response);
       
       out.println("<h1>again back to sent Total response to user...</h1>");
       
       
       out.close();
       
	}

}
