package com.orsystem.DataTable;

public class Product {
	private String productNo;
	private String productName;
	private String productClass;
	private float  productPrice;
	public Product() {
		super();
	}
	public Product(String productNo, String productName, String productClass,
			float productPrice) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.productClass = productClass;
		this.productPrice = productPrice;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductClass() {
		return productClass;
	}
	public void setProductClass(String productClass) {
		this.productClass = productClass;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "Product [productNo=" + productNo + ", productName="
				+ productName + ", productClass=" + productClass
				+ ", productPrice=" + productPrice + "]";
	}
	
	
}
