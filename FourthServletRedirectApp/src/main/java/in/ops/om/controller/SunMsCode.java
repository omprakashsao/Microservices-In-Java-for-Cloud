package in.ops.om.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SunMsCode
 */
@WebServlet(description = "work with redirect concept", urlPatterns = { "/SunMsCode" })
public class SunMsCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

          System.out.println("RequestProcessing :: SunMsCode.doGet()");
//          response.setStatus(302);
//		response.setHeader("Location", "./oracle");
          
          // One another style
          response.sendRedirect("./oracle");
	}

	

}
