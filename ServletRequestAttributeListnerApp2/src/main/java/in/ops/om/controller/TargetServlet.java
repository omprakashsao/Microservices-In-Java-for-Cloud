package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Sockaddr;

import in.ops.om.listner.RequestListnerApp;

/**
 * Servlet implementation class TargetServlet
 */
@WebServlet("/test")
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    static {
    	System.out.println("Loading .class file:: TargetServlet.enclosing_method()");
    }
	
    public TargetServlet() {
       System.out.println("Instatiation :: TargetServlet.TargetServlet()");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    @Override
	public void init() throws ServletException {
		System.out.println("Instialization :: TargetServlet.init()");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("Deinstatiation:: TargetServlet.destroy()");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RequestProcessing:: TargetServlet.doGet()");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
	   System.out.println("Request Object Information"+ request.hashCode());
	   System.out.println("Response Object information "+response.hashCode());
	   System.out.println("Servlet Object information"+this.hashCode());
	   System.out.println("Thread Information"+ Thread.currentThread().hashCode());
		
		
		out.println("<h1 bgcolor='red' align='center'>");
		out.println("The no. of hitcounts is :: ");
		out.println(RequestListnerApp.count);
		out.println("</h1>");
		out.close();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}
