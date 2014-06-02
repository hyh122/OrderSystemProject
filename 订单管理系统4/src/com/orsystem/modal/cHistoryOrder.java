package com.orsystem.Modal;
/*
 * 客户的历史订单Modal
 */
public class cHistoryOrder {
	private String Orderdate;
	private String OrderNo;
	private String ProductNo;
	private String ProductName;
	private String qty;
	private String sin_price;
	private String total_price;
	public cHistoryOrder() {
		super();
	}
	public cHistoryOrder(String orderdate, String orderNo, String productNo,
			String productName, String qty, String sin_price, String total_price) {
		super();
		Orderdate = orderdate;
		OrderNo = orderNo;
		ProductNo = productNo;
		ProductName = productName;
		this.qty = qty;
		this.sin_price = sin_price;
		this.total_price = total_price;
	}
	public String getOrderdate() {
		return Orderdate;
	}
	public void setOrderdate(String orderdate) {
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
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getSin_price() {
		return sin_price;
	}
	public void setSin_price(String sin_price) {
		this.sin_price = sin_price;
	}
	public String getTotal_price() {
		return total_price;
	}
	public void setTotal_price(String total_price) {
		this.total_price = total_price;
	}
	
	

	
}
