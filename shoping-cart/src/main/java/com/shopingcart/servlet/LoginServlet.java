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
	
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//content type set
				response.setContentType("text/html; charset = UTF-8");
				//Print Writer
				PrintWriter pw = response.getWriter();
					
		   String email = request.getParameter("login-email");
		   String password = request.getParameter("login-password");
		 
			  UserDao udao;
			try {
				udao = new UserDao(DataBaseConnection.getConnection());
				user use = udao.userLogin(email, password);
				  if(use != null) {
					 request.getSession().setAttribute("auth", use);
					 response.sendRedirect("index.jsp");
					 }else {
					  response.sendRedirect("login.jsp");
				  }
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			 
			  
		  
	}

}
