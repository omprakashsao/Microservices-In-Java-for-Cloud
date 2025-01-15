package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pwd = request.getParameter("value");
		PrintWriter out = response.getWriter();
		if(name.equalsIgnoreCase("om prakash")&& pwd.equals("123456")) {
			out.println("<h1>Your Subcriptions Are Following....</h1>");
		}else {
			response.sendError(401);
		}
	}

}
