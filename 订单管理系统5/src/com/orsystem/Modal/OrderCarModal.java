package com.orsystem.Modal;

import java.util.Date;

public class OrderCarModal {
	private Date Orderdate;
	private String OrderNo;
	private String ProductNo;
	private String ProductName;
	private int qty;
	private double sin_price;
	private double total_price;
	private String customerno;
	public OrderCarModal() {
		super();
	}
	
	public OrderCarModal(Date orderdate, String orderNo, String productNo,
			String productName, int qty, double sin_price, double total_price,
			String customerno) {
		super();
		Orderdate = orderdate;
		OrderNo = orderNo;
		ProductNo = productNo;
		ProductName = productName;
		this.qty = qty;
		this.sin_price = sin_price;
		this.total_price = total_price;
		this.customerno = customerno;
	}

	public String getCustomerno() {
		return customerno;
	}

	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}

	public Date getOrderdate() {
		return Orderdate;
	}
	public void setOrderdate(Date orderdate) {
		Orderdate = orderdate;
	}
	public String getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
	}
	public String getProductNo() {
		return ProductNo;
	}
	public void setProductNo(String productNo) {
		ProductNo = productNo;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getSin_price() {
		return sin_price;
	}
	public void setSin_price(double sin_price) {
		this.sin_price = sin_price;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	
	
}
