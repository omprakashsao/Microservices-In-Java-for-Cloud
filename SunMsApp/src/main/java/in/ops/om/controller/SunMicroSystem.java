package in.ops.om.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SunMicroSystem
 */
@WebServlet("/sun")
public class SunMicroSystem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SunMicroSystem.doGet()");
	 ServletContext	context = getServletContext();
	ServletContext frd = context.getContext("/OracleApp");
	RequestDispatcher rd =frd.getRequestDispatcher("/oracle");
	rd.forward(request, response);
		
	}
}
