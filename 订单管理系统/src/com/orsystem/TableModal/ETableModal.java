package com.orsystem.TableModal;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.orsystem.modal.Employee;

/**
 * 用以在JTable中显示Employee对象的TableModel实现类
 * @author: 蓝杰
 */
public class ETableModal implements TableModel{
		private List<Employee> eList; //要显示的UserInfo对象列表
      //创建模型对象时，必须传入要显示的UserInfo对象列表
	  public ETableModal(List<Employee> eList){
		   this.eList=eList;
	  }
	//得到行数:列表中有几个employee对象，就显示几行
	 public int getRowCount(){
		 return eList.size();
	 }
	 //得到列数,UserInfo对象的每个属性是一列，id,name,age,共3列
	 public int getColumnCount(){
		 return 10;
	 }
	 //指定某列的类型:暂时都是字符串类型，
	 public Class<?> getColumnClass(int columnIndex){
		 return String.class;
	 }
	 //得到指定单元格的值:第几行，就是列表中的第几个employee对象
	 public Object getValueAt(int rowIndex, int columnIndex){
		// 第几行，就是列表中的第几个employee对象
           Employee employee=eList.get(rowIndex);
        if(columnIndex==0){//第一列是employee对象的员工号
        	return employee.getEmployeeNo();
        }else if(columnIndex==1){//第二列是employee对象的姓名
        	return employee.getEmployeeName();
        }else if(columnIndex==2){
        	return employee.getSex();
        }else if(columnIndex==3){
        	return employee.getBirthday();
        }else if(columnIndex==4){
        	return employee.getAddress();
        }
        else if(columnIndex==5){
            return employee.getTelephone();
        }else if(columnIndex==6){
           return employee.getHireday();
        }
        else if(columnIndex==7){
        	return employee.getDepartment();
        }else if(columnIndex==8){
        	return employee.getHeadship();
        }
        else if(columnIndex==9){
        	return employee.getSalary();
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
	        	return "员工号";
	        }else if(columnIndex==1){//第二列是name属性值
	        	return "员工名";
	        }else if(columnIndex==2){
	        	return "性别";
	        }else if(columnIndex==3){
	        return "出生日期";
	        }
	        else if(columnIndex==4){
	        	return "地址";
	        }else if(columnIndex==5){
	        	return "电话号码";
	        }else if(columnIndex==6){
	        return "雇佣日期";
	        }
	        else if(columnIndex==7){
	        	return "部门";
	        }else if(columnIndex==8){
	        	return "职务";
	        }
	        else if(columnIndex==9){
	        return "薪水";
	        }
	        else{//除非设计时逻辑错误，否则不会到这里
	        return "出错!";
	        }
	 }
	 //添加和移除监听器的方法暂不用，写为空的
	 public void addTableModelListener(TableModelListener l){}
public void removeTableModelListener(TableModelListener l){}
}