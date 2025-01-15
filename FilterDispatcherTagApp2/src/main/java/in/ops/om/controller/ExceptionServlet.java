package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Sockaddr;

/**
 * Servlet implementation class TargetServlet
 */
public class ExceptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Loading .class of ::ExceptionServlet.enclosing_method()");
	}
	
	public ExceptionServlet() {
		System.out.println("Instatiatiation:: ExceptionServlet.TargetServlet()");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("Instialization :: ExceptionServlet.init()");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("RequestProcessing:: ExceptionServlet.doGet()");
		
		PrintWriter out = response.getWriter();
	   out.println(12/0);
		out.close();
	}
	
	@Override
	public void destroy() {
		System.out.println(" Deinstatiation:: ExceptionServlet.destroy()");
	}

}
