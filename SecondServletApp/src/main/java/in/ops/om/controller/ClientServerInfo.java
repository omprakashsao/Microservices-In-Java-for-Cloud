package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClientServerInfo
 */
@WebServlet(description = "Working with client server information", urlPatterns = { "/client" })
public class ClientServerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	

	static {
		System.out.println("Loding :  .class file of Myservlet....");
	}
	
	public ClientServerInfo() {
		System.out.println("Instatiation ......");
		
	}
	
	public void init() throws ServletException {
		 System.out.println("Intiatlization....");
		}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
		System.out.println("Request Processing ==> doGet()....");

		String serverName = request.getServerName();
	    int serverPort = request.getServerPort();
	    
	    String remoteUser = request.getRemoteUser();
	    String remoteAddr = request.getRemoteAddr();
	   String remoteHost =  request.getRemoteHost();
	   int remotePort = request.getRemotePort();
	   
	 PrintWriter out=  response.getWriter();
	 out.println("<table border='1px '  style='background= blue       '><tr><td>serverName</td><td>serverPort</td><td>remoteUser</td><td>remoteAddr</td><td>remoteHost</td><td>remotePort</td></tr>");
	 out.println("<table><tr><td>"+serverName+"</td><td>"+serverPort+"</td><td>"+remoteUser+"</td><td>"+remoteAddr+"</td><td>"+remoteHost+"</td><td>"+remotePort+"</td></tr>");
	 out.println("</table>");
	 out.close();
	}

}
