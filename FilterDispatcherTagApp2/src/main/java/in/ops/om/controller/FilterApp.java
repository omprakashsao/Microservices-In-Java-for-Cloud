package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class FilterApp
 */
public class FilterApp extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static {
    	System.out.println(" Loading .class of :: FilterApp.enclosing_method()");
    }
    public FilterApp() {
     System.out.println("Instatiation :: FilterApp.FilterApp()");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println(" Deinstantiaition:: FilterApp.destroy()");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("RequestProcessing:: FilterApp.doFilter()");

		PrintWriter out = response.getWriter();
		out.println("Response before executing chain.doFilter().....");
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		out.println("Response before executing chain.doFilter().....");
		out.close();
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Intiatlization:: FilterApp.init()");
	}

}
