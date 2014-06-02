package com.orsystem.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.orsystem.DataTable.OrderMaster;
import com.orsystem.Modal.cHistoryOrder;
import com.orsystem.db.JDBCTools;

public class dis_historyOrder {
	
	
	//根据客户号得到该用户的全部订单信息
	public List<cHistoryOrder> getHisOrderBycName(String CustomerNo) throws IOException, ClassNotFoundException, SQLException{
		List<cHistoryOrder> l=new ArrayList<cHistoryOrder>();
		cHistoryOrder cho = null;
		Connection con=(Connection) JDBCTools.getConnection();
		String sql="select orderdate,od.orderno,p.productno,productname,qty,price,(qty*price) total_price from Ordermaster om,orderdetail od,product p"+
  " where om.orderno=od.orderno and od.productno=p.productno and customerno=?";
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
}
