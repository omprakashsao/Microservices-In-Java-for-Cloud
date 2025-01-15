package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		description = "working with database showing output on browser", 
		urlPatterns = { "/record" }, 
		initParams = { 
				@WebInitParam(name = "driverName", value = "com.mysql.cj.jdbc.Driver"), 
				@WebInitParam(name = "url", value = "jdbc:mysql:///student_info"), 
				@WebInitParam(name = "username", value = "root"), 
				@WebInitParam(name = "password", value = "@kjl123OM#;010")
		})
public class DBRecordApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SQL_SELECT_QUERY = "select * from student";
	Connection connection = null;
	Statement stmt = null;
	ResultSet rs = null;

	@Override
	public void init() throws ServletException {
		
		try {
			Class.forName(getInitParameter("driverName"));
			connection =DriverManager.getConnection(getInitParameter("url"), getInitParameter("username"), getInitParameter("password"));
         System.out.println(connection);
			if(connection != null)
				 stmt =connection.createStatement();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void destroy() {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt!= null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			if(stmt!= null) {
			 rs =stmt.executeQuery(SQL_SELECT_QUERY);
			
			PrintWriter out = response.getWriter();
			out.println("<h1>STUDENT  DETAILS..</h1>");
			out.println("<body align='center' style='bgcolor = 'cyan''>");
			out.println("<table>");
			out.println("<tr><th>ROLL_NO</th><th>NAME</t><th>MARKS</th></tr>");
			while(rs.next()) {
				out.println("<tr><td>"+rs.getObject(1)+"</td><td>"+rs.getObject(2)+"</td><td>"+rs.getObject(3)+"</td></tr>");
			}
			
			out.println("</table>");
			out.println("</body>");
			out.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
