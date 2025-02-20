package com.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.*;
public class BillServiceImpl implements BillService{
     String url="jdbc:mysql://localhost:3306/inventorySystem";
     String username="root";
     String password="sahadev234";
	@Override
	public void addBill(Bill b) {
		//
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				Connection con=DriverManager.getConnection(url,username,password);
				String sql="insert into bill_tbl (billNo,customerName,amount,date)values('"+b.getBillNo()+"','"+b.getCustomerName()+"','"+b.getAmount()+"','"+b.getDate()+"');";
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
	public void removeBill(int billNo) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				Connection con=DriverManager.getConnection(url,username,password);
				String sql="delete from bill_tbl where billNo='"+billNo+"'";
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
	public List<Bill> getAllBill(){
		List<Bill> blist=new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				Connection con=DriverManager.getConnection(url,username,password);
				String sql="select * from bill_tbl";
				Statement stm=con.createStatement();
				ResultSet rs=stm.executeQuery(sql);
				while(rs.next()) {
					Bill b=new Bill();
					b.setBillNo(rs.getInt("billNo"));
					b.setCustomerName(rs.getString("customerName"));
					b.setAmount(rs.getInt("amount"));
					b.setDate(rs.getString("date"));
					
					blist.add(b);
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
		return blist;
		
	}

	@Override
	public List<Bill> searchBill(int billNo) {
	     List<Bill> blist=new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				Connection con=DriverManager.getConnection(url,username,password);
				String sql="select * from bill_tbl where billNo='"+billNo+"'";
				Statement stm=con.createStatement();
				ResultSet rs=stm.executeQuery(sql);
				while(rs.next()) {
					Bill b=new Bill();
					b.setBillNo(rs.getInt("billNo"));
					b.setCustomerName(rs.getString("customerName"));
					b.setAmount(rs.getInt("amount"));
					b.setDate(rs.getString("date"));
					
					blist.add(b);
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
		return blist;
	}

}
