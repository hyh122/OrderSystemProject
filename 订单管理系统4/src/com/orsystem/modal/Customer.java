package com.orsystem.modal;

public class Customer {
	private String customerNo;
	private String customerName;
	private String address;
	private String telephone;
	private String zip;//客户所在地邮编
	public Customer() {
		super();
	}
	public Customer(String customerNo, String customerName, String address,
			String telephone, String zip) {
		super();
		this.customerNo = customerNo;
		this.customerName = customerName;
		this.address = address;
		this.telephone = telephone;
		this.zip = zip;
	}
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "Customer [customerNo=" + customerNo + ", customerName="
				+ customerName + ", address=" + address + ", telephone="
				+ telephone + ", zip=" + zip + "]";
	}
	
	

	
	
}
