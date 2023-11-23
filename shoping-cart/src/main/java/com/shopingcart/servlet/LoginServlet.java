package com.shopingcart.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.shopcart.connection.DataBaseConnection;
import com.shopcart.dao.UserDao;
import com.shopcart.model.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//content type set
		PrintWriter pw = response.getWriter();
		
				response.setContentType("text/html; charset = UTF-8");
				//Print Writer
				
				pw.println("This is a login hair");
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//content type set
				response.setContentType("text/html; charset = UTF-8");
				//Print Writer
				PrintWriter pw = response.getWriter();
					pw.println("This is a login mani");
		   String email = request.getParameter("login-email");
		   String password = request.getParameter("login-password");
		   
		System.out.println(email + password);
		 
			  UserDao udao;
			try {
				udao = new UserDao(DataBaseConnection.getConnection());
				 user use =  udao.userLogin("email", "password");
				  if(use != null) {
					  pw.println("login succiss");
				  }else {
					  pw.println("login failed");
				  }
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			 
			  
		  
	}

}
