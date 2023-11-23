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

@WebServlet("/editScreen")
public class EditServelet extends HttpServlet {
	private static final String query = "SELECT BOOKNAME,BOOKEDITION,BOOKPRICE FROM BOOKDATA where ID=?";
    @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  	//get printWriter
  	  PrintWriter pw = response.getWriter();
  	  //set content type
  	  response.setContentType("text/html");
  	  
  	  //get the id of record
  	  int id = Integer.parseInt(request.getParameter("id"));
  	  //Load jdbc driver
  	  try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
  	  //generate the connection
  	  try(Connection con = DriverManager.getConnection("jdbc:mysql:///book","root","root")){
  		  PreparedStatement ps = con.prepareStatement(query);
  		  ps.setInt(1, id);
  		 ResultSet rs = ps.executeQuery();
  		 rs.next();
  		 
  		 pw.println("<form action='editurl?id="+id + "' method='post'>");
  		 pw.println("<table align='center'>");
  		 pw.println("<tr>");
  		 pw.println("<td>BOOK NAME</td>");
  		 pw.println("<td><input type='text' name='bookName' value='"+rs.getString(1)+ "'</td>");
  		 pw.println("</tr>");
  		 pw.println("<tr>");
  		 pw.println("<td>BOOK EDITION</td>");
  		 pw.println("<td><input type='text' name='bookEdition' value='"+rs.getString(2)+ "'</td>");
  		 pw.println("</tr>");
  		 pw.println("<tr>");
  		 pw.println("<td>BOOK PRICE</td>");
  		 pw.println("<td><input type='text' name='bookPrice' value='"+rs.getFloat(3)+ "'</td>");
  		 pw.println("</tr>");
  		 pw.println("<tr>");
  		 pw.println("<td><input type='submit' value='save'></td>");
  		 pw.println("<td><input type='reset' value='clear'></td>");
  		 pw.println("</tr>");
  		pw.println("</table>");
  		pw.println("</form>");
  		
  	  } catch (SQLException e ) {
			e.printStackTrace();
			pw.println("</h1>"+e.getMessage() + "</h1>");
		}catch(Exception e){
			e.printStackTrace();
			pw.println("</h1>"+e.getMessage() + "</h1>");
		}
  	  pw.println("<a href='home.html'>Home</a>");
  	  
  }
    @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  	doGet(request,response);
  }
}
