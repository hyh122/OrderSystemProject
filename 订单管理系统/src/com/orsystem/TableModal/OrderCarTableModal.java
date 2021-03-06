package com.orsystem.TableModal;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.orsystem.DataTable.Customer;
import com.orsystem.Modal.OrderCarModal;
import com.orsystem.Modal.cHistoryOrder;

public class OrderCarTableModal implements TableModel{
	private List<cHistoryOrder> ocList; //要显示的UserInfo对象列表
    //创建模型对象时，必须传入要显示的UserInfo对象列表
	  public OrderCarTableModal(List<cHistoryOrder> ocList){
		   this.ocList=ocList;
	  }
	//得到行数:列表中有几个employee对象，就显示几行
	 public int getRowCount(){
		 return ocList.size();
	 }
	 //得到列数,UserInfo对象的每个属性是一列，id,name,age,共3列
	 public int getColumnCount(){
		 
		 return 7;
	 }
	 //指定某列的类型:暂时都是字符串类型，
	 public Class<?> getColumnClass(int columnIndex){
		 return String.class;
	 }
	 //得到指定单元格的值:第几行，就是列表中的第几个employee对象
	 public Object getValueAt(int rowIndex, int columnIndex){
		// 第几行，就是列表中的第几个employee对象
		 cHistoryOrder cho=ocList.get(rowIndex);
      if(columnIndex==0){//第一列是employee对象的员工号
      	return cho.getOrderdate();
      }else if(columnIndex==1){//第二列是employee对象的姓名
      	return cho.getOrderNo();
      }else if(columnIndex==2){
      	return cho.getProductNo();
      }else if(columnIndex==3){
      	return cho.getProductName();
      }else if(columnIndex==4){
      	return cho.getQty();
      }else if(columnIndex==5){
      	return cho.getSin_price();
      }else if(columnIndex==6){
      	return cho.getTotal_price();
      }
      
      else{//除非设计时逻辑错误，否则不会到这里
      	return "";
      }
   }
	 //界面数据有变化时，模型对象的这个方法会被调用，暂时弹出说明框
public void setValueAt(Object aValue, int rowIndex, int columnIndex){
	 
//String info=rowIndex+"行"+columnIndex+"列的值改变: "+aValue.toString();
//	 javax.swing.JOptionPane.showMessageDialog(null,info);
}
	 //指定某单元格是否可编辑:第一列不可编缉，第一列是ID，是每个对象的唯一识别号
	 public boolean isCellEditable(int rowIndex, int columnIndex){
		 if(columnIndex!=0){
		 return true;
		 }
		 return false;
	 }
	 //取每一列的列名
	 public String getColumnName(int columnIndex){
		 if(columnIndex==0){//第一列是UserInfo对象的id值
	        	return "日期";
	        }else if(columnIndex==1){//第二列是name属性值
	        	return "订单号";
	        }else if(columnIndex==2){
	        	return "商品号";
	        }else if(columnIndex==3){
	        return "商品名";
	        }
	        else if(columnIndex==4){
	        	return "数量";
	        }else if(columnIndex==5){
	        	return "单价";
	        }else if(columnIndex==6){
	        	return "总价";
	        }
	       
	        else{//除非设计时逻辑错误，否则不会到这里
	        return "出错!";
	        }
	 }
	 //添加和移除监听器的方法暂不用，写为空的
	 public void addTableModelListener(TableModelListener l){}
public void removeTableModelListener(TableModelListener l){}
}
