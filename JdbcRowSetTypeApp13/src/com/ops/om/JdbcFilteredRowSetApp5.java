package com.ops.om;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.Predicate;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

class FilterStudentByRollNo implements Predicate{
	private int high;
	private int low;
	
	public FilterStudentByRollNo(int high, int low) {
		this.high = high;
		this.low = low;
	}

	@Override
	public boolean evaluate(RowSet rs) {
		boolean eval = false;
		try {
			FilteredRowSet frs = (FilteredRowSet)rs;
			int roll_no = frs.getInt(1);
			boolean condition = roll_no>=high && roll_no >= low;
			if(condition) {
				eval = true;
			}
			else {
				eval = false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eval;
	}

	@Override
	public boolean evaluate(Object value, int column) throws SQLException {
		//it will be call at the time of insertion operation
		return false;
	}

	@Override
	public boolean evaluate(Object value, String columnName) throws SQLException {
		//it will be call at the time of insertion operation
		return false;
	}
	
	
}
public class JdbcFilteredRowSetApp5 {
    

	public static void main(String[] args) {
		RowSetFactory factory = null;
	     FilteredRowSet frs = null;
       
		try {
			// Note: Here is not show any connection object but it is internally get connection so connection is requited in JdbcRowSet
			
			factory = RowSetProvider.newFactory();
			frs=factory.createFilteredRowSet();
			
			frs.setUrl("jdbc:mysql://localhost:3306/student_info");
			frs.setUsername("root");
			frs.setPassword("@kjl123OM#;010");
			
			frs.setCommand("select * from student");
			
			frs.execute();
			System.out.println("rcords before filtering ");
			while(frs.next()) {
				System.out.println(frs.getObject(1)+"\t"+frs.getObject(2)+"\t"+frs.getObject(3));
			}
			
			FilterStudentByRollNo filter = new FilterStudentByRollNo(9004,0);
			frs.setFilter(filter);
			
			frs.beforeFirst();
			
			System.out.println("records after filtering..");
			while(frs.next()) {
				System.out.println(frs.getObject(1)+"\t"+frs.getObject(2)+"\t"+frs.getObject(3));
			}
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
				}
			}
		}

