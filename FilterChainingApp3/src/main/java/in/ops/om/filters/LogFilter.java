package in.ops.om.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LogFilter
 */
public class LogFilter extends HttpFilter implements Filter {
       
	private FilterConfig fConfig;
	static {
    	System.out.println("Loading .class file :: LogFilter.enclosing_method()");
    }
    public LogFilter() {
        System.out.println("Instatiation LogFilter.LogFilter()");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    

	
	public void destroy() {
		System.out.println("Deinstatiation:: LogFilter.destroy()");
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("RequestProcessing:: LogFilter.doFilter()");
		PrintWriter out = response.getWriter();
		out.println("response from logfilter before request processing ..");
		ServletContext context = fConfig.getServletContext();
		HttpServletRequest req = (HttpServletRequest)request;
		context.log("A request comming from:: "+ req.getRemoteHost() +"for URL ::"+req.getRequestURL()+"At "+ new java.util.Date());
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		out.println("response from logfilter after request processing ..");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Instialization:: LogFilter.init()"); 
		this.fConfig = fConfig;
	}

}
