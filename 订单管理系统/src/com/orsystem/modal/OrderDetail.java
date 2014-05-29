package com.orsystem.modal;

public class OrderDetail {
	private String orderNo;
	private String productNo;
	private int qty;
	private float price;
	public OrderDetail() {
		super();
	}
	public OrderDetail(String orderNo, String productNo, int qty, float price) {
		super();
		this.orderNo = orderNo;
		this.productNo = productNo;
		this.qty = qty;
		this.price = price;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderDetail [orderNo=" + orderNo + ", productNo=" + productNo
				+ ", qty=" + qty + ", price=" + price + "]";
	}
	
	
}
