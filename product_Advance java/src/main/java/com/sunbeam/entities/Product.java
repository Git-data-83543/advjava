package com.sunbeam.entities;



import javax.persistence.*;

@Entity
@Table(name="products")//to specify table name


public class Product {
	@Id
	//constraint pk not null
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)//col type:varchar
	@Column(length=20)
	private Category category;
	
	@Column(name="product_name",length=25)//col name varchar(25)
	private String Productname;
	
	@Column(name="price",length=25)//col name vardchar(25)
	private double price;
	
	@Column(length=20,unique=true)//varchar (20)unique constraint
	private int quantity;
	
	public Product() {
		super();
	}
	public Product(Category category, String product, double price, int quantity) {
		super();
		this.category = category;
		Productname = product;
		this.price = price;
		this.quantity = quantity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getProduct() {
		return Productname;
	}
	public void setProduct(String product) {
		Productname = product;
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
		return "Product [id=" + id + ", category=" + category + ", Productname=" + Productname + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
	
	

}
