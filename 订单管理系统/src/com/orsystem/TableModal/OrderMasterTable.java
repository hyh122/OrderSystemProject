package com.orsystem.TableModal;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.orsystem.DataTable.Customer;
import com.orsystem.DataTable.OrderMaster;


public class OrderMasterTable implements TableModel{
	/**
	 * 要显示的UserInfo对象列表
	 */
	private List<OrderMaster> omList; 

  /**
   * 创建模型对象时，必须传入要显示的OrderMaster对象列表
   * @param cList
   */
  public OrderMasterTable(List<OrderMaster> omList){
	   this.omList = omList;
  }
/**
 * 得到行数:列表中有几个OrderMaster对象，就显示几行
 */
 public int getRowCount(){
	 return omList.size();
 }
 /**
  * 得到列数,OrderMaster对象的每个属性是一列，id,name,age,共3列
  */
 public int getColumnCount(){
	 return 6;
 }
 /**
  * 指定某列的类型:暂时都是字符串类型，
  */
 public Class<?> getColumnClass(int columnIndex){
	 return String.class;
 }
 /**
  * 得到指定单元格的值:第几行，就是列表中的第几个OrderMaster对象
  */
 public Object getValueAt(int rowIndex, int columnIndex){
	// 第几行，就是列表中的第几个employee对象
       OrderMaster om =omList.get(rowIndex);
    if(columnIndex == 0){//第一列是OrderMaster对象的员工号
    	return om.getOrderNo();
    }else if(columnIndex == 1){//第二列是rowIndex对象的姓名
    	return om.getCustomerNo();
    }else if(columnIndex == 2){
    	return om.getSaleNo();
    }else if(columnIndex==3){
    //TODO 字符串类型的时间数据怎样转换成date类型？
    	//return om.getOrderDate();
    	return String.valueOf(om.getOrderDate());
    }else if(columnIndex==4){
    	return String.valueOf(om.getOrderSum());
    }else if(columnIndex==5){
    	return om.getInvoiceNO();
    }
    
    
    else{//除非设计时逻辑错误，否则不会到这里
    	return "";
    }
 }
 /**
  * 界面数据有变化时，模型对象的这个方法会被调用，暂时弹出说明框
  */
public void setValueAt(Object aValue, int rowIndex, int columnIndex){
 
//String info=rowIndex+"行"+columnIndex+"列的值改变: "+aValue.toString();
// javax.swing.JOptionPane.showMessageDialog(null,info);
}
 /**
  * 指定某单元格是否可编辑:第一列不可编缉，第一列是ID，是每个对象的唯一识别号
  */
 public boolean isCellEditable(int rowIndex, int columnIndex){
	 if(columnIndex!=0){
	 return true;
	 }
	 return false;
 }
 /**
  * 取每一列的列名
  */
 public String getColumnName(int columnIndex){
	 if(columnIndex==0){//第一列是UserInfo对象的id值
        	return "订单号";
        }else if(columnIndex==1){//第二列是name属性值
        	return "客户ID";
        }else if(columnIndex==2){
        	return "售货员ID";
        }else if(columnIndex==3){
        return "订单日期";
        }else if(columnIndex==4){
        return "订单总额";
        }else if(columnIndex==5){
        	return "发票号码";
        }else{//除非设计时逻辑错误，否则不会到这里
        return "出错!";
        }
 }
 //添加和移除监听器的方法暂不用，写为空的
 public void addTableModelListener(TableModelListener l){}
public void removeTableModelListener(TableModelListener l){}
}