package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/test2")
public class FirstServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<h1>COOKIE INFORMATION</h1>");
		out.println("<table><tr><th>CookieName</th><th>CookieValue</th></tr>");
		Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
        	out.println("<tr>");
			String name = cookie.getName();
			String value = cookie.getValue();
			out.println("<td>"+name+"</td>");
			out.println("<td>"+value+"</td>");
			out.println("</tr>");
		}
        out.println("</table>");
		
		
		out.close();
	}

}
