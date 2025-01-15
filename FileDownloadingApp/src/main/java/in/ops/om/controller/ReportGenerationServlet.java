package in.ops.om.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ReportGenerationServlet
 */
@WebServlet("/showReport")
public class ReportGenerationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String SELECT_SQL_QUERY = "select pid, pname, paddress , resumeloc , photoloc from person_profile  ";

	@Resource(name = "JNDI")
	 private DataSource ds;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		try(Connection con = ds.getConnection()){
			
			if(con != null) {
				try(PreparedStatement pstmt = con.prepareStatement(SELECT_SQL_QUERY)){
					if(pstmt != null) {
						try(ResultSet rs = pstmt.executeQuery()){
							out.println("<table>");
							out.println("<thead><th>PID</th><th>PNAME</th><th>PADDRESS</th><th>RESUMELOC</th><th>PHOTOLOC</th></thead>");
							while(rs.next()) {
								out.println("<tr>");
								out.println("<td>"+ rs.getInt(1)+"</td>");
								out.println("<td>"+ rs.getString(2)+"</td>");
								out.println("<td>"+ rs.getString(3)+"</td>");
								out.println("<td><a href='./downloadurl?id="+rs.getInt(1)+"&type=resume'> DOWNLOAD </a></td>");
								out.println("<td><a href='./downloadurl?id="+rs.getInt(1)+"&type=photo'>DOWNLOAD</a></td>");
								out.println("</tr>");
							}
							out.println("</table>");
						}
					}
					 
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
