package com.ops.om;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

import com.ops.utility.DBUtil;

public class JdbcJoinRowSetApp4 {
    public static void main(String[] args) {
		
    	RowSetFactory factory;
    	WebRowSet wrs = null;
    	FileWriter fw = null;
		try {
			// Note: Here is not show any connection object but it is internally get connection so connection is requited in JdbcRowSet
			Connection connection = DBUtil.getDBConnection();
			
			factory = RowSetProvider.newFactory();
			CachedRowSet crs1 = factory.createCachedRowSet();
			crs1.setCommand("select * from users");
			crs1.execute(connection);
			CachedRowSet  crs2 = factory.createCachedRowSet();
			crs2.setCommand("select * from users_address");
			crs2.execute(connection);
			
			JoinRowSet jrs = factory.createJoinRowSet();
			jrs.addRowSet(crs1, 1);
			jrs.addRowSet(crs2,2);
			System.out.println("id\tname\t\tdate\t\tcity");
			jrs.afterLast();
			while(jrs.previous()) {
				
				System.out.println(jrs.getObject(1)+"\t"+jrs.getObject(2)+"\t\t"+jrs.getObject(3)+"\t"+jrs.getObject(4));
			}
			
			
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
