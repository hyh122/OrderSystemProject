package com.orsystem.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.orsystem.DataService.COrderCarService;
import com.orsystem.DataService.CreateOrderService;
import com.orsystem.Modal.CUI_Modal2;
import com.orsystem.Modal.createOrderNo;
import com.tecService.DataClassChange;

public class CUI_Control {
	private CreateOrderService cos;
	private dis_Date disdate;
	//���ﳵ��Ŷ��������ݷ�����
	private COrderCarService corders;

	public CUI_Control() {
		cos=new CreateOrderService();
		disdate=new dis_Date();
		corders=new COrderCarService();
	}
	
	//���ɶ����ŵķ���
	//****���ɶ����ĸ�ʽǰ7λΪ���ڣ�����λΪ����˳��ţ�����20140602001,20140602002....��20140602999
	public void createOrderNo() throws IOException, ClassNotFoundException, SQLException{
		if(cos.isExistData(disdate.get_curDate())){
			createOrderNo co=new createOrderNo();
			co=cos.getOrderNoByDate2(disdate.get_curDate());
			//���Ϊһ���еڼ����µĶ���
			int time=co.getXxtimes()+1;
			//ȡ����ǰ������
			String orderno=co.getOrderno();
			//����ǰ�����ŷָ�������֣�ǰһ���������ڣ���һ�����Ƕ���˳���
			String orderno1=orderno.substring(0, 8);
			int num=Integer.parseInt(orderno.substring(9, 11));
			//����˳��ż�1
			num=num+1;
			String orderno2;
			if(num<10){
				orderno2=orderno1+"00"+num;
			}
			else if(num<100){
				orderno2=orderno1+"0"+num;
			}
			else{
				orderno2=orderno1+num;
			}
			//���µ����¶���������
			String sql="update createorderno set xxtimes=?,orderno=?";
			cos.updateOrderNoName(sql,time,orderno2);
		}else{
			//���ɵ�һ��������
			String orderno=disdate.get_curDate2()+"001";
			cos.addOrderNoName(disdate.get_curDate(),1,orderno);
		}
	
		
	}
	
	//��ö�����
	public String getOrderNo() throws IOException, ClassNotFoundException, SQLException{
		String orderno = null;
		if(cos.isExistData(disdate.get_curDate())){
		orderno=cos.getOrderNoByDate(disdate.get_curDate());
		}else{
			createOrderNo();
			getOrderNo();
		}
		return orderno;
		
	}
	
	//�����ﳵ��Ӷ����ķ���
	public void addOrder(String productno,String productname,String qty,String sin_price) throws IOException, ClassNotFoundException, SQLException{
		//����������qtyת��Ϊint��
		int qty2=DataClassChange.SchangeToInt(qty);
		Double sin_price2=DataClassChange.SchangeToDouble(sin_price);
		Double total_price=qty2*sin_price2;
		//��ӵ����ݿ���
		///***************���ﻹҪ��һ���жϣ�����ڶ�����ӵĸ���һ����ӵ���Ʒһ����������Ҳһ������ȡ��֮ǰ�ļ�¼Ȼ����Ӻ����
		if(corders.isExistequal(getOrderNo(), productno)){
			CUI_Modal2 c2=(CUI_Modal2) corders.getqtyAndprice(getOrderNo(), productno);
			int total=c2.getQty()+qty2;
			Double total_price2=total*c2.getSin_price();
			String sql="update cordercar set qty='"+total+"',total_price='"+total_price2+"' where orderno=? and productno=?";
			corders.updateCustomer(sql, getOrderNo(),productno);
		}
		else{
		corders.addCustomer(disdate.get_curDate(),getOrderNo(),productno,productname,qty2,sin_price2,total_price);}
		
		
	}
}
