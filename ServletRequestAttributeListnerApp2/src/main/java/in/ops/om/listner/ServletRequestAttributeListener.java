package in.ops.om.listner;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

import org.apache.tomcat.jni.Sockaddr;

/**
 * Application Lifecycle Listener implementation class ServletRequestAttributeListener
 *
 */
@WebListener
public class ServletRequestAttributeListener implements javax.servlet.ServletRequestAttributeListener {

    /**
     * Default constructor. 
     */
    public ServletRequestAttributeListener() {
       System.out.println("ServletRequestAttributeListener.class file is lading ... ");
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
       System.out.println(srae.getName()+" object is removed...");
    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
         System.out.println(srae.getName()+" object is added....");
         
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
         System.out.println(srae.getName()+		" object is updated...");
    }
	
}
