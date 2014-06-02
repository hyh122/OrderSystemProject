package com.orsystem.Service;

import com.orsystem.db.JDBCTools;

public class OdService {
	public OdService() {
		super();
		// TODO Auto-generated constructor stub
	}

	//添加一条订单明细,注意因为订单明细表的主键orderno和productno分别是外键，
	//所以orderno和productno只能是现有的orderno和productno
	public void addod(Object ... args){
		String sql="insert into orderdetail values(?,?,?,?)";
		JDBCTools.update(sql, args);
	}
	
	//按订单号删除订单明细
	public void deleteodById(String T){
		String sql="delete from orderdetail where orderno=?";
		JDBCTools.update(sql, T);
	}
	

	
	//更新订单明细信息，注意因为订单明细表的主键orderno和productno分别是外键，
	//所以orderno和productno只能是现有的orderno和productno
	public void updateod(String sql, Object ... args){
		JDBCTools.update(sql, args);
	}

}
