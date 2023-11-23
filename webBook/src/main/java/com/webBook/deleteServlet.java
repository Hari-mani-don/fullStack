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

@WebServlet("/deleteUrl")
public class deleteServlet extends HttpServlet {
	private static final String query = "DELETE FROM BOOKDATA where ID=?";
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
  		int delete = ps.executeUpdate();
  		if(delete == 1) {
  			pw.println("<h2>Recod is deleted successfully</h2>");
  		}else {
  			pw.println("<h2>Recod is not deleted successfully</h2>");
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
