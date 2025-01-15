package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		String uname = request.getParameter("name");
		
		LocalDateTime time = LocalDateTime.now();
		String msg = "";
		int hour = time.getHour();
		if(hour<12) {
			msg+="Good Monrning "+uname;
		}else if(hour<16){
			msg+="Good Afternoon "+uname;
		}else if(hour<20) {
			msg+="Good Evening.. "+uname;
		}else {
			msg+="Good Night "+uname;
		}
		
		out.println(msg);
		
		out.close();
	}

}
