package com.ops.om;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcRowSetApp {
    public static void main(String[] args) {
		
    	RowSetFactory factory;
		try {
			// Note: Here is not show any connection object but it is internally get connection so connection is requited in JdbcRowSet
			factory = RowSetProvider.newFactory();
			JdbcRowSet rs = factory.createJdbcRowSet();
			
			rs.setUrl("jdbc:mysql://localhost:3306/student_info");
			rs.setUsername("root");
			rs.setPassword("@kjl123OM#;010");
			
			rs.setCommand("select * from student");
			
			rs.execute();
			System.out.println("records in forward direction");
			while(rs.next()) {
				System.out.println(rs.getObject(1)+"\t"+rs.getObject(2)+"\t"+rs.getObject(3));
			}
			
			System.out.println("records in backward direction");
			while(rs.previous()) {
				System.out.println(rs.getObject(1)+"\t"+rs.getObject(2)+"\t"+rs.getObject(3));
			}
			
			//delete operation
			while(rs.next()) {
				String name= rs.getString(2);
				if(name.equalsIgnoreCase("dipikA")) {
					rs.deleteRow();
					System.out.println("row is deleted sucessfully..");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
