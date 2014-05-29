package com.orsystem.TableModal;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.orsystem.modal.Employee;

/**
 * ������JTable����ʾEmployee�����TableModelʵ����
 * @author: ����
 */
public class ETableModal implements TableModel{
		private List<Employee> eList; //Ҫ��ʾ��UserInfo�����б�
      //����ģ�Ͷ���ʱ�����봫��Ҫ��ʾ��UserInfo�����б�
	  public ETableModal(List<Employee> eList){
		   this.eList=eList;
	  }
	//�õ�����:�б����м���employee���󣬾���ʾ����
	 public int getRowCount(){
		 return eList.size();
	 }
	 //�õ�����,UserInfo�����ÿ��������һ�У�id,name,age,��3��
	 public int getColumnCount(){
		 return 10;
	 }
	 //ָ��ĳ�е�����:��ʱ�����ַ������ͣ�
	 public Class<?> getColumnClass(int columnIndex){
		 return String.class;
	 }
	 //�õ�ָ����Ԫ���ֵ:�ڼ��У������б��еĵڼ���employee����
	 public Object getValueAt(int rowIndex, int columnIndex){
		// �ڼ��У������б��еĵڼ���employee����
           Employee employee=eList.get(rowIndex);
        if(columnIndex==0){//��һ����employee�����Ա����
        	return employee.getEmployeeNo();
        }else if(columnIndex==1){//�ڶ�����employee���������
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
        else{//�������ʱ�߼����󣬷��򲻻ᵽ����
        	return "";
        }
     }
	 //���������б仯ʱ��ģ�Ͷ������������ᱻ���ã���ʱ����˵����
 public void setValueAt(Object aValue, int rowIndex, int columnIndex){
	 
//String info=rowIndex+"��"+columnIndex+"�е�ֵ�ı�: "+aValue.toString();
//	 javax.swing.JOptionPane.showMessageDialog(null,info);
 }
	 //ָ��ĳ��Ԫ���Ƿ�ɱ༭:��һ�в��ɱ༩����һ����ID����ÿ�������Ψһʶ���
	 public boolean isCellEditable(int rowIndex, int columnIndex){
		 if(columnIndex!=0){
		 return true;
		 }
		 return false;
	 }
	 //ȡÿһ�е�����
	 public String getColumnName(int columnIndex){
		 if(columnIndex==0){//��һ����UserInfo�����idֵ
	        	return "Ա����";
	        }else if(columnIndex==1){//�ڶ�����name����ֵ
	        	return "Ա����";
	        }else if(columnIndex==2){
	        	return "�Ա�";
	        }else if(columnIndex==3){
	        return "��������";
	        }
	        else if(columnIndex==4){
	        	return "��ַ";
	        }else if(columnIndex==5){
	        	return "�绰����";
	        }else if(columnIndex==6){
	        return "��Ӷ����";
	        }
	        else if(columnIndex==7){
	        	return "����";
	        }else if(columnIndex==8){
	        	return "ְ��";
	        }
	        else if(columnIndex==9){
	        return "нˮ";
	        }
	        else{//�������ʱ�߼����󣬷��򲻻ᵽ����
	        return "����!";
	        }
	 }
	 //��Ӻ��Ƴ��������ķ����ݲ��ã�дΪ�յ�
	 public void addTableModelListener(TableModelListener l){}
public void removeTableModelListener(TableModelListener l){}
}