package in.ops.om.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.tomcat.jni.Sockaddr;

/**
 * Application Lifecycle Listener implementation class HttpSessionAttributelistener
 *
 */
@WebListener
public class HttpSessionAttributelistener implements HttpSessionAttributeListener {

   

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println(se.getName() +" object  is added ...");
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println(se.getName() + " object is removed....");
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println(se.getName() +" object is updated...");
    }
	
}
