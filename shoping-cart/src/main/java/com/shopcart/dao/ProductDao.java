package com.shopcart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopcart.model.Cart;
import com.shopcart.model.Product;

public class ProductDao {
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	private String query;

	public ProductDao(Connection con) {
		this.con = con;
	}
	
	public List<Product> getAllProduct() throws SQLException{
		List<Product> product = new ArrayList<Product>();
		
		query = "select * from products";
		pst = this.con.prepareStatement(query);
		rs  = pst.executeQuery();
		
		while(rs.next()) {
			Product row = new Product();
			row.setId(rs.getInt("id"));
			row.setName(rs.getString("name"));
			row.setCategory(rs.getString("category"));
			row.setPrice(rs.getDouble("price"));
			row.setImage(rs.getString("image"));
			
			product.add(row);
		}
		return product;
	}
	public List<Cart> getCarProduct(ArrayList<Cart> cartList) throws SQLException{
		List<Cart> products = new ArrayList<Cart>();
		
		if(cartList.size()>0) {
			for(Cart item:cartList) {
			 query = "select * from products where id=?";
				pst = this.con.prepareStatement(query);
				pst.setInt(1, item.getId());
				rs = pst.executeQuery();
				while(rs.next()) {
					Cart row = new Cart();
					row.setId(rs.getInt("id"));
					row.setName(rs.getString("name"));
					row.setCategory(rs.getString("category"));
					row.setPrice(rs.getDouble("price")*item.getQuantity());
					row.setQuantity(item.getQuantity());

					products.add(row);
				}
			}
		}
		
		return products;
	}
	public double getTotalPrice(ArrayList<Cart> cartList) {
		double sum = 0.0;
		
		try {
			if(cartList.size()>0) {
				for(Cart item:cartList) {
					query = "select price from products where id=?";
					pst = this.con.prepareStatement(query);
					pst.setInt(1, item.getId());
					rs = pst.executeQuery();
					
					while(rs.next()) {
						
						sum+= rs.getDouble("price")*item.getQuantity();
						System.out.println("price"+sum);
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return sum;
	}

}
