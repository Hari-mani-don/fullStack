package com.Registration;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.	http.HttpServletResponse;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/register")
public class registerServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //get PrintWriter
		PrintWriter pw = response.getWriter();
		//set Content type
		response.setContentType("text/html");
		
		//get user info
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String qualification = request.getParameter("qlfy");		
		String[] hobbies = request.getParameterValues("hb");
		List al = Arrays.asList(hobbies);
		//add bootstrap link
		pw.println("<link rel='stylesheet' href='css/bootstrap.css'>");
		//print data
		pw.println("<div  style='margin:auto;margin-top:50px;width:600px;'>");
		pw.println("<table class='table table-hover table-striped '>");
		pw.println("<tr>");
		pw.println("<td>Name</td>");
		pw.println("<td>"+name+"</td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>DOB</td>");
		pw.println("<td>"+dob+"</td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>Gender</td>");
		pw.println("<td>"+gender+"</td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>Qualification</td>");
		pw.println("<td>"+qualification+"</td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>Hobbies</td>");
		pw.println("<td>"+al+"</td>");
		pw.println("</tr>");
		pw.println("</table>");
		pw.println("</div>");
		
		//close stream 
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
