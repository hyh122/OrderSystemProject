package com.orsystem.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.orsystem.DataService.COrderCarService;
import com.orsystem.DataService.CreateOrderService;
import com.orsystem.DataService.EmployeeService;
import com.orsystem.DataService.NoDoOrderService;
import com.orsystem.DataService.OdService;
import com.orsystem.DataService.OrderMasterService;
import com.orsystem.Modal.CUI_Modal2;
import com.orsystem.Modal.cHistoryOrder;
import com.orsystem.Modal.createOrderNo;
import com.tecService.DataClassChange;

public class EUI_Control {
	//历史订单管理类
	private dis_historyOrder dh;
	private EmployeeService es;
	private dis_Date disdate;
	//未处理订单服务类
	private NoDoOrderService nds;
	
	//订单主表的数据服务类
	private OrderMasterService oms;
	//订单明细表数据服务类
	private OdService os;
	public EUI_Control() {
		dh=new dis_historyOrder();
		nds=new NoDoOrderService();
		disdate=new dis_Date();
		
		
	}
	
	//得到员工历史订单
	public List<cHistoryOrder> gethistoryorder(String employeeno) throws IOException, ClassNotFoundException, SQLException{
		return dh.getHisOrderByeNo(employeeno);
	}
	//得到员工未处理的订单
	public List<cHistoryOrder> getNoDoOrder(String employeeno) throws IOException, ClassNotFoundException, SQLException{
		return nds.getAllOrderByNo(employeeno);
	}
	//订单处理成功后，将处理的员工号添加到订单主表中
	public void addEmployeeNoToOM(String employeeno) throws IOException, ClassNotFoundException, SQLException{
		//得到未处理的订单号
		String[] orderno=nds.getAllOrderNoByNo(employeeno);
		//更新订单主表信息
		for(int i=0;i<orderno.length;i++){
		String sql="update ordermaster set saleno='"+employeeno+"' where orderno=?";
		oms.updateOrderMaster(sql, orderno[i]);
		}
		
	}
}
