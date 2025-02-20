package com.view;
import java.util.Scanner;

import com.model.*;
import com.service.*;
public class CashierTest {
   public static void main(String[] args) {
	add();
}
   
   static void add() {
	   char choice;
		 do{
			 
		 Scanner sc=new Scanner(System.in);
		 Cashier p=new Cashier();
		 CashierService service=new CashierServiceImpl();
		 System.out.println("enter Cashier Id");
		 p.setCashierId(sc.nextInt());
		 System.out.println("enter Cashier Name");
		 p.setCashierName(sc.next());
		 System.out.println("enter mobile number");
		 p.setMobileNumber(sc.next());
		 System.out.println("enter address");
		 p.setAddress(sc.next());
		 
		 System.out.println("enter emailaddress");
		 p.setEmailId(sc.next());
		 
		 
		 System.out.println("enter password");
		 p.setPassword(sc.next());
		 
	
		 
		 service.addCashier(p);
		 System.out.println("new Cashier added succesfully");
		
		 
		 System.out.println("Do you want to add new Cashier?(y/n)");
		 choice=sc.next().charAt(0);
		 
	 }while(choice=='y');
   }
   
   static void delete(int cashierId) {
	   CashierService service= new CashierServiceImpl();
		 service.deleteCashier(cashierId);
   }
   
   static void update(Cashier c){
	   CashierService service= new CashierServiceImpl();
		service.updateCashier(c);
   }
}
