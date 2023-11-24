package com.shopingcart.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.shopcart.model.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		try (PrintWriter pw = response.getWriter()) {
			ArrayList<Cart> cartList = new ArrayList<>();

			int id = Integer.parseInt(request.getParameter("id"));
			Cart cm = new Cart();
			cm.setId(id);
			cm.setQuantity(1);

			HttpSession session = request.getSession();
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart_list");

			if (cart_list == null) {
				cartList.add(cm);
				session.setAttribute("cart_list", cartList);
				response.sendRedirect("index.jsp");
			} else {
				cartList = cart_list;
				boolean exist = false;

				for (Cart c : cart_list) {
					if (c.getId() == id) {
						exist = true;
						pw.println("<h4 class='my-3' style='color:red; text-align:center;'>Item already exists<a href='cart.jsp'>  Go to Cart page</a></h4>");
					}
					
				}
				if (!exist) {
					cartList.add(cm);
					response.sendRedirect("index.jsp");
				}
			}
			

		}
	}

}
