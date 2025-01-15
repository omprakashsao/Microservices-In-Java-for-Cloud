package com.ops.om;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import com.ops.utility.DBUtil;

public class CachedRowSetApp2 {
    public static void main(String[] args) {
		CachedRowSet crs = null;
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
    	RowSetFactory factory;
		try {
			connection = DBUtil.getDBConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from student");
			
			factory = RowSetProvider.newFactory();
            crs = factory.createCachedRowSet();
            crs.populate(rs);
            //even connection is close() we can retrive data using CachedRowSet , therefore connection is not required
           connection.close();
           System.out.println("records in forward direction");
           System.out.println("roll_no\tname\tmarks");
          
			
			
			while(crs.next()) {
				System.out.println(crs.getObject(1)+"\t"+crs.getObject(2)+"\t"+crs.getObject(3));
			}
			
			System.out.println("records in backward direction");
			 System.out.println("roll_no\tname\tmarks");
			while(crs.previous()) {
				System.out.println(crs.getObject(1)+"\t"+crs.getObject(2)+"\t"+crs.getObject(3));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
