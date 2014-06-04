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
import com.orsystem.Modal.createOrderNo;
import com.orsystem.db.JDBCTools;

public class CreateOrderService {
	public CreateOrderService() {
		super();
		// TODO Auto-generated constructor stub
	}

	//添加订单号名
	public void addOrderNoName(Object ... args){
		String sql="insert into createOrderno values(?,?,?)";
		JDBCTools.update(sql, args);
	}

	
	//更新订单号名
	public void updateOrderNoName(String sql, Object ... args){
		JDBCTools.update(sql, args);
	}
	

	//判断某天是否已有数据，有则返回true，否则返回false
	public boolean isExistData(String date) throws IOException, ClassNotFoundException, SQLException{
		boolean flag=false;
		
		Connection con=(Connection) JDBCTools.getConnection();
		String sql="select *from CreateOrderno where orderdate=?";
		PreparedStatement preparedstatement=con.prepareStatement(sql);
		preparedstatement.setString(1, date);
		ResultSet rs=(ResultSet) preparedstatement.executeQuery();
		while(rs.next()){
		flag=true;
		break;
		}
		return flag;
		
	}
	//获得订单号
	public String getOrderNoByDate(String date) throws IOException, ClassNotFoundException, SQLException{
		Customer customer = null;
		String Orderno=new String();
		Connection con=(Connection) JDBCTools.getConnection();
		String sql="select *from CreateOrderNo where orderdate=?";
		PreparedStatement preparedstatement=con.prepareStatement(sql);
		preparedstatement.setString(1, date);
		
		ResultSet rs=(ResultSet) preparedstatement.executeQuery();
		while(rs.next()){
			
			Orderno=rs.getString(3);
			
		}
		
		return Orderno;
	}
	//获得订单信息
	public createOrderNo getOrderNoByDate2(String date) throws IOException, ClassNotFoundException, SQLException{
		Customer customer = null;
		createOrderNo co=new createOrderNo();
		Connection con=(Connection) JDBCTools.getConnection();
		String sql="select *from CreateOrderNo where orderdate=?";
		PreparedStatement preparedstatement=con.prepareStatement(sql);
		preparedstatement.setString(1, date);
		
		ResultSet rs=(ResultSet) preparedstatement.executeQuery();
		while(rs.next()){
			co.setDate(rs.getDate(1));
			co.setXxtimes(rs.getInt(2));
			co.setOrderno(rs.getString(3));
			
			
		}
		
		return co;
	}
}
