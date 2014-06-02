package com.orsystem.modal;

import java.sql.Date;

public class OrderMaster {
	private String orderNo;
	private String customerNo;
	private String saleNo;
	private Date orderDate;
	private float orderSum;
	private String invoiceNO;
	public OrderMaster() {
		super();
	}
	public OrderMaster(String orderNo, String customerNo, String saleNo,
			Date orderDate, float orderSum, String invoiceNO) {
		super();
		this.orderNo = orderNo;
		this.customerNo = customerNo;
		this.saleNo = saleNo;
		this.orderDate = orderDate;
		this.orderSum = orderSum;
		this.invoiceNO = invoiceNO;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	public String getSaleNo() {
		return saleNo;
	}
	public void setSaleNo(String saleNo) {
		this.saleNo = saleNo;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public float getOrderSum() {
		return orderSum;
	}
	public void setOrderSum(float orderSum) {
		this.orderSum = orderSum;
	}
	public String getInvoiceNO() {
		return invoiceNO;
	}
	public void setInvoiceNO(String invoiceNO) {
		this.invoiceNO = invoiceNO;
	}
	@Override
	public String toString() {
		return "OrderMaster [orderNo=" + orderNo + ", customerNo=" + customerNo
				+ ", saleNo=" + saleNo + ", orderDate=" + orderDate
				+ ", orderSum=" + orderSum + ", invoiceNO=" + invoiceNO + "]";
	}
	
	
	
}
