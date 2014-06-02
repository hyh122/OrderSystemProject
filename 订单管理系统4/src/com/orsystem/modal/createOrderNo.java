package com.orsystem.Modal;

import java.util.Date;

public class createOrderNo {
	private Date date;
	private int xxtimes;
	private String orderno;
	public createOrderNo() {
		super();
	}
	public createOrderNo(Date date, int xxtimes, String orderno) {
		super();
		this.date = date;
		this.xxtimes = xxtimes;
		this.orderno = orderno;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getXxtimes() {
		return xxtimes;
	}
	public void setXxtimes(int xxtimes) {
		this.xxtimes = xxtimes;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	
}
