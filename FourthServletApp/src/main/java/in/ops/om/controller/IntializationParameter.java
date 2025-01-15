package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IntializationParameter
 */
@WebServlet(
		description = "workin on intialize parameter in servlet config", 
		urlPatterns = { "/test" }, 
		initParams = { 
				@WebInitParam(name = "name", value = "Om", description = "username"), 
				@WebInitParam(name = "phoneNo", value = "8349834734", description = "mobile number"), 
				@WebInitParam(name = "id", value = "1234", description = "identification")
		})
public class IntializationParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@SuppressWarnings("unused")
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Note - data associated wirh servlet Config is local scope access only in particular servlet not others                          .
	PrintWriter out = 	response.getWriter();
	System.out.println("Servlet Config"+ getServletConfig());
	System.out.println("Servlet Context"+ getServletContext());
	
	Enumeration<String> parameterNames = getInitParameterNames();
	
	out.println("<table border='1px' style='bgcolor= cyan'>");
	out.println("<tr><th>PARAMETER</th><th>PARAMETERVALUE</th></tr>");
	while(parameterNames.hasMoreElements()) {
		String parameterName =parameterNames.nextElement();
		String value = getInitParameter(parameterName);
		
		out.println("<tr><td>"+parameterName+"</td><td>"+value+"</tr>");
		
		
	}
	out.println("</table>");
	out.close();

	}

}
