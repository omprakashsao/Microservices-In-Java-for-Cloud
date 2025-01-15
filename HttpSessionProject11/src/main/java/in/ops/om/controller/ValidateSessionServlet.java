package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidateSessionServlet
 */
@WebServlet("/test1")
public class ValidateSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  PrintWriter out = 	response.getWriter();
	 HttpSession session =  request.getSession(true);
	 if(session.isNew()) {
		out.println("Create new session id "+ session.getId());
	 }
	 else {
		out.println("Existing session id:"+session.getId());
	 }
	 
	 
	 
	 String name = request.getParameter("name");
	 String value = request.getParameter("value");
	  
	session.setAttribute(name, value);
	 
	 // time interval for sesion object deactivate
	 session.setMaxInactiveInterval(20);
	 
	 RequestDispatcher rd =request.getRequestDispatcher("./index.html");
	 rd.forward(request, response);
	 
	 
	}

}
