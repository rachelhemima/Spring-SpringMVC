package ai.jobiak.cart;

import java.io.Serializable;

public class Product implements Serializable{
	private String ProductId;
	private String description;
	private double price;
	
	public Product(String productId, String description, double price) {
		super();
		ProductId = productId;
		this.description = description;
		this.price = price;
	}
	public String getProductId() {
		return ProductId;
	}
	public void setProductId(String productId) {
		ProductId = productId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
	
	
