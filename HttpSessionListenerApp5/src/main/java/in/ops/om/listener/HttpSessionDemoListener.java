package in.ops.om.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class HttpSessionDemoListener
 *
 */
@WebListener
public class HttpSessionDemoListener implements HttpSessionListener {

    public static int count = 0;
	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("HttpSessionDemoListener.sessionCreated()");
    	System.out.println("A session object is created with id is ::  "+ se.getSession().getId());
    	
    	count++;
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("HttpSessionDemoListener.sessionDestroyed()");
    	System.out.println("A session object is destroyed with id is :: "+ se.getSession().getId());
    	count--;
    }
	
}
