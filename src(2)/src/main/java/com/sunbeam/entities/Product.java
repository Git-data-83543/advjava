package com.sunbeam.entities;

import javax.persistence.*;

/* id , category (BAKERY|SHOES|CLOTHES|STATIONAY)
 *  ,product name(unique)  , price , available quantity*/
@Entity // to tell hibernate , following is a entity class , whose life cycle has to be
		// managed by hibernate
@Table(name="products") //to specify table name
public class Product {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
	
	@Enumerated(EnumType.STRING)
   private Category category;
	
	@Column(name = "product_name",length = 25,unique = true)
   private String productName;
	
   private double price;
	
   private int quantity;
	
public Product(Category category, String productName, double price, int quantity) {
	super();
	this.category = category;
	this.productName = productName;
	this.price = price;
	this.quantity = quantity;
}
public Product() {
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
@Override
public String toString() {
	return "Product [id=" + id + ", category=" + category + ", productName=" + productName + ", price=" + price
			+ ", quantity=" + quantity + "]";
}
   

   
}
