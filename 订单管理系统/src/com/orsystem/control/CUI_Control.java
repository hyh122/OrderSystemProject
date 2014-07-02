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
	//购物车存放订单的数据服务类
	private COrderCarService corders;
	//订单主表的数据服务类
	private OrderMasterService oms;
	//订单明细表数据服务类
	private OdService os;
	public CUI_Control() {
		cos=new CreateOrderService();
		disdate=new dis_Date();
		corders=new COrderCarService();
		
	}
	
	//生成订单号的方法
	//****生成订单的格式前7位为日期，后三位为订单顺序号，比如20140602001,20140602002....到20140602999
	public String createOrderNo() throws IOException, ClassNotFoundException, SQLException{
		String orderno;
		if(cos.isExistData(disdate.get_curDate())){
			createOrderNo co=new createOrderNo();
			co=cos.getOrderNoByDate2(disdate.get_curDate());
			//标记为一天中第几次下的订单
			int time=co.getXxtimes()+1;
			//取出当前订单号
			String orderno2=co.getOrderno();
			//将当前订单号分割成两部分，前一部分是日期，后一部分是订单顺序号
			String orderno1=orderno2.substring(0, 8);
			int num=Integer.parseInt(orderno2.substring(9, 12));
			//订单顺序号加1
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
			//更新到最新订单号名称
			String sql="update createorderno set xxtimes=?,orderno=? where orderdate=?";
			cos.updateOrderNoName(sql,time,orderno,disdate.get_curDate());
		}else{
			//生成第一条订单号
			 orderno=disdate.get_curDate2()+"0001";
			cos.addOrderNoName(disdate.get_curDate(),1,orderno);
		}
	return orderno;
		
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
	public void addOrder(String customerno,String orderno,String productno,String productname,String qty,String sin_price) throws IOException, ClassNotFoundException, SQLException{
		//将传进来的qty转换为int型
		int qty2=DataClassChange.SchangeToInt(qty);
		Double sin_price2=DataClassChange.SchangeToDouble(sin_price);
		Double total_price=qty2*sin_price2;
		//添加到数据库中
		///***************这里还要做一个判断，如果第二次添加的跟第一次添加的商品一样，订单号也一样，则取出之前的记录然后叠加后更新
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
	

	
	//提交购物车里的订单，将订单信息添加到订单主表和订单明细表
	public void UpLoadOrder(String customerno,List<cHistoryOrder> l){
		//订单主表和订单明细的数据服务类
		oms=new OrderMasterService();
		os=new OdService();
		//暂时存放信息的集合（按不同的订单号存放）
		List<cHistoryOrder> l2=new ArrayList<cHistoryOrder>();
		//某个订单号的总消费金额
		Double Total_price=0.0;
		//某个订单号的某个商品的消费总额
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
				//进行数据类型转换
				 qty2=DataClassChange.SchangeToInt(cho.getQty());
				 sin_price2=DataClassChange.SchangeToFloat((cho.getSin_price()));
				 total_price2=DataClassChange.SchangeToDouble(cho.getTotal_price());
				Total_price+=total_price2;

			
			}
			else {
				//将订单添加到订单主表
				oms.addOrderMaster(orderno,customerno,null,disdate.get_curDate(),Total_price,null);
				//添加到订单明细表
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
				
				//将总额又从新设为第一件商品的金额，以从心开始计算下一个订单的消费总额
			
				Total_price=0.0;
			
			
			}
			
			
		}
		
			//将订单添加到订单主表
			oms.addOrderMaster(orderno,customerno,null,disdate.get_curDate(),Total_price,null);
			//添加到订单明细表
			for(int x=0;x<l2.size();x++){
				cHistoryOrder cho=new cHistoryOrder();
				cho=l2.get(x);
				qty2=DataClassChange.SchangeToInt(cho.getQty());
				 sin_price2=DataClassChange.SchangeToFloat((cho.getSin_price()));
				os.addod(cho.getOrderNo(),cho.getProductNo(),qty2,sin_price2);
			}
	}
	//按照客户名清空该客户购物车里的商品
	public void deleteOrderByno(String customerno){
		corders.deleteOrderByNo(customerno);
	}
	
	//得到全体员工号结果返回字符串数组
	public String[] getAllEmployeeNo() throws IOException, ClassNotFoundException, SQLException{
		es=new EmployeeService();
		return es.getAllEmployeeNo();
	}
	//将购物车里面的订单添加到未处理的订单表中
	public void addToNoDoOrder(String employeeno,List<cHistoryOrder> l){
		//新建一个数据服务类
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
