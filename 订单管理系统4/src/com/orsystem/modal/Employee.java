package com.orsystem.modal;

import java.sql.Date;

public class Employee {
	private String employeeNo;
	private String employeeName;
	private String sex;
	private Date birthday;
	private String address;
	private String telephone;
	private Date hireday;
	private String department;
	private String headship;
	private float salary;
	public Employee() {
		super();
	}
	public Employee(String employeeNo, String employeeName, String sex,
			Date birthday, String address, String telephone, Date hireday,
			String department, String headship, float salary) {
		super();
		this.employeeNo = employeeNo;
		this.employeeName = employeeName;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		this.telephone = telephone;
		this.hireday = hireday;
		this.department = department;
		this.headship = headship;
		this.salary = salary;
	}
	public String getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date biethday) {
		this.birthday = biethday;
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
	public Date getHireday() {
		return hireday;
	}
	public void setHireday(Date hireday) {
		this.hireday = hireday;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getHeadship() {
		return headship;
	}
	public void setHeadship(String headship) {
		this.headship = headship;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [employeeNo=" + employeeNo + ", employeeName="
				+ employeeName + ", sex=" + sex + ", biethday=" + birthday
				+ ", address=" + address + ", telephone=" + telephone
				+ ", hireday=" + hireday + ", department=" + department
				+ ", headship=" + headship + ", salary=" + salary + "]";
	}
	
	
}
