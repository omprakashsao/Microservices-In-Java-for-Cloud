package in.ops.om.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import in.ops.om.customize.CustomizedRequest;

/**
 * Servlet Filter implementation class FilterApp
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, description = "ForSendingCustomizeReqestObject", urlPatterns = { "/test" })
public class FilterApp extends HttpFilter implements Filter {
       
    static {
    	System.out.println("Loading .class file:: FilterApp.enclosing_method()");
    }
    public FilterApp() {
        System.out.println("Instantiation ::FilterApp.FilterApp()");
    }

	
	public void destroy() {
		System.out.println("Deinstantiation:: FilterApp.destroy()");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("RequestProcessing:: FilterApp.doFilter()");

     CustomizedRequest req = new CustomizedRequest((HttpServletRequest)request);
		// pass the request along the filter chain
		chain.doFilter(req, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Instialization:: FilterApp.init()");
	}

}
