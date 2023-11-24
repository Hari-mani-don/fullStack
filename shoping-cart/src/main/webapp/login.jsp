<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="com.shopcart.model.*"%>
	<%@ page import="com.shopcart.connection.*"%>
	<%
	user auth = (user) request.getSession().getAttribute("auth");
	if(auth != null){
		response.sendRedirect("index.jsp");
	}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shoping Cart Login</title>
<%@include file="includes/header.jsp"%>
</head>
<body>
<%@include file="/includes/navbar.jsp"%>
	<div class="container ">
		<div class="card w-50  my-5 mx-auto ">
			<div class="card-header text-center">User Login</div>
			<div class="card-body">
				<form action="user-login" method="post">

					<div class="form-group">
						<label>Email Address</label> <input type="text" name="login-email"
							class="form-control" placeholder="Enter Your Email" required>
					</div>
					<div class="form-group">
						<label>Password</label> <input type="Password"
							class="form-control" name="login-password" placeholder="********"
							required>
					</div>

					<div class="text-center my-3" >
						<button type="submit" class="btn btn-danger">Login</button>
					</div>


				</form>
			</div>
		</div>
	</div>



	<%@include file="/includes/footer.jsp"%>
</body>
</html>