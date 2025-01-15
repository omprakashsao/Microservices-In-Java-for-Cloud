package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ops.om.listener.HttpSessionDemoListener;

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
		session.setMaxInactiveInterval(20);
		
		PrintWriter out = response.getWriter();
		out.println("<h1>The no. of users in a session is  "+HttpSessionDemoListener.count+"</h1>");
		out.close();
	}

}
