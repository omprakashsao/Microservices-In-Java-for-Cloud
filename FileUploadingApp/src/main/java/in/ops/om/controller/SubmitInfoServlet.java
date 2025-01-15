package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadParameters;

/**
 * Servlet implementation class SubmitInfoServlet
 */
@WebServlet("/upload")
public class SubmitInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String SQL_INSERT_QUERY = "INSERT INTO PERSON_PROFILE(`PNAME`,`PADDRESS`,`RESUMELOC`,`PHOTOLOC`) VALUES(?,?,?,?)";
	
	@Resource(name = "JNDI")
	private DataSource ds;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		boolean uploadFlag = false;
		PrintWriter out = response.getWriter();
		
		String resumePath = "D:\\upload\\resume\\";
		String photoPath = "D:\\upload\\photo\\";
		String name = null ;
		String address = null;
		String resumeLoc = null;
		String photoLoc = null;
		
		try {
	    MultipartFormDataRequest req = new MultipartFormDataRequest(request);
	   
		 name = req.getParameter("name");
		 address = req.getParameter("address");
		
		// get non-text data
		UploadBean ub = new UploadBean();
		
			
			ub.setMaxfiles(15);
			ub.setBlacklist("install.exe, setup.exe");
			
		
			
			ub.setFolderstore(resumePath);
			ub.store(req, "resume");
			
			ub.setFolderstore(photoPath);
			ub.store(req, "photo");
			
			Vector vector = ub.getHistory();
			resumeLoc = resumePath + ((UploadParameters)vector.get(0)).getFilename() ;
			photoLoc = photoPath + ((UploadParameters)vector.get(1)).getFilename() ;
			
			
			 uploadFlag = true;
			 out.println("<h1>File uploading is successfully completed....</h1>");
			
		} catch (UploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			uploadFlag = false;
			out.println("<h1>File uploading is failed , some problem is occur ...</h1>");
		}
		
		if(uploadFlag == true) {
		    //  JDBC logic 
		    try(Connection connection = ds.getConnection()){
		    	if(connection != null) {
		    		try(PreparedStatement pstmt = connection.prepareStatement(SQL_INSERT_QUERY)){
		    			
		    			pstmt.setString(1, name);
		    			pstmt.setString(2, address);
		    			pstmt.setString(3, resumeLoc);
		    			pstmt.setString(4, photoLoc);
		    			
		    			int rowCount = pstmt.executeUpdate();
		    			if(rowCount == 0) {
		    				out.println("<h1>Registration is not completed ...</h1>");
		    			}else {
		    				out.println("<h1>Registration is completed successfully....</h1>");

		    			}
		    		}
		    	}
		    	
		    } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		out.println("<a href='index.html'>|Home Page|</a>");
	    
	}

}
