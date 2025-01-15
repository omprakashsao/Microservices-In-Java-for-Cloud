package in.ops.om.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class DowloadingFileServlet
 */
@WebServlet("/downloadurl")
public class DowloadingFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	@Resource(name = "JNDI")
	private DataSource ds;	
	ResultSet rs = null;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String fileLoc = null ;
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		System.out.println(id+" "+ type);
		
		if(id != null) {
			try(Connection con= ds.getConnection()){
				
				if(con != null) {
					try(Statement stmt = con.createStatement()){
					 
						if(type.equalsIgnoreCase("resume")) {
							 rs = stmt.executeQuery("select resumeloc from person_profile");
							 
						}else {
							 rs = stmt.executeQuery("select photoloc from person_profile");
							
						}
						if(rs.next()) {
							 fileLoc = rs.getString(1);
							
						}
						
						
						
					
						
						

					
						
						File file = new File(fileLoc);
						
						//1 . set file length 
						response.setContentLengthLong(file.length());
						
						//2. set mime type
						ServletContext context = request.getServletContext();
						String mimeType = context.getMimeType(fileLoc);
						mimeType = (mimeType == null) ? "application/octet-stream" : mimeType;
						response.setContentType(mimeType);
						
						//3. set response header
						response.addHeader("Content-Disposition", "attachment;fileName"+file.getName());
						
						// 4.  file trasfer in download format
						FileInputStream fis = new FileInputStream(fileLoc);
						ServletOutputStream stream = response.getOutputStream();
						IOUtils.copy(fis, stream);
						
						
						
						
						
						
					}
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			}
		
		
	}

}
