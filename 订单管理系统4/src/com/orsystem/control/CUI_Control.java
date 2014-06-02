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
	//购物车存放订单的数据服务类
	private COrderCarService corders;

	public CUI_Control() {
		cos=new CreateOrderService();
		disdate=new dis_Date();
		corders=new COrderCarService();
	}
	
	//生成订单号的方法
	//****生成订单的格式前7位为日期，后三位为订单顺序号，比如20140602001,20140602002....到20140602999
	public void createOrderNo() throws IOException, ClassNotFoundException, SQLException{
		if(cos.isExistData(disdate.get_curDate())){
			createOrderNo co=new createOrderNo();
			co=cos.getOrderNoByDate2(disdate.get_curDate());
			//标记为一天中第几次下的订单
			int time=co.getXxtimes()+1;
			//取出当前订单号
			String orderno=co.getOrderno();
			//将当前订单号分割成两部分，前一部分是日期，后一部分是订单顺序号
			String orderno1=orderno.substring(0, 8);
			int num=Integer.parseInt(orderno.substring(9, 11));
			//订单顺序号加1
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
			//更新到最新订单号名称
			String sql="update createorderno set xxtimes=?,orderno=?";
			cos.updateOrderNoName(sql,time,orderno2);
		}else{
			//生成第一条订单号
			String orderno=disdate.get_curDate2()+"001";
			cos.addOrderNoName(disdate.get_curDate(),1,orderno);
		}
	
		
	}
	
	//获得订单号
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
	
	//往购物车添加订单的方法
	public void addOrder(String productno,String productname,String qty,String sin_price) throws IOException, ClassNotFoundException, SQLException{
		//将传进来的qty转换为int型
		int qty2=DataClassChange.SchangeToInt(qty);
		Double sin_price2=DataClassChange.SchangeToDouble(sin_price);
		Double total_price=qty2*sin_price2;
		//添加到数据库中
		///***************这里还要做一个判断，如果第二次添加的跟第一次添加的商品一样，订单号也一样，则取出之前的记录然后叠加后更新
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
