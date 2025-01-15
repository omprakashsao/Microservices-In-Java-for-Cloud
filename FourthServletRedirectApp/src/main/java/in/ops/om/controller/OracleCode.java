package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OracleCode
 */
@WebServlet(description = "control move on oracle from SunMsCode", urlPatterns = { "/oracle" })
public class OracleCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	  System.out.println("RequestProcessing :: Oracle.doGet()...");
	   PrintWriter out= response.getWriter();
	   out.println("<h1>Welcome To Oracle Services</h1>");
	   out.close();
	}

}
