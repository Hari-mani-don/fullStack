package com.webBook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServelet extends HttpServlet {
	     private static final String query = "INSERT INTO BOOKDATA(BOOKNAME,BOOKEDITION,BOOKPRICE) VALUES(?,?,?)";
           @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	
        	   //get pritWriter
        	   PrintWriter pw = response.getWriter();
        	//set content type
        	   response.setContentType("text/html");
        	   
        	   //GET the book info
        	   String bookName = request.getParameter("bookName");
        	   String bookEdition = request.getParameter("bookeEditio");
        	   float bookPrice = Float.parseFloat(request.getParameter("bookPrice")) ;
        	  
        	   //Load jdbc driver
        	  try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
        	  //generate the connection
        	  try(Connection con = DriverManager.getConnection("jdbc:mysql:///book","root","root")){
        		  PreparedStatement ps = con.prepareStatement(query);
        		  ps.setString(1, bookName);
        		  ps.setString(2, bookEdition);
        		  ps.setFloat(3, bookPrice);
        		  
        		  int count = ps.executeUpdate();
        		  if(count == 1) {
        			  pw.println("<h2> Record is Register successfully</h2>");
        		  }else {
        			  pw.println("<h2> Record is not Register successfully</h2>");
        		  }
        	  } catch (SQLException e) {
				e.printStackTrace();
				pw.println("<h2>" + e.getMessage()+"</h2>");
			}catch(Exception e) {
				e.printStackTrace();
				pw.println("<h1>" + e.getMessage()+"</h1>");
			}
        	  pw.println("<a href='home.html'>Home</a>");
        	  pw.println("<br>");
        	  pw.println("<a href='bookList'>Book List</a>");
        	  
           }
         @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	 doGet(request,response);
        }
         
}
