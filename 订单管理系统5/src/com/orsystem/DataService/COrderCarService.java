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

	//添加购物车订单
	public void addOrder(Object ... args){
		String sql="insert into Cordercar values(?,?,?,?,?,?,?,?)";
		JDBCTools.update(sql, args);
	}
	
	//删除某个用户购物车里的全部订单
	public void deleteCustomerById(String T){
		String sql="delete from customer where customerno=?";
		JDBCTools.update(sql, T);
	}
	
	//按客户号清空该客户购物车里的商品
	public void deleteOrderByNo(String T){
		String sql="delete from cordercar where customerNo=?";
		JDBCTools.update(sql, T);
	}
	
	//更新购物车里订单的信息
	public void updateCustomer(String sql, Object ... args){
		JDBCTools.update(sql, args);
	}
	
	//判断某个商品是否已经在同一个订单出现，有则返回true，否则返回false
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
//	//更新客户信息方法2
//	public void update(Customer c) throws IOException, ClassNotFoundException, SQLException{
//		String sql="update customer set customername='"+c.getCustomerName()+"',address='"+c.getAddress()
//		+"',telephone='"+c.getTelephone()+"',zip='"+c.getZip()+"'"+
//		"where CustomerNo='"+c.getCustomerNo()+"'";
//		Connection con=JDBCTools.getConnection();
//		Statement sta=(Statement) con.createStatement();
//		sta.executeUpdate(sql);
//		
//	}
	//得到某个客户购物车里面的全部订单,结果返回历史订单列表modal
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
	//按客户号,订单号和商品号取出购物车里的订单的数量和单价信息
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
//	//按名字查询客户信息
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
