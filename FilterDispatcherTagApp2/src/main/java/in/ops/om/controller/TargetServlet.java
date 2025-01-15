package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TargetServlet
 */
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Loading .class of ::TargetServlet.enclosing_method()");
	}
	
	public TargetServlet() {
		System.out.println("Instatiatiation:: TargetServlet.TargetServlet()");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("Instialization :: TargetServlet.init()");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.println("Request Processing:: TargetServlet.doGet()");
		
		PrintWriter out = response.getWriter();
		out.println("<h1 color= 'red' align='center'>Response From Target Servlet ...</h1>");
		
	}
	
	@Override
	public void destroy() {
		System.out.println(" Deinstatiation:: TargetServlet.destroy()");
	}

}
