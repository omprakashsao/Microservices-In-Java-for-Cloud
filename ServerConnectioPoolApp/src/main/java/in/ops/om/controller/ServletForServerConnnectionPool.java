package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ServletForServerConnnectionPool
 */
public class ServletForServerConnnectionPool extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SQL_INSERT_QUERY = "INSERT INTO STUDENT(`NAME`,`MARKS`,`ROLL_NO`) VALUES(?,?,?)";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     
		// get parameter from UI
		String name = request.getParameter("name");
		String marks = request.getParameter("marks");
		String roll_no = request.getParameter("roll_no");
		
		ServletContext context = getServletContext();
		String dsInfo = context.getInitParameter("DSINFO");
		System.out.println(dsInfo);
		
		PrintWriter out = response.getWriter();
		try(Connection connection = getPooledConnection(dsInfo)){
			if(connection != null) {
				try(PreparedStatement pstmt = connection.prepareStatement(SQL_INSERT_QUERY)){
					if(pstmt != null)
					{
						pstmt.setString(1, name);
						pstmt.setInt(2, Integer.parseInt(marks));
						pstmt.setInt(3, Integer.parseInt(roll_no));
						
						int rowCount = pstmt.executeUpdate();
						if(rowCount == 0) {
							out.println("<h1 text-align='center'>Sorry, Registration failure</h1>");
							out.println();
						}else {
							out.println("<h1 text-align='center'> Registration Successful !!</h1>");
						}
						out.println("<a href='index.html'>|Login Again|</a>");

					}
				}
				
				
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private Connection getPooledConnection(String dsInfo) throws SQLException, NamingException {
		Connection connection = null;
	
			InitialContext namingContext = new InitialContext();
			DataSource ds = (DataSource) namingContext.lookup(dsInfo);
			 connection = ds.getConnection();
			
		
		
		return connection;
	}

	

	

}
