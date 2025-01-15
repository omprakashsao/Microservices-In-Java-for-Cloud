package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/test1")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<h1>Welcome to OPS Studio</h1>");
		String uname = request.getParameter("name");
	   String url = response.encodeRedirectURL("./test2?name="+uname);
	   out.println("<a href='"+url+"'>click here</a>");
	   System.out.println(url);
		//out.println("<a href='./test2?name="+uname+"'>Click Here</a>");
		out.close();
	}

}
