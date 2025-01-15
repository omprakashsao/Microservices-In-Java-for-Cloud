package in.ops.om.listener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletContextDemoListener
 *
 */
@WebListener
public class ServletContextDemoListener implements ServletContextListener {

 
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("ServerShutDown-> ServletContextDemoListener.contextDestroyed() "+ new java.util.Date()); 
           String path = sce.getServletContext().getRealPath("count.txt");
           PrintWriter out = null;
           try {
				 out = new PrintWriter(path);
				out.println(RequestDemoListener.count);
				out.flush();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
			out.close();
			}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("ServerStarts ->ServletContextDemoListener.contextInitialized() "+ new java.util.Date());

       String path = sce.getServletContext().getRealPath("count.txt");      
       BufferedReader reader = null;
       try {
		 reader = new BufferedReader(new FileReader(path));
		String line = reader.readLine();
		while(line!=null) {
			int countVal = Integer.parseInt(line);
			RequestDemoListener.count = countVal;
			line = reader.readLine();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    }
	
}
