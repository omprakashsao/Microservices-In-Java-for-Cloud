package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AttributeAddedServlet
 */
@WebServlet("/test1")
public class AttributeAddedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	static {
		System.out.println("AttributeAddedServlet.class file is loading ....");
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttributeAddedServlet() {
        System.out.println("Instatiation -> AttributeAddedServlet.AttributeAddedServlet()");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Instialization :: AttributeAddedServlet.init()");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("Deinstatiation :: AttributeAddedServlet.destroy()");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RequestProcessing:: AttributeAddedServlet.doGet()");
		
		//Adding attribute 
		request.setAttribute("name", "Om Prakash Sao");
		request.setAttribute("block", "4938");
		request.setAttribute("id", "3432");
		
		// Update Attribute 
		request.setAttribute("id","1234");
		
		//Remove Attribute 
		request.removeAttribute("block");
	
		PrintWriter out = response.getWriter();
		out.println("<h1>Operation on Servlet Request Object...</h1>");
		out.close();
	}

}
