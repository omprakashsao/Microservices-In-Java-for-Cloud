package com.ops.om;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormatApp {

	public static void main(String[] args) throws ParseException {

     String indianDate = "09-01-2032";
     SimpleDateFormat s = new SimpleDateFormat("dd-mm-yyyy");
     java.util.Date  d = s.parse(indianDate);
     long minSec = d.getTime();
     java.sql.Date  sqlDate = new java.sql.Date(minSec);
     System.out.println(sqlDate);
     
      String chinaDate = "3211-04-12";
      java.sql.Date sqlDate2  = java.sql.Date.valueOf(chinaDate);
      System.out.println(sqlDate2);
	}

}
