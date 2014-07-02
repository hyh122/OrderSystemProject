package com.orsystem.DataTable;

public class Manager {
	private String managerId;
	private String managerName;
	private String passwd;
	public Manager() {
		super();
	}
	public Manager(String managerId, String managerName, String passwd) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.passwd = passwd;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerName="
				+ managerName + ", passwd=" + passwd + "]";
	}
	
	
}
