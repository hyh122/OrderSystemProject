package com.orsystem.DataService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.orsystem.Modal.cHistoryOrder;
import com.orsystem.db.JDBCTools;

public class NoDoOrderService {
	public NoDoOrderService() {
		super();
		// TODO Auto-generated constructor stub
	}

	//添加订单到未处理的订单表中
	public void addOrder(Object ... args){
		String sql="insert into nodoorder values(?,?,?,?,?,?,?,?)";
		JDBCTools.update(sql, args);
	}
	//按按员工号删除掉未处理的订单
	public void deleteOrderById(String employeeno){
		String sql="delete from nodoorder where employeeno=?";
		JDBCTools.update(sql, employeeno);
	}
	//得到某个员工未受理的全部订单,结果返回历史订单列表modal
	public List<cHistoryOrder> getAllOrderByNo(String employeeno) throws IOException, ClassNotFoundException, SQLException{
		List<cHistoryOrder> ocList=new ArrayList<cHistoryOrder>();
		
		Connection con=(Connection) JDBCTools.getConnection();
		String sql="select *from nodoorder where employeeno='"+employeeno+"'";
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
	
	//得到某个员工未受理的全部订单号,结果返回订单号
	public String[] getAllOrderNoByNo(String employeeno) throws IOException, ClassNotFoundException, SQLException{
		List<String> ocList=new ArrayList<String>();
		
		Connection con=(Connection) JDBCTools.getConnection();
		String sql="select distinct orderno from nodoorder where employeeno='"+employeeno+"'";
		Statement sta=(Statement) con.createStatement();
		ResultSet rs=sta.executeQuery(sql);
		while(rs.next()){
			System.out.println(rs.getString(1));
			ocList.add(rs.getString(1));
		}
		String[] s=new String[ocList.size()];
		
		for(int j=0;j<ocList.size();j++){
			s[j]=ocList.get(j);
		}
		return s;
		
	}
	
	
}
