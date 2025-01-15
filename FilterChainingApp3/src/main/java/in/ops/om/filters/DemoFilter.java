package in.ops.om.filters;

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
 * Servlet Filter implementation class DemoFilter
 */
public class DemoFilter extends HttpFilter implements Filter {
       
   static {
	   System.out.println("loading .class file :: DemoFilter.enclosing_method()");
   }
    public DemoFilter() {
        System.out.println("Instantiation:: DemoFilter.DemoFilter()");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("deinstatiation:: DemoFilter.destroy()");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("RequestProcessing:: DemoFilter.doFilter()");

		PrintWriter out = response.getWriter();
		out.println("response from demofilter before request processing ..");
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		out.println("response from demofilter after request processing ..");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
		System.out.println("Instialization:: DemoFilter.init()");
	}
	

}
