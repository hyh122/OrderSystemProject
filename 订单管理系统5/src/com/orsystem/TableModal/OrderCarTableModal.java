package com.orsystem.TableModal;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.orsystem.DataTable.Customer;
import com.orsystem.Modal.OrderCarModal;
import com.orsystem.Modal.cHistoryOrder;

public class OrderCarTableModal implements TableModel{
	private List<cHistoryOrder> ocList; //Ҫ��ʾ��UserInfo�����б�
    //����ģ�Ͷ���ʱ�����봫��Ҫ��ʾ��UserInfo�����б�
	  public OrderCarTableModal(List<cHistoryOrder> ocList){
		   this.ocList=ocList;
	  }
	//�õ�����:�б����м���employee���󣬾���ʾ����
	 public int getRowCount(){
		 return ocList.size();
	 }
	 //�õ�����,UserInfo�����ÿ��������һ�У�id,name,age,��3��
	 public int getColumnCount(){
		 
		 return 7;
	 }
	 //ָ��ĳ�е�����:��ʱ�����ַ������ͣ�
	 public Class<?> getColumnClass(int columnIndex){
		 return String.class;
	 }
	 //�õ�ָ����Ԫ���ֵ:�ڼ��У������б��еĵڼ���employee����
	 public Object getValueAt(int rowIndex, int columnIndex){
		// �ڼ��У������б��еĵڼ���employee����
		 cHistoryOrder cho=ocList.get(rowIndex);
      if(columnIndex==0){//��һ����employee�����Ա����
      	return cho.getOrderdate();
      }else if(columnIndex==1){//�ڶ�����employee���������
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
	        	return "����";
	        }else if(columnIndex==1){//�ڶ�����name����ֵ
	        	return "������";
	        }else if(columnIndex==2){
	        	return "��Ʒ��";
	        }else if(columnIndex==3){
	        return "��Ʒ��";
	        }
	        else if(columnIndex==4){
	        	return "����";
	        }else if(columnIndex==5){
	        	return "����";
	        }else if(columnIndex==6){
	        	return "�ܼ�";
	        }
	       
	        else{//�������ʱ�߼����󣬷��򲻻ᵽ����
	        return "����!";
	        }
	 }
	 //��Ӻ��Ƴ��������ķ����ݲ��ã�дΪ�յ�
	 public void addTableModelListener(TableModelListener l){}
public void removeTableModelListener(TableModelListener l){}
}
