package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ops.om.listener.HttpSessionAttributelistener;
import in.ops.om.listener.HttpSessionBindingDemoListener;

/**
 * Servlet implementation class TargetServlet
 */
@WebServlet("/target")
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60);
		
		session.setAttribute("name", "om prakash");
		session.setAttribute("block", "H234");
		
		session.setAttribute("block", "234");
		
		session.removeAttribute("name");
		
		// add user defined attribute
		session.setAttribute("d1", new HttpSessionBindingDemoListener());
		session.setAttribute("obj", new HttpSessionAttributelistener());
		
		// remove user defined listener
		session.removeAttribute("d1");
		
		PrintWriter out = response.getWriter();
		out.println("<h1>Operation on Servlet session object (Attributes)</h1>");
		out.close();
	}

}
