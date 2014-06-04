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
import com.orsystem.Modal.OrderCarModal;
import com.orsystem.Modal.cHistoryOrder;
import com.orsystem.db.JDBCTools;

public class COrderCarService {
	public COrderCarService() {
		super();
		// TODO Auto-generated constructor stub
	}

	//��ӹ��ﳵ����
	public void addOrder(Object ... args){
		String sql="insert into Cordercar values(?,?,?,?,?,?,?,?)";
		JDBCTools.update(sql, args);
	}
	
	//ɾ��ĳ���û����ﳵ���ȫ������
	public void deleteCustomerById(String T){
		String sql="delete from customer where customerno=?";
		JDBCTools.update(sql, T);
	}
	
	//���ͻ�����ոÿͻ����ﳵ�����Ʒ
	public void deleteOrderByNo(String T){
		String sql="delete from cordercar where customerNo=?";
		JDBCTools.update(sql, T);
	}
	
	//���¹��ﳵ�ﶩ������Ϣ
	public void updateCustomer(String sql, Object ... args){
		JDBCTools.update(sql, args);
	}
	
	//�ж�ĳ����Ʒ�Ƿ��Ѿ���ͬһ���������֣����򷵻�true�����򷵻�false
	public boolean isExistequal(String customerno,String orderno,String productno) throws IOException, ClassNotFoundException, SQLException{
		boolean flag=false;
		
		Connection con=(Connection) JDBCTools.getConnection();
		String sql="select *from cordercar where customerNo=? and orderno=? and productno=?";
		PreparedStatement preparedstatement=con.prepareStatement(sql);
		preparedstatement.setString(1, customerno);
		preparedstatement.setString(2, orderno);
		preparedstatement.setString(3, productno);
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
	//�õ�ĳ���ͻ����ﳵ�����ȫ������,���������ʷ�����б�modal
	public List<cHistoryOrder> getAllOrderByNo(String customerno) throws IOException, ClassNotFoundException, SQLException{
		List<cHistoryOrder> ocList=new ArrayList<cHistoryOrder>();
		
		Connection con=(Connection) JDBCTools.getConnection();
		String sql="select *from cordercar where customerno='"+customerno+"'";
		Statement sta=(Statement) con.createStatement();
		ResultSet rs=sta.executeQuery(sql);
		while(rs.next()){
			cHistoryOrder cho=new cHistoryOrder();
			cho.setOrderdate(String.valueOf(rs.getDate(1)));
			cho.setOrderNo(rs.getString(2));
			cho.setProductNo(rs.getString(3));
			cho.setProductName(rs.getString(4));
			cho.setQty(String.valueOf(rs.getInt(5)));
			cho.setSin_price(String.valueOf(rs.getDouble(6)));
			cho.setTotal_price(String.valueOf(rs.getDouble(7)));
		
			ocList.add(cho);
		}
		return ocList;
		
	}
	//���ͻ���,�����ź���Ʒ��ȡ�����ﳵ��Ķ����������͵�����Ϣ
	public CUI_Modal2 getqtyAndprice (String customerno,String orderno,String productno) throws IOException, ClassNotFoundException, SQLException{
		CUI_Modal2 c2=new CUI_Modal2();
		Connection con=(Connection) JDBCTools.getConnection();
		String sql="select *from cordercar where customerno=? and orderno=? and productno=?";
		PreparedStatement preparedstatement=con.prepareStatement(sql);
		preparedstatement.setString(1, customerno);
		preparedstatement.setString(2, orderno);
		preparedstatement.setString(3, productno);
		
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
