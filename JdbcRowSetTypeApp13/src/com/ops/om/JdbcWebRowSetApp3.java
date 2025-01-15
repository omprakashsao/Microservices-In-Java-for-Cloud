package com.ops.om;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class JdbcWebRowSetApp3 {
    public static void main(String[] args) {
		
    	RowSetFactory factory;
    	WebRowSet wrs = null;
    	FileWriter fw = null;
		try {
			// Note: Here is not show any connection object but it is internally get connection so connection is requited in JdbcRowSet
			factory = RowSetProvider.newFactory();
			 wrs = factory.createWebRowSet();
			wrs.setUrl("jdbc:mysql://localhost:3306/student_info");
			wrs.setUsername("root");
			wrs.setPassword("@kjl123OM#;010");
			
			wrs.setCommand("select * from student");
			
			wrs.execute();
			
			
		      fw = new FileWriter("student.xml");
		     wrs.writeXml(fw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(wrs!=null) {
				try {
					wrs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
