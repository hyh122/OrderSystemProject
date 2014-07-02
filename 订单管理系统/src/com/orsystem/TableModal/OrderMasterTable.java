package com.orsystem.TableModal;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.orsystem.DataTable.Customer;
import com.orsystem.DataTable.OrderMaster;


public class OrderMasterTable implements TableModel{
	/**
	 * Ҫ��ʾ��UserInfo�����б�
	 */
	private List<OrderMaster> omList; 

  /**
   * ����ģ�Ͷ���ʱ�����봫��Ҫ��ʾ��OrderMaster�����б�
   * @param cList
   */
  public OrderMasterTable(List<OrderMaster> omList){
	   this.omList = omList;
  }
/**
 * �õ�����:�б����м���OrderMaster���󣬾���ʾ����
 */
 public int getRowCount(){
	 return omList.size();
 }
 /**
  * �õ�����,OrderMaster�����ÿ��������һ�У�id,name,age,��3��
  */
 public int getColumnCount(){
	 return 6;
 }
 /**
  * ָ��ĳ�е�����:��ʱ�����ַ������ͣ�
  */
 public Class<?> getColumnClass(int columnIndex){
	 return String.class;
 }
 /**
  * �õ�ָ����Ԫ���ֵ:�ڼ��У������б��еĵڼ���OrderMaster����
  */
 public Object getValueAt(int rowIndex, int columnIndex){
	// �ڼ��У������б��еĵڼ���employee����
       OrderMaster om =omList.get(rowIndex);
    if(columnIndex == 0){//��һ����OrderMaster�����Ա����
    	return om.getOrderNo();
    }else if(columnIndex == 1){//�ڶ�����rowIndex���������
    	return om.getCustomerNo();
    }else if(columnIndex == 2){
    	return om.getSaleNo();
    }else if(columnIndex==3){
    //TODO �ַ������͵�ʱ����������ת����date���ͣ�
    	//return om.getOrderDate();
    	return String.valueOf(om.getOrderDate());
    }else if(columnIndex==4){
    	return String.valueOf(om.getOrderSum());
    }else if(columnIndex==5){
    	return om.getInvoiceNO();
    }
    
    
    else{//�������ʱ�߼����󣬷��򲻻ᵽ����
    	return "";
    }
 }
 /**
  * ���������б仯ʱ��ģ�Ͷ������������ᱻ���ã���ʱ����˵����
  */
public void setValueAt(Object aValue, int rowIndex, int columnIndex){
 
//String info=rowIndex+"��"+columnIndex+"�е�ֵ�ı�: "+aValue.toString();
// javax.swing.JOptionPane.showMessageDialog(null,info);
}
 /**
  * ָ��ĳ��Ԫ���Ƿ�ɱ༭:��һ�в��ɱ༩����һ����ID����ÿ�������Ψһʶ���
  */
 public boolean isCellEditable(int rowIndex, int columnIndex){
	 if(columnIndex!=0){
	 return true;
	 }
	 return false;
 }
 /**
  * ȡÿһ�е�����
  */
 public String getColumnName(int columnIndex){
	 if(columnIndex==0){//��һ����UserInfo�����idֵ
        	return "������";
        }else if(columnIndex==1){//�ڶ�����name����ֵ
        	return "�ͻ�ID";
        }else if(columnIndex==2){
        	return "�ۻ�ԱID";
        }else if(columnIndex==3){
        return "��������";
        }else if(columnIndex==4){
        return "�����ܶ�";
        }else if(columnIndex==5){
        	return "��Ʊ����";
        }else{//�������ʱ�߼����󣬷��򲻻ᵽ����
        return "����!";
        }
 }
 //��Ӻ��Ƴ��������ķ����ݲ��ã�дΪ�յ�
 public void addTableModelListener(TableModelListener l){}
public void removeTableModelListener(TableModelListener l){}
}