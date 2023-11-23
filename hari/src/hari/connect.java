package hari;
import java.sql.*;
public class connect {
       public static void main(String args[]) {
    	   String url = "jdbc:mysql://localhost:3306/hari";
    	   String username = "root";
    	   String password = "root";
    	   
    	   try {
			Connection connection = DriverManager.getConnection(url, username, password);
		    Statement statement = connection.createStatement();
		    
		    String query = "select name from mani";
		    ResultSet resultset = statement.executeQuery(query);
		    while(resultset.next()) {
		    	System.out.println("Name: "+resultset.getString("name"));
		    }
		    connection.close();
    	   } catch (SQLException e) {
			
			e.printStackTrace();
		}
       }
}
