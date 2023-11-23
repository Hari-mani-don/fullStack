package com.Student.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;  

public class LoginDao {
  
	public boolean insert(User user) throws SQLException {
		 Connection conn = null;
	     boolean result = false;
			try {
	     Class.forName("com.mysql.jdbc.Driver");
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","root");
		 System.out.println("Connection created successfully");
		 String query = "Insert into Login (userName, passwordd) values(?,?)";
		 System.out.println("name hari:"+user.getUserName() + "password"+user.getPassword());
		 PreparedStatement pst = conn.prepareStatement(query);
		 
		 //remove 
//		 pst.setInt(1, 4);
//		 pst.execute();
		 
//		 update into database
		 pst.setString(1, user.getUserName());
		 pst.setString(2, user.getPassword());
		 System.out.println(" successfully update");
		 int rowsAffected = pst.executeUpdate();
		 result = rowsAffected > 0;
		 
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
//				return result;
			}
//			
			//data get into database
//				Statement stmt=con.createStatement();  
//				ResultSet rs=stmt.executeQuery("select * from Login");  
//				System.out.println("result HARI"+ rs.next());  
//				con.close();  
			
          
		return result;
	}
	
	
	
}
