package in.ops.om.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

import org.apache.tomcat.jni.Sockaddr;

/**
 * Application Lifecycle Listener implementation class ServletContextAttributeDemoListener
 *
 */
@WebListener
public class ServletContextAttributeDemoListener implements ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public ServletContextAttributeDemoListener() {
        // TODO Auto-generated constructor stub
       System.out.println("Instantiation -> ServletcontextAttributeDemoListener..");
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
         // TODO Auto-generated method stub
    	System.out.println(scae.getName() + " object is added...");
    	
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
         // TODO Auto-generated method stub
    	System.out.println(scae.getName()+"  object is removed ...");
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
         // TODO Auto-generated method stub
    	System.out.println(scae.getName() + " object is updated... ");
    }
	
}
