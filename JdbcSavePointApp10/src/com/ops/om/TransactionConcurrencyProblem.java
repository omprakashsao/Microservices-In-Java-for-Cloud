package com.ops.om;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.ops.utility.DBUtil;

public class TransactionConcurrencyProblem {

	public static void main(String[] args) {
		
		try(Connection  connection = DBUtil.getDBConnection()){
			
			System.out.println(connection.getTransactionIsolation());
			connection.setTransactionIsolation(8);
			System.out.println(connection.getTransactionIsolation());
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
