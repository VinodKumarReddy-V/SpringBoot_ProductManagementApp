package com.xyz.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_management")
public class Product {
	
	
	@Id
	@Column
	private int product_id;
	@Column
	private String productType;
	@Column
	private String productName;
	@Column
	private String rating;
	@Column
	private String comments;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int product_id, String productType, String productName, String rating, String comments) {
		super();
		this.product_id = product_id;
		this.productType = productType;
		this.productName = productName;
		this.rating = rating;
		this.comments = comments;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getproductType() {
		return productType;
	}
	public void setproductType(String productType) {
		this.productType = productType;
	}
	public String getproductName() {
		return productName;
	}
	public void setproductName(String productName) {
		this.productName = productName;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", productType=" + productType + ", productName=" + productName
				+ ", rating=" + rating + ", comments=" + comments + "]";
	}
	
	
	
}
