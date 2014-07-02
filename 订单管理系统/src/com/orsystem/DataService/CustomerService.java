package com.orsystem.DataService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.orsystem.DataTable.Customer;
import com.orsystem.DataTable.Employee;
import com.orsystem.db.JDBCTools;



public class CustomerService {
	public CustomerService() {
		super();
		// TODO Auto-generated constructor stub
	}

	//添加客户
	public void addCustomer(Object ... args){
		String sql="insert into Customer values(?,?,?,?,?)";
		JDBCTools.update(sql, args);
	}
	//添加客户账号信息
	public void addCustomer2(Object ... args){
		String sql="insert into cacount values(?,?)";
		JDBCTools.update(sql, args);
	}
	//按客户号删除客户
	public void deleteCustomerById(String T){
		String sql="delete from customer where customerno=?";
		JDBCTools.update(sql, T);
	}
	
	//按姓名删除客户
	public void deleteCustomerByName(String T){
		String sql="delete from customer where customerName=?";
		JDBCTools.update(sql, T);
	}
	
	//更新客户信息
	public void updateCustomer(String sql, Object ... args){
		JDBCTools.update(sql, args);
	}
	//更新客户信息方法2
	public void update(Customer c) throws IOException, ClassNotFoundException, SQLException{
		String sql="update customer set customername='"+c.getCustomerName()+"',address='"+c.getAddress()
		+"',telephone='"+c.getTelephone()+"',zip='"+c.getZip()+"'"+
		"where CustomerNo='"+c.getCustomerNo()+"'";
		Connection con=JDBCTools.getConnection();
		Statement sta=(Statement) con.createStatement();
		sta.executeUpdate(sql);
		
	}
	//得到客户的密码
	public String getPasswd(String CustomerNo){
		String passwd=null;
		
		try {
			Connection con=(Connection) JDBCTools.getConnection();
			String sql="select Passwd from cacount wheree customerno=?";
			PreparedStatement preparedstatement;
			preparedstatement = con.prepareStatement(sql);
			preparedstatement.setString(1,CustomerNo);
			
			ResultSet rs=(ResultSet) preparedstatement.executeQuery();
			while(rs.next()){
				passwd=rs.getString(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return passwd;
		
	}
	//更新客户的密码
	public void refreshPasswd(String CustomerNo,String Passwd){
		
		
		
			Connection con;
			try {
				con = (Connection) JDBCTools.getConnection();
				String sql="update cacount set Passwd=? where customerno=?";
				PreparedStatement preparedstatement;
				preparedstatement = con.prepareStatement(sql);
				preparedstatement.setString(1,Passwd);
				preparedstatement.setString(2,CustomerNo);
				preparedstatement.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
		
	}
	//得到全部客户信息
	public List<Customer> getAllCustomer() throws IOException, ClassNotFoundException, SQLException{
		List<Customer> cList=new ArrayList<Customer>();
		
		Connection con=(Connection) JDBCTools.getConnection();
		String sql="select *from Customer";
		Statement sta=(Statement) con.createStatement();
		ResultSet rs=sta.executeQuery(sql);
		while(rs.next()){
			Customer customer=new Customer();
		customer.setCustomerNo(rs.getString(1));
		customer.setCustomerName(rs.getString(2));
		customer.setAddress(rs.getString(3));
		customer.setTelephone(rs.getString(4));
		customer.setZip(rs.getString(5));
		
			cList.add(customer);
		}
		return cList;
		
	}
	//按客户号查询客户信息
	public Customer queryCustomerById(String id) throws IOException, ClassNotFoundException, SQLException{
		Customer customer = null;
		Connection con=(Connection) JDBCTools.getConnection();
		String sql="select *from Customer where customerno=?";
		PreparedStatement preparedstatement=con.prepareStatement(sql);
		preparedstatement.setString(1, id);
		
		ResultSet rs=(ResultSet) preparedstatement.executeQuery();
		while(rs.next()){
			customer=new Customer();
			customer.setCustomerNo(rs.getString(1));
			customer.setCustomerName(rs.getString(2));
			customer.setAddress(rs.getString(3));
		
			
			customer.setTelephone(rs.getString(4));
			
			customer.setZip(rs.getString(5));
			
		}
		
		return customer;
		
	}
	
	//按名字查询客户信息
		public Customer queryCustomerByName(String name) throws IOException, ClassNotFoundException, SQLException{
			Customer customer = null;
			Connection con=(Connection) JDBCTools.getConnection();
			String sql="select *from customer where customername=?";
			PreparedStatement preparedstatement=con.prepareStatement(sql);
			preparedstatement.setString(1, name);
			
			ResultSet rs=(ResultSet) preparedstatement.executeQuery();
			while(rs.next()){
				customer=new Customer();
				customer.setCustomerNo(rs.getString(1));
				customer.setCustomerName(rs.getString(2));
				customer.setAddress(rs.getString(3));
			
				
				customer.setTelephone(rs.getString(4));
				
				customer.setZip(rs.getString(5));
			}
			
			return customer;
			
		}
}
