package com.shopcart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shopcart.model.user;

public class UserDao {
     private Connection con;
     private PreparedStatement pst;
     private ResultSet rs;
     private String query;
     
     public UserDao(Connection con){
    	 this.con = con;
     }
     
     public user userLogin(String email, String password) {
    	 user use = null;
    	  try {
    		  query = "SELECT * FROM users where email=? and password=?";
    		  
    		  pst = this.con.prepareStatement("query");
    		  pst.setString(1, email);
    		  pst.setString(2, password);
    		  rs = pst.executeQuery();
    		  
    		  if(rs.next()) {
    			   use = new user();
    			   use.setId(rs.getInt("id"));
    			   use.setName(rs.getString("name"));
    			   use.setEmail(rs.getString("email"));
    		  }
    		  
    	  }catch(Exception e) {
    		  e.printStackTrace();
    		  System.out.println(e.getMessage());
    	  }
    	  return use;
     }
}
