package com.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.*;
public class CashierServiceImpl implements CashierService {
       private String url="jdbc:mysql://localhost:3306/inventorySystem";
       private String username="root";
       private String password="sahadev234";
	@Override
	public void addCashier(Cashier c) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				Connection con=DriverManager.getConnection(url,username,password);
				String sql="insert into cashier_tbl (id,name,moNo,address,email,password)values('"+c.getCashierId()+"','"+c.getCashierName()+"','"+c.getMobileNumber()+"','"+c.getAddress()+"','"+c.getEmailId()+"','"+c.getPassword()+"');";
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
	public void deleteCashier(int cashierId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				Connection con=DriverManager.getConnection(url,username,password);
				String sql="delete from cashier_tbl where id='"+cashierId+"'";
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
	public void updateCashier(Cashier c) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				Connection con=DriverManager.getConnection(url,username,password);
				String sql="update cashier_tbl set name='"+c.getCashierName()+"',moNo='"+c.getMobileNumber()+"',address='"+c.getAddress()+"',email='"+c.getEmailId()+"',password='"+c.getPassword()+"' where id='"+c.getCashierId()+"' ";
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
	public List<Cashier> getAllCashier() {
      List <Cashier> clist =new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				Connection con=DriverManager.getConnection(url,username,password);
				String sql="select * from cashier_tbl";
				
				Statement stm=con.createStatement();
				stm.execute(sql);
				ResultSet rs=stm.executeQuery(sql);
				
				while(rs.next()) {
						Cashier c=new Cashier();
						c.setCashierId(rs.getInt("id"));
						c.setCashierName(rs.getString("name"));
						c.setMobileNumber(rs.getString("moNo"));
						c.setAddress(rs.getString("address"));
						c.setEmailId(rs.getString("email"));
						c.setPassword(rs.getString("password"));
						
						clist.add(c);
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
		
		return clist;
	}
	@Override
	public boolean verifyCashier(String email,String pass) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	
		try {
			Connection con=DriverManager.getConnection(url,username,password);
			String sql="select * from cashier_tbl where email=? and password=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, email);
            stmt.setString(2, pass);
			
            ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				return true;
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
	 return false;
		
	
	}

}
