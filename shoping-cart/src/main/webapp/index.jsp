<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.shopcart.model.*"%>
<%@ page import="com.shopcart.connection.*"%>
<%@ page import="com.shopcart.dao.*"%>
<%@ page import="java.util.*"%>
<%
user auth = (user) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
}

    ProductDao pd = new ProductDao(DataBaseConnection.getConnection());;
   List<Product> products = pd.getAllProduct();
   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to shoping</title>
<%@include file="includes/header.jsp"%>
</head>
<body>
	<%@include file="/includes/navbar.jsp"%>
	<div class="container ">
		<div class="card-header my-3 ">All Products</div>
		<div class="row ">
		<%if(!products.isEmpty()){
			
			for(Product pro : products){%>
			  	<div class="col-md-3 mb-3">
				<div class="card w-100"style="width: 15rem;" >
					<img src="product-image/<%= pro.getImage() %>" class="card-img-top"
						alt="...">
					<div class="card-body">
						<h5 class="card-title"><%= pro.getName() %></h5>
						<h6 class="price">Price: $<%= pro.getPrice() %></h6>
						<h6 class="categery">Category: <%= pro.getCategory() %></h6>
						<div class="mt-3 d-flex justify-content-between">
							 <a href="add-to-cart?id=<%= pro.getId() %>" class="btn btn-sm btn-dark ">Add to Cart</a>
							 <a href="#" class="btn btn-sm btn-primary">Buy Now</a>
						</div>
					</div>
				</div>
			</div>
			<% }
		}
			%>
		
			
		</div>
	</div>

	<%@include file="/includes/footer.jsp"%>
</body>
</html>