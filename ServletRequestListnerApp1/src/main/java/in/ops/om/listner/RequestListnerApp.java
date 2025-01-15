package in.ops.om.listner;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class RequestListnerApp
 *
 */
@WebListener
public class RequestListnerApp implements ServletRequestListener {

    static {
    	System.out.println("Loading :: RequestListnerApp.enclosing_method()");
    }
    public RequestListnerApp() {
          System.out.println("Instatiation :: RequestListnerApp.RequestListnerApp()");
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
       System.out.println(" Deinstantiation :: RequestListnerApp.requestDestroyed()"+ new java.util.Date());
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
         System.out.println(" Instialization :: RequestListnerApp.requestInitialized()"+ new java.util.Date());
    }
	
}
