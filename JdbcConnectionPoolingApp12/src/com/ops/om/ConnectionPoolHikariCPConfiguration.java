package com.ops.om;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPoolHikariCPConfiguration {

	public static void main(String[] args) {
		HikariConfig config = new HikariConfig("D:\\All Eclips Project\\JdbcConnectionPoolingApp12\\src\\com\\ops\\properties\\hikaricp.properties");
		try( HikariDataSource datasource= new HikariDataSource(config)){
			try(Connection connection = datasource.getConnection()){
				try(Statement stmt = connection.createStatement()){
					try(ResultSet rs = stmt.executeQuery("select * from student")){
						System.out.println("ROLL_NO\tNAME\tMARKS");
						while(rs.next()) {
							System.out.println(rs.getObject(1)+"\t"+rs.getObject(2)+"\t"+rs.getObject(3));
						}
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
       

	}

}
