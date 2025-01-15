package com.ops.om;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import com.ops.utility.DBUtil;

public class SavePointInTransaction {

	public static void main(String[] args) {
		 try(Connection connection = DBUtil.getDBConnection()){
			 try(Statement stmt =  connection.createStatement()){
				 
				 connection.setAutoCommit(false);
				 
				 stmt.executeUpdate("insert into politicians(name,party) values('neeraj','bjp')");
				 stmt.executeUpdate("insert into politicians(name,party) values('om','congress')");
				 
				 Savepoint s =  connection.setSavepoint();
				 
				 stmt.executeUpdate("insert into politicians(name,party) values('HARDIK','congress')");
				 
				 System.out.println("something went wrong go to roll back....");
				 connection.rollback(s);
				 
				 connection.commit();
			 }
			 
		 } catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
