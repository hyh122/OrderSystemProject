package com.orsystem.Service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.orsystem.db.JDBCTools;
import com.orsystem.modal.Customer;
import com.orsystem.modal.Employee;
import com.orsystem.modal.OrderMaster;

public class OrderMasterService {
	public OrderMasterService() {
		super();
		// TODO Auto-generated constructor stub
	}

	//添加一条订单管理
	public void addOrderMaster(Object ... args){
		String sql="insert into ordermaster values(?,?,?,?,?,?)";
		JDBCTools.update(sql, args);
	}
	
	//按订单号删除订单
	public void deleteOrderMasterById(String T){
		String sql="delete from ordermaster where orderno=?";
		JDBCTools.update(sql, T);
	}
	

	
	//更新订单管理表信息
	public void updateOrderMaster(String sql, Object ... args){
		JDBCTools.update(sql, args);
	}
	//按员工号查询订单信息
	public OrderMaster queryOrderBysaleno(String no) throws IOException, ClassNotFoundException, SQLException{
		OrderMaster om = null;
		Connection con=(Connection) JDBCTools.getConnection();
		String sql="select *from Ordermaster where saleno=?";
		PreparedStatement preparedstatement=con.prepareStatement(sql);
		preparedstatement.setString(1, no);
		
		ResultSet rs=(ResultSet) preparedstatement.executeQuery();
		while(rs.next()){
			om=new OrderMaster();
			om.setOrderNo(rs.getString(1));
			om.setCustomerNo(rs.getString(2));
			om.setSaleNo(rs.getString(3));
			om.setOrderDate(rs.getDate(4));
			om.setOrderSum(rs.getFloat(5));
			om.setInvoiceNO(rs.getString(6));
		
		}
		
		return om;
		
	}
	
	
}
