package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TargetServlet
 */
@WebServlet("/target")
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("loading TargetServlet.class file....");
	}
	
	public TargetServlet() {
		System.out.println("INSTATIATION:: TargetServlet");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<h1>Response from FirstServlet....</h1>");
		
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("INTIALIZATION: TargetServlet.init()");
	}
	
	@Override
	public void destroy() {
		 System.out.println("DEINSTATIATION:: TargetServlet.destroy()");
	}

}
