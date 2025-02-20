package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.model.*;


public class AdminServiceImpl implements AdminService {
    private String url="jdbc:mysql://localhost:3306/inventorySystem";
    private String username="root";
    private String password="sahadev234";
	@Override
	public void addAdmin(Admin a) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				Connection con=DriverManager.getConnection(url,username,password);
				String sql="insert into admin_tbl (fName,lName,username,password,dob,address)values('"+a.getFirstName()+"','"+a.getLastName()+"','"+a.getUsername()+"','"+a.getPassword()+"','"+a.getDob()+"','"+a.getAddress()+"');";
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
	public boolean verifyAdmin(String uname,String pass) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	
		try {
			Connection con=DriverManager.getConnection(url,username,password);
			String sql="select * from admin_tbl where username='"+uname+"' and password='"+pass+"'";
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
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
	