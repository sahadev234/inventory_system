package com.service;
import java.util.List;

import com.model.*;
public interface ProductService {
     void addProduct(Product p);
     void updateProduct(Product p);
     void updateProduct(int quantity,int productId);
     void deleteProduct(int productId);
     List<Integer> getProductIds();
     List<Product> searchProduct(String productName);
     List <Product> getAllProduct();
}
