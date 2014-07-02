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

public class CUI_Control {
	private CreateOrderService cos;
	private EmployeeService es;
	private dis_Date disdate;
	private NoDoOrderService nds;
	//���ﳵ��Ŷ��������ݷ�����
	private COrderCarService corders;
	//������������ݷ�����
	private OrderMasterService oms;
	//������ϸ�����ݷ�����
	private OdService os;
	public CUI_Control() {
		cos=new CreateOrderService();
		disdate=new dis_Date();
		corders=new COrderCarService();
		
	}
	
	//���ɶ����ŵķ���
	//****���ɶ����ĸ�ʽǰ7λΪ���ڣ�����λΪ����˳��ţ�����20140602001,20140602002....��20140602999
	public String createOrderNo() throws IOException, ClassNotFoundException, SQLException{
		String orderno;
		if(cos.isExistData(disdate.get_curDate())){
			createOrderNo co=new createOrderNo();
			co=cos.getOrderNoByDate2(disdate.get_curDate());
			//���Ϊһ���еڼ����µĶ���
			int time=co.getXxtimes()+1;
			//ȡ����ǰ������
			String orderno2=co.getOrderno();
			//����ǰ�����ŷָ�������֣�ǰһ���������ڣ���һ�����Ƕ���˳���
			String orderno1=orderno2.substring(0, 8);
			int num=Integer.parseInt(orderno2.substring(9, 12));
			//����˳��ż�1
			num=num+1;
			
			if(num<10){
				orderno=orderno1+"000"+num;
			}
			else if(num<100){
				orderno=orderno1+"00"+num;
			}
			else if(num<1000){
				orderno=orderno1+"0"+num;
			}else{
				orderno=orderno1+num;
			}
			//���µ����¶���������
			String sql="update createorderno set xxtimes=?,orderno=? where orderdate=?";
			cos.updateOrderNoName(sql,time,orderno,disdate.get_curDate());
		}else{
			//���ɵ�һ��������
			 orderno=disdate.get_curDate2()+"0001";
			cos.addOrderNoName(disdate.get_curDate(),1,orderno);
		}
	return orderno;
		
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
	public void addOrder(String customerno,String orderno,String productno,String productname,String qty,String sin_price) throws IOException, ClassNotFoundException, SQLException{
		//����������qtyת��Ϊint��
		int qty2=DataClassChange.SchangeToInt(qty);
		Double sin_price2=DataClassChange.SchangeToDouble(sin_price);
		Double total_price=qty2*sin_price2;
		//��ӵ����ݿ���
		///***************���ﻹҪ��һ���жϣ�����ڶ�����ӵĸ���һ����ӵ���Ʒһ����������Ҳһ������ȡ��֮ǰ�ļ�¼Ȼ����Ӻ����
		if(corders.isExistequal(customerno,getOrderNo(), productno)){
			CUI_Modal2 c2=(CUI_Modal2) corders.getqtyAndprice(customerno,getOrderNo(), productno);
			int total=c2.getQty()+qty2;
			Double total_price2=total*c2.getSin_price();
			String sql="update cordercar set qty='"+total+"',total_price='"+total_price2+"' where customerno=? and orderno=? and productno=?";
			corders.updateCustomer(sql, customerno,getOrderNo(),productno);
		}
		else{
		corders.addOrder(disdate.get_curDate(),getOrderNo(),productno,productname,qty2,sin_price2,total_price,customerno);
		}
		
	}	
	

	
	//�ύ���ﳵ��Ķ�������������Ϣ��ӵ���������Ͷ�����ϸ��
	public void UpLoadOrder(String customerno,List<cHistoryOrder> l){
		//��������Ͷ�����ϸ�����ݷ�����
		oms=new OrderMasterService();
		os=new OdService();
		//��ʱ�����Ϣ�ļ��ϣ�����ͬ�Ķ����Ŵ�ţ�
		List<cHistoryOrder> l2=new ArrayList<cHistoryOrder>();
		//ĳ�������ŵ������ѽ��
		Double Total_price=0.0;
		//ĳ�������ŵ�ĳ����Ʒ�������ܶ�
		Double total_price2=0.0;
		
		int i=0;
		int qty2 = 0;
		float sin_price2 = 0;
		cHistoryOrder flag=l.get(0);
		String orderno=flag.getOrderNo();
		for(i=0;i<l.size();i++){
			
			if(orderno.equals(l.get(i).getOrderNo())){
				cHistoryOrder cho=new cHistoryOrder();
				
				cho=l.get(i);
				l2.add(cho);
				//������������ת��
				 qty2=DataClassChange.SchangeToInt(cho.getQty());
				 sin_price2=DataClassChange.SchangeToFloat((cho.getSin_price()));
				 total_price2=DataClassChange.SchangeToDouble(cho.getTotal_price());
				Total_price+=total_price2;

			
			}
			else {
				//��������ӵ���������
				oms.addOrderMaster(orderno,customerno,null,disdate.get_curDate(),Total_price,null);
				//��ӵ�������ϸ��
				for(int x=0;x<l2.size();x++){
					cHistoryOrder cho=new cHistoryOrder();
					
					cho=l2.get(x);
					qty2=DataClassChange.SchangeToInt(cho.getQty());
					 sin_price2=DataClassChange.SchangeToFloat((cho.getSin_price()));
					os.addod(cho.getOrderNo(),cho.getProductNo(),qty2,sin_price2);
				}
				l2.clear();
				flag=l.get(i);
				orderno=flag.getOrderNo();
				i--;
				
				//���ܶ��ִ�����Ϊ��һ����Ʒ�Ľ��Դ��Ŀ�ʼ������һ�������������ܶ�
			
				Total_price=0.0;
			
			
			}
			
			
		}
		
			//��������ӵ���������
			oms.addOrderMaster(orderno,customerno,null,disdate.get_curDate(),Total_price,null);
			//��ӵ�������ϸ��
			for(int x=0;x<l2.size();x++){
				cHistoryOrder cho=new cHistoryOrder();
				cho=l2.get(x);
				qty2=DataClassChange.SchangeToInt(cho.getQty());
				 sin_price2=DataClassChange.SchangeToFloat((cho.getSin_price()));
				os.addod(cho.getOrderNo(),cho.getProductNo(),qty2,sin_price2);
			}
	}
	//���տͻ�����ոÿͻ����ﳵ�����Ʒ
	public void deleteOrderByno(String customerno){
		corders.deleteOrderByNo(customerno);
	}
	
	//�õ�ȫ��Ա���Ž�������ַ�������
	public String[] getAllEmployeeNo() throws IOException, ClassNotFoundException, SQLException{
		es=new EmployeeService();
		return es.getAllEmployeeNo();
	}
	//�����ﳵ����Ķ�����ӵ�δ����Ķ�������
	public void addToNoDoOrder(String employeeno,List<cHistoryOrder> l){
		//�½�һ�����ݷ�����
		nds=new NoDoOrderService();
		
		for(int i=0;i<l.size();i++){
			cHistoryOrder c=new cHistoryOrder();
			c=l.get(i);
			int qty=DataClassChange.SchangeToInt(c.getQty());
			Double sin_price=DataClassChange.SchangeToDouble(c.getSin_price());
			Double total_price=DataClassChange.SchangeToDouble(c.getTotal_price());
			nds.addOrder(disdate.get_curDate(),c.getOrderNo(),c.getProductNo(),c.getProductName(),qty,sin_price,total_price,employeeno);
		}
	}

}
