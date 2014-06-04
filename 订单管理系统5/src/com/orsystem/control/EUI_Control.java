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
	//��ʷ����������
	private dis_historyOrder dh;
	private EmployeeService es;
	private dis_Date disdate;
	//δ������������
	private NoDoOrderService nds;
	
	//������������ݷ�����
	private OrderMasterService oms;
	//������ϸ�����ݷ�����
	private OdService os;
	public EUI_Control() {
		dh=new dis_historyOrder();
		nds=new NoDoOrderService();
		disdate=new dis_Date();
		
		
	}
	
	//�õ�Ա����ʷ����
	public List<cHistoryOrder> gethistoryorder(String employeeno) throws IOException, ClassNotFoundException, SQLException{
		return dh.getHisOrderByeNo(employeeno);
	}
	//�õ�Ա��δ����Ķ���
	public List<cHistoryOrder> getNoDoOrder(String employeeno) throws IOException, ClassNotFoundException, SQLException{
		return nds.getAllOrderByNo(employeeno);
	}
	//��������ɹ��󣬽������Ա������ӵ�����������
	public void addEmployeeNoToOM(String employeeno) throws IOException, ClassNotFoundException, SQLException{
		//�õ�δ����Ķ�����
		String[] orderno=nds.getAllOrderNoByNo(employeeno);
		//���¶���������Ϣ
		for(int i=0;i<orderno.length;i++){
		String sql="update ordermaster set saleno='"+employeeno+"' where orderno=?";
		oms.updateOrderMaster(sql, orderno[i]);
		}
		
	}
}
