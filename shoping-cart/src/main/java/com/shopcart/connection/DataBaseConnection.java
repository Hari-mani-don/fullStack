package com.shopcart.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
   private static Connection con = null;
   
   public static Connection getConnection() throws ClassNotFoundException, SQLException {
	   if(con == null) {
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   con = DriverManager.getConnection("jdbc:mysql:///ecommerce","root","root");
	   }
	   return con;
   }
}
