package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowBalanceServlet
 */

public class ShowBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		 
		PrintWriter out = response.getWriter();
		 if(request.isUserInRole("manager")) {
			 
			 out.println("<h1 style='text-align: center; color: red;'>YOUR ACCOUNT BALANCE :: "+ new Random().nextInt(12000)+"</h1>");
			 out.close();
		 }
		 else if(request.isUserInRole("admin")) {
			 out.println("<h1 style='text-align: center; color: red;'>You are admin</h1>");
		 }else {
			 out.println("<h1 style='text-align: center; color: red;'>User is not allow to access this area</h1>");
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
