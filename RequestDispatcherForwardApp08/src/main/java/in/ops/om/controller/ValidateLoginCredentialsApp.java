package in.ops.om.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateLoginCredentialsApp
 */
@WebServlet("/validate")
public class ValidateLoginCredentialsApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		        
		        String username = request.getParameter("username");
		        String password = request.getParameter("userpassword");
		        
		        if(username.equalsIgnoreCase("sachin") && password.equals("om")) {
		        	RequestDispatcher rd = request.getRequestDispatcher("/inbox.jsp");
		        	rd.forward(request, response);
		        }
		        else {
		        	RequestDispatcher rd = request.getRequestDispatcher("/errorpage.jsp");
		        	rd.forward(request, response);
		        }
	}

}
