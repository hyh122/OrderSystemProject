package com.orsystem.DataService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.orsystem.DataTable.Customer;
import com.orsystem.DataTable.Employee;
import com.orsystem.DataTable.OrderMaster;
import com.orsystem.db.JDBCTools;

public class OrderMasterService {
	public OrderMasterService() {
		super();
		// TODO Auto-generated constructor stub
	}

	//���һ����������
	public void addOrderMaster(Object ... args){
		String sql="insert into ordermaster values(?,?,?,?,?,?)";
		JDBCTools.update(sql, args);
	}
	
	//��������ɾ������
	public void deleteOrderMasterById(String T){
		String sql="delete from ordermaster where orderno=?";
		JDBCTools.update(sql, T);
	}
	

	
	//���¶����������Ϣ
	public void updateOrderMaster(String sql, Object ... args){
		JDBCTools.update(sql, args);
	}
	//��Ա���Ų�ѯ������Ϣ
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
