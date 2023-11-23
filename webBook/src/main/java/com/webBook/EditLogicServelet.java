package com.webBook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/editurl")
public class EditLogicServelet extends HttpServlet {
	private static final String query = "UPDATE BOOKDATA SET BOOKNAME=?,BOOKEDITION=?,BOOKPRICE=? where ID=?";
    @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  	//get printWriter
  	  PrintWriter pw = response.getWriter();
  	  //set content type
  	  response.setContentType("text/html");
  	  
  	  //get the id of record
  	  int id = Integer.parseInt(request.getParameter("id"));
  	  
  	  //get the edit data we want to edit
  	  String bookName = request.getParameter("bookName");
  	  String bookEdition = request.getParameter("bookEdition");
  	  Float bookPrice = Float.parseFloat(request.getParameter("bookPrice")) ;
  	  //Load jdbc driver
  	  try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
  	  //generate the connection
  	  try(Connection con = DriverManager.getConnection("jdbc:mysql:///book","root","root")){
  		  PreparedStatement ps = con.prepareStatement(query);
  		ps.setString(1, bookName);
  		ps.setString(2, bookEdition);
  		ps.setFloat(3, bookPrice);
  		ps.setInt(4, id);
  		int update = ps.executeUpdate();
  		if(update == 1) {
  			pw.println("<h2>Recod is updated successfully</h2>");
  		}else {
  			pw.println("<h2>Recod is not updated successfully</h2>");
  		}
  		
  	  } catch (SQLException e ) {
			e.printStackTrace();
			pw.println("</h1>"+e.getMessage() + "</h1>");
		}catch(Exception e){
			e.printStackTrace();
			pw.println("</h1>"+e.getMessage() + "</h1>");
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
