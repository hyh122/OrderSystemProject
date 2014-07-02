package com.orsystem.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.orsystem.DataTable.OrderMaster;
import com.orsystem.Modal.DataCountModal;
import com.orsystem.Modal.cHistoryOrder;
import com.orsystem.db.JDBCTools;

public class dis_historyOrder {
	
	
	//根据客户号得到该用户的全部订单信息
	public List<cHistoryOrder> getHisOrderBycNo(String CustomerNo) throws IOException, ClassNotFoundException, SQLException{
		List<cHistoryOrder> l=new ArrayList<cHistoryOrder>();
		cHistoryOrder cho = null;
		Connection con=(Connection) JDBCTools.getConnection();
		String sql="select orderdate,od.orderno,p.productno,productname,qty,price,(qty*price) total_price from Ordermaster om,orderdetail od,product p"+
  " where om.orderno=od.orderno and od.productno=p.productno and customerno=? order by orderdate desc" ;
		PreparedStatement preparedstatement=con.prepareStatement(sql);
		preparedstatement.setString(1,CustomerNo);
		
		ResultSet rs=(ResultSet) preparedstatement.executeQuery();
		while(rs.next()){
			cho=new cHistoryOrder();
			cho.setOrderdate(String.valueOf(rs.getDate(1)));
			cho.setOrderNo(rs.getString(2));
			cho.setProductNo(rs.getString(3));
			cho.setProductName(rs.getString(4));
			cho.setQty(String.valueOf(rs.getInt(5)));
			cho.setSin_price(String.valueOf(rs.getFloat(6)));
			cho.setTotal_price(String.valueOf(rs.getFloat(7)));
			
			
			l.add(cho);
		}
		
		return l;
		
		
		
	}
	//根据日期模糊查询该用户的订单信息
	public List<cHistoryOrder> getHisOrderBycDate(String CustomerNo,String date) throws IOException, ClassNotFoundException, SQLException{
		List<cHistoryOrder> l=new ArrayList<cHistoryOrder>();
		cHistoryOrder cho = null;
		Connection con=(Connection) JDBCTools.getConnection();
		String sql="select orderdate,od.orderno,p.productno,productname,qty,price,(qty*price) total_price from Ordermaster om,orderdetail od,product p"+
  " where om.orderno=od.orderno and od.productno=p.productno and customerno=? and orderdate like ? order by orderdate desc" ;
		PreparedStatement preparedstatement=con.prepareStatement(sql);
		preparedstatement.setString(1,CustomerNo);
		preparedstatement.setString(2,date);
		ResultSet rs=(ResultSet) preparedstatement.executeQuery();
		while(rs.next()){
			cho=new cHistoryOrder();
			cho.setOrderdate(String.valueOf(rs.getDate(1)));
			cho.setOrderNo(rs.getString(2));
			cho.setProductNo(rs.getString(3));
			cho.setProductName(rs.getString(4));
			cho.setQty(String.valueOf(rs.getInt(5)));
			cho.setSin_price(String.valueOf(rs.getFloat(6)));
			cho.setTotal_price(String.valueOf(rs.getFloat(7)));
			
			
			l.add(cho);
		}
		
		return l;
		
		
		
	}
	//根据顾客号统计该顾客的历史订单信息
	public DataCountModal DataCountBycNo(String CustomerNo) {
		dis_Date date=new dis_Date();
		DataCountModal dcm=new DataCountModal();
		Connection con;
		try {
			con = (Connection) JDBCTools.getConnection();
			String sql1="select count(*),sum(ordersum) from ordermaster where customerno=?";
			String sql2="select orderno,ordersum from ordermaster where ordersum in("+
				"select max(ordersum) from ordermaster where customerno=?)";
			String sql3="select sum(ordersum) from ordermaster where customerno=? and orderdate = ?";
			
			PreparedStatement p1=con.prepareStatement(sql1);
			p1.setString(1,CustomerNo);
			ResultSet rs1=(ResultSet) p1.executeQuery();
			while(rs1.next()){
				dcm.setOrderNum(rs1.getInt(1));
				dcm.setHorderTotalPrice(rs1.getDouble(2));
			}
			PreparedStatement p2=con.prepareStatement(sql2);
			p2.setString(1,CustomerNo);
			ResultSet rs2=(ResultSet) p2.executeQuery();
			while(rs2.next()){
				dcm.setOrderNo(rs2.getString(1));
				dcm.setOrderNoPrice(rs2.getDouble(2));
			}
			PreparedStatement p3=con.prepareStatement(sql3);
			p3.setString(1,CustomerNo);
			p3.setString(2,date.get_curDate());
			ResultSet rs3=(ResultSet) p3.executeQuery();
			while(rs3.next()){
				dcm.setTodayOrderPrice(rs3.getDouble(1));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dcm;
	
		
		
		
	}
	//根据员工号得到该员工处理过的全部订单信息
	public List<cHistoryOrder> getHisOrderByeNo(String EmployeeNo) throws IOException, ClassNotFoundException, SQLException{
		List<cHistoryOrder> l=new ArrayList<cHistoryOrder>();
		cHistoryOrder cho = null;
		Connection con=(Connection) JDBCTools.getConnection();
		String sql="select orderdate,od.orderno,p.productno,productname,qty,price,(qty*price) total_price from Ordermaster om,orderdetail od,product p"+
  " where om.orderno=od.orderno and od.productno=p.productno and saleno=? order by orderdate desc";
		PreparedStatement preparedstatement=con.prepareStatement(sql);
		preparedstatement.setString(1,EmployeeNo);
		
		ResultSet rs=(ResultSet) preparedstatement.executeQuery();
		while(rs.next()){
			cho=new cHistoryOrder();
			cho.setOrderdate(String.valueOf(rs.getDate(1)));
			cho.setOrderNo(rs.getString(2));
			cho.setProductNo(rs.getString(3));
			cho.setProductName(rs.getString(4));
			cho.setQty(String.valueOf(rs.getInt(5)));
			cho.setSin_price(String.valueOf(rs.getFloat(6)));
			cho.setTotal_price(String.valueOf(rs.getFloat(7)));
			
			
			l.add(cho);
		}
		
		return l;
		
		
		
	}
	//根据员工号统计该员工的历史订单信息
	public DataCountModal DataCountByeNo(String EmployeeNo) {
		dis_Date date=new dis_Date();
		DataCountModal dcm=new DataCountModal();
		Connection con;
		try {
			con = (Connection) JDBCTools.getConnection();
			String sql1="select count(*),sum(ordersum) from ordermaster where saleno=?";
			String sql2="select count(*),sum(ordersum) from ordermaster where saleno=? and orderdate=?";
			//选择该员工的业务量排行位置
			String sql3="select saleno,sum(ordersum)total from ordermaster group by saleno";
			PreparedStatement p1=con.prepareStatement(sql1);
			p1.setString(1,EmployeeNo);
			ResultSet rs1=(ResultSet) p1.executeQuery();
			while(rs1.next()){
				dcm.setOrderNum(rs1.getInt(1));
				dcm.setHorderTotalPrice(rs1.getDouble(2));
			}
			PreparedStatement p2=con.prepareStatement(sql2);
			p2.setString(1,EmployeeNo);
			p2.setString(2,date.get_curDate());
			ResultSet rs2=(ResultSet) p2.executeQuery();
			while(rs2.next()){
				dcm.setTodayOrderNum(rs2.getInt(1));
				dcm.setOrderNoPrice(rs2.getDouble(2));
			}
			
			PreparedStatement p3=con.prepareStatement(sql3);
			
			int k=1;
			ResultSet rs3=(ResultSet) p3.executeQuery();
			while(rs3.next()){
				if(EmployeeNo.equals(rs3.getString(1))){
					dcm.setLevel(k);
					break;
				}else{
					k++;
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dcm;
	
		
		
		
	}
}
