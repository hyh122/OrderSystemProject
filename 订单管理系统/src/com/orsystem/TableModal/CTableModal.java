package com.orsystem.TableModal;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.orsystem.DataTable.Customer;
import com.orsystem.DataTable.Employee;

/**
 * ������JTable����ʾEmployee�����TableModelʵ����
 * @author: ����
 */
public class CTableModal implements TableModel{
		private List<Customer> cList; //Ҫ��ʾ��UserInfo�����б�
      //����ģ�Ͷ���ʱ�����봫��Ҫ��ʾ��UserInfo�����б�
	  public CTableModal(List<Customer> cList){
		   this.cList=cList;
	  }
	//�õ�����:�б����м���employee���󣬾���ʾ����
	 public int getRowCount(){
		 return cList.size();
	 }
	 //�õ�����,UserInfo�����ÿ��������һ�У�id,name,age,��3��
	 public int getColumnCount(){
		 return 5;
	 }
	 //ָ��ĳ�е�����:��ʱ�����ַ������ͣ�
	 public Class<?> getColumnClass(int columnIndex){
		 return String.class;
	 }
	 //�õ�ָ����Ԫ���ֵ:�ڼ��У������б��еĵڼ���employee����
	 public Object getValueAt(int rowIndex, int columnIndex){
		// �ڼ��У������б��еĵڼ���employee����
           Customer customer=cList.get(rowIndex);
        if(columnIndex==0){//��һ����employee�����Ա����
        	return customer.getCustomerNo();
        }else if(columnIndex==1){//�ڶ�����employee���������
        	return customer.getCustomerName();
        }else if(columnIndex==2){
        	return customer.getAddress();
        }else if(columnIndex==3){
        	return customer.getTelephone();
        }else if(columnIndex==4){
        	return customer.getZip();
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
	        	return "�ͻ���";
	        }else if(columnIndex==1){//�ڶ�����name����ֵ
	        	return "�ͻ���";
	        }else if(columnIndex==2){
	        	return "��ַ";
	        }else if(columnIndex==3){
	        return "�绰";
	        }
	        else if(columnIndex==4){
	        	return "�ʱ�";
	        }
	       
	        else{//�������ʱ�߼����󣬷��򲻻ᵽ����
	        return "����!";
	        }
	 }
	 //��Ӻ��Ƴ��������ķ����ݲ��ã�дΪ�յ�
	 public void addTableModelListener(TableModelListener l){}
public void removeTableModelListener(TableModelListener l){}
}
