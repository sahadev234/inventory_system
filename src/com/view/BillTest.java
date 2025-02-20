package com.view;
import java.util.Scanner;

import com.model.*;
import com.service.*;
public class BillTest {
   public static void main(String[] args) {
	remove(9);
}
   static void add() {
	   Scanner sc=new Scanner(System.in);
	   BillService service=new BillServiceImpl();
	   Bill b=new Bill();
	   Product p=new Product();
	   b.setProduct(p);
	   
	   System.out.println("enter billNo");
	   b.setBillNo(sc.nextInt());
	   
System.out.println("enter customer Name");
	   b.setCustomerName(sc.next());
	   
	   System.out.println("enter quantity");
	   b.setQuantity(sc.nextInt());
	   
	   System.out.println("Date");
	   b.setDate(sc.next());
	   
	   System.out.println("enter mrp");
	   b.setMrp(sc.nextInt());
	   
	   System.out.println("enter discount");
	   b.setDiscount(sc.nextInt());
	   
	 
	     
	   int totalPrice=b.getQuantity()*b.getMrp();
	   int discountAmount=(int)((totalPrice)*(b.getDiscount()/100.0));
	   int amount=totalPrice-discountAmount;
	   b.setAmount(amount);
	   System.out.println("amount"+amount);
	   
	   service.addBill(b);
	   System.out.println("Bill added succesfully");
	   
	   
   }
   static void remove(int billNo) {
	   BillService service= new BillServiceImpl();
	   service.removeBill(billNo);
   }
}
