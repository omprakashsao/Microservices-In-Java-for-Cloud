package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TargetServlet
 */
public class ForwardIncludeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Loading .class of ::ForwardIncludeServlet.enclosing_method()");
	}
	
	public ForwardIncludeServlet() {
		System.out.println("Instatiatiation:: ForwardIncludeServlet.ForwardIncludeServlet()");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("Instialization :: ForwardIncludeServlet.init()");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RequestProcessing:: ForwardIncludeServlet.doGet()");
		
		RequestDispatcher rd = request.getRequestDispatcher("./test2");
		rd.forward(request, response);
	}
	@Override
	public void destroy() {
		System.out.println(" Deinstatiation:: ForwardIncludeServlet.destroy()");
	}
}
