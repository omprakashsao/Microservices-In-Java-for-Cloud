package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class FirstFilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/target" })
public class FirstFilter extends HttpFilter implements Filter {
       
    static{
    	System.out.println("Loading .class file:: FirstFilter.enclosing_method()");
    }
    public FirstFilter() {
     System.out.println("INATATIATION:: FirstFilter.FirstFilter()");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	System.out.println("DEINSTATIATION:: FirstFilter.destroy()");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("REQUEST PROCESSING:: FirstFilter.doFilter()");
		
		PrintWriter out = response.getWriter();
		out.println("<h1>Filter is processing before calling chain.doFilter()....</h1>");

		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		out.println("<h1>Filter is processing before calling chain.doFilter()....</h1>");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("INTIALIAZATION:: FirstFilter.init()");
	}

}
