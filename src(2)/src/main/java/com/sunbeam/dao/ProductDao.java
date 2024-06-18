package com.sunbeam.dao;

import java.time.LocalDate;
import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

/* id , category (BAKERY|SHOES|CLOTHES|STATIONAY)
 *  ,product name(unique)  , price , available quantity*/
public interface ProductDao {
   String addProduct(Product product);
   Product getProductById(int id);
//   List<Product> getLastNameByCategory(Category catrgory);
//   List<Product> testJPACtorExpression(Category category);
//	String applyDiscount(LocalDate date,double discount);
//	String deleteUserDetails(Long userId);
List<Product> getProductRange( Double price1, Double price2,Category cat);
String DiscountedProduct(Double discount,Category cat);
String purchaseProduct(int id, int quantity);
String deleteProduct(String productName);

}
