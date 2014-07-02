package com.orsystem.Modal;

public class DataCountModal {
	private int orderNum;//订单数
	private double horderTotalPrice;//历史订单总额
	private String orderNo;
	private double orderNoPrice;//单笔订单总额
	private double todayOrderPrice;//当天订单总额
	private int todayOrderNum;//当天业务量
	
	public int getTodayOrderNum() {
		return todayOrderNum;
	}

	public void setTodayOrderNum(int todayOrderNum) {
		this.todayOrderNum = todayOrderNum;
	}

	private int level;//销售排行位置

	public DataCountModal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DataCountModal(int orderNum, double horderTotalPrice,
			String orderNo, double orderNoPrice, double todayOrderPrice,
			int level) {
		super();
		this.orderNum = orderNum;
		this.horderTotalPrice = horderTotalPrice;
		this.orderNo = orderNo;
		this.orderNoPrice = orderNoPrice;
		this.todayOrderPrice = todayOrderPrice;
		this.level = level;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public double getHorderTotalPrice() {
		return horderTotalPrice;
	}

	public void setHorderTotalPrice(double horderTotalPrice) {
		this.horderTotalPrice = horderTotalPrice;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public double getOrderNoPrice() {
		return orderNoPrice;
	}

	public void setOrderNoPrice(double orderNoPrice) {
		this.orderNoPrice = orderNoPrice;
	}

	public double getTodayOrderPrice() {
		return todayOrderPrice;
	}

	public void setTodayOrderPrice(double todayOrderPrice) {
		this.todayOrderPrice = todayOrderPrice;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
	
	
}
