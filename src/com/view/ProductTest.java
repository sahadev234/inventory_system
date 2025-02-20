package com.view;
import java.util.List;
import java.util.Scanner;

import com.model.*;
import com.service.*;
public class ProductTest {
public static void main(String[] args) {
	delete(2);
	getAll();
}
 static void add() {
	 char choice;
	 do{
		 
	 Scanner sc=new Scanner(System.in);
	 Product p=new Product();
	 ProductService service=new ProductServiceImpl();
	 System.out.println("enter product Id");
	 p.setProductId(sc.nextInt());
	 System.out.println("enter product Name");
	 p.setProductName(sc.next());
	 System.out.println("enter prouduct Stock");
	 p.setAvailable(sc.nextInt());
	 System.out.println("enter marked price");
	 p.setMrp(sc.nextInt());
	 
	 service.addProduct(p);
	 System.out.println("Product added succesfully");
	
	 
	 System.out.println("Do you want to add more product");
	 choice=sc.next().charAt(0);
	 
 }while(choice=='y');
 }
 static void getAll() {
	 ProductService service=new ProductServiceImpl();
	List<Product>plist= service.getAllProduct();
	for(Product pd:plist) {
		System.out.println("ProductId="+pd.getProductId());
		System.out.println("ProductName="+pd.getProductName());
		System.out.println("Available Quantity="+pd.getAvailable());
		System.out.println("Marked Price="+pd.getMrp());
	}
 }
 static void delete(int productId) {
	 ProductService service= new ProductServiceImpl();
	 service.deleteProduct(productId);
 }
}
