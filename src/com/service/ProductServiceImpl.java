package com.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.*;
public class ProductServiceImpl implements ProductService {
    String url="jdbc:mysql://localhost:3306/inventorySystem";
    String username="root";
    String password="sahadev234";
	@Override
	public void addProduct(Product p) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				Connection con=DriverManager.getConnection(url,username,password);
				String sql="insert into product_tbl (productId,productName,available,mrp) values('"+p.getProductId()+"','"+p.getProductName()+"','"+p.getAvailable()+"','"+p.getMrp()+"')";
				
				Statement stm=con.createStatement();
				stm.execute(sql);
				
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void deleteProduct(int productId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				Connection con=DriverManager.getConnection(url,username,password);
				String sql="delete from product_tbl where productId='"+productId+"'";
				
				Statement stm=con.createStatement();
				stm.execute(sql);
				
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};

	@Override
	public void updateProduct(Product p) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				Connection con=DriverManager.getConnection(url,username,password);
				String sql="update product_tbl set productName='"+p.getProductName()+"',available=available+'"+p.getAvailable()+"',mrp='"+p.getMrp()+"'where productId='"+p.getProductId()+"'";
				
				Statement stm=con.createStatement();
				stm.execute(sql);
				
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateProduct(int quantity,int productId) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				Connection con=DriverManager.getConnection(url,username,password);
				String sql="update product_tbl set available=available-'"+quantity+"' where productId='"+productId+"'";
				
				Statement stm=con.createStatement();
				stm.execute(sql);
				
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> getAllProduct() {
      List <Product> plist =new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				Connection con=DriverManager.getConnection(url,username,password);
				String sql="select * from product_tbl";
				
				Statement stm=con.createStatement();
				stm.execute(sql);
				ResultSet rs=stm.executeQuery(sql);
				
				while(rs.next()) {
						Product p=new Product();
						p.setProductId(rs.getInt("productId"));
						p.setProductName(rs.getString("productName"));
						p.setMrp(rs.getInt("mrp"));
						p.setAvailable(rs.getInt("available"));
						
						plist.add(p);
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return plist;
	}
	

	@Override
	public List<Integer> getProductIds() {
      List <Integer> plist =new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				Connection con=DriverManager.getConnection(url,username,password);
				String sql="select productId from product_tbl";
				
				Statement stm=con.createStatement();
				stm.execute(sql);
				ResultSet rs=stm.executeQuery(sql);
				
				while(rs.next()) {
						
					plist.add(rs.getInt("productId"));
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return plist;
	}
	
	@Override
	public List<Product> searchProduct(String productName) {
	     List<Product> plist=new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				Connection con=DriverManager.getConnection(url,username,password);
				String sql="select * from product_tbl where productName like '%"+productName+"%'";
				Statement stm=con.createStatement();
				ResultSet rs=stm.executeQuery(sql);
				while(rs.next()) {
					Product p=new Product();
					p.setProductId(rs.getInt("productId"));
					p.setProductName(rs.getString("productName"));
					p.setAvailable(rs.getInt("available"));
					p.setMrp(rs.getInt("mrp"));
					
					plist.add(p);
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plist;
	}
		
}




