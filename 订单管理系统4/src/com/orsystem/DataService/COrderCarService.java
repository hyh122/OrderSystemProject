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
import com.orsystem.Modal.CUI_Modal2;
import com.orsystem.db.JDBCTools;

public class COrderCarService {
	public COrderCarService() {
		super();
		// TODO Auto-generated constructor stub
	}

	//��ӹ��ﳵ����
	public void addCustomer(Object ... args){
		String sql="insert into Cordercar values(?,?,?,?,?,?,?)";
		JDBCTools.update(sql, args);
	}
	
//	//���ͻ���ɾ���ͻ�
//	public void deleteCustomerById(String T){
//		String sql="delete from customer where customerno=?";
//		JDBCTools.update(sql, T);
//	}
//	
//	//������ɾ���ͻ�
//	public void deleteCustomerByName(String T){
//		String sql="delete from customer where customerName=?";
//		JDBCTools.update(sql, T);
//	}
//	
	//���¹��ﳵ�ﶩ������Ϣ
	public void updateCustomer(String sql, Object ... args){
		JDBCTools.update(sql, args);
	}
	
	//�ж�ĳ����Ʒ�Ƿ��Ѿ���ͬһ���������֣����򷵻�true�����򷵻�false
	public boolean isExistequal(String orderno,String productno) throws IOException, ClassNotFoundException, SQLException{
		boolean flag=false;
		
		Connection con=(Connection) JDBCTools.getConnection();
		String sql="select *from cordercar where orderno=? and productno=?";
		PreparedStatement preparedstatement=con.prepareStatement(sql);
		preparedstatement.setString(1, orderno);
		preparedstatement.setString(2, productno);
		ResultSet rs=(ResultSet) preparedstatement.executeQuery();
		while(rs.next()){
		flag=true;
		break;
		}
		return flag;
		
	}
//	//���¿ͻ���Ϣ����2
//	public void update(Customer c) throws IOException, ClassNotFoundException, SQLException{
//		String sql="update customer set customername='"+c.getCustomerName()+"',address='"+c.getAddress()
//		+"',telephone='"+c.getTelephone()+"',zip='"+c.getZip()+"'"+
//		"where CustomerNo='"+c.getCustomerNo()+"'";
//		Connection con=JDBCTools.getConnection();
//		Statement sta=(Statement) con.createStatement();
//		sta.executeUpdate(sql);
//		
//	}
//	//�õ�ȫ���ͻ���Ϣ
//	public List<Customer> getAllCustomer() throws IOException, ClassNotFoundException, SQLException{
//		List<Customer> cList=new ArrayList<Customer>();
//		
//		Connection con=(Connection) JDBCTools.getConnection();
//		String sql="select *from Customer";
//		Statement sta=(Statement) con.createStatement();
//		ResultSet rs=sta.executeQuery(sql);
//		while(rs.next()){
//			Customer customer=new Customer();
//		customer.setCustomerNo(rs.getString(1));
//		customer.setCustomerName(rs.getString(2));
//		customer.setAddress(rs.getString(3));
//		customer.setTelephone(rs.getString(4));
//		customer.setZip(rs.getString(5));
//		
//			cList.add(customer);
//		}
//		return cList;
//		
//	}
	//�������ź���Ʒ��ȡ�����ﳵ��Ķ����������͵�����Ϣ
	public CUI_Modal2 getqtyAndprice (String orderno,String productno) throws IOException, ClassNotFoundException, SQLException{
		CUI_Modal2 c2=new CUI_Modal2();
		Connection con=(Connection) JDBCTools.getConnection();
		String sql="select *from cordercar where orderno=? and productno=?";
		PreparedStatement preparedstatement=con.prepareStatement(sql);
		preparedstatement.setString(1, orderno);
		preparedstatement.setString(2, productno);
		
		ResultSet rs=(ResultSet) preparedstatement.executeQuery();
		while(rs.next()){
			c2.setQty(rs.getInt("qty"));
			c2.setSin_price(rs.getDouble("sin_price"));
			
		}
		
		return c2;
		
	}
//	
//	//�����ֲ�ѯ�ͻ���Ϣ
//		public Customer queryCustomerByName(String name) throws IOException, ClassNotFoundException, SQLException{
//			Customer customer = null;
//			Connection con=(Connection) JDBCTools.getConnection();
//			String sql="select *from customer where customername=?";
//			PreparedStatement preparedstatement=con.prepareStatement(sql);
//			preparedstatement.setString(1, name);
//			
//			ResultSet rs=(ResultSet) preparedstatement.executeQuery();
//			while(rs.next()){
//				customer=new Customer();
//				customer.setCustomerNo(rs.getString(1));
//				customer.setCustomerName(rs.getString(2));
//				customer.setAddress(rs.getString(3));
//			
//				
//				customer.setTelephone(rs.getString(4));
//				
//				customer.setZip(rs.getString(5));
//			}
//			
//			return customer;
//			
//		}
}
