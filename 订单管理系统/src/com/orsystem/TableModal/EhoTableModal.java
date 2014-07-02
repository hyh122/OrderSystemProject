package com.orsystem.TableModal;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.orsystem.Modal.cHistoryOrder;

///****��ʾԱ����ʷ������TableModal****///////
public class EhoTableModal implements TableModel{
	private List<cHistoryOrder> choList; //Ҫ��ʾ��UserInfo�����б�
    //����ģ�Ͷ���ʱ�����봫��Ҫ��ʾ��UserInfo�����б�
	  public EhoTableModal(List<cHistoryOrder> choList){
		   this.choList=choList;
	  }
	//�õ�����:�б����м���employee���󣬾���ʾ����
	 public int getRowCount(){
		 return choList.size();
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
         cHistoryOrder cho=choList.get(rowIndex);
      if(columnIndex==0){//��һ����employee�����Ա����
      	return cho.getOrderdate();
      }else if(columnIndex==1){//�ڶ�����employee���������
      	return cho.getOrderNo();
      }else if(columnIndex==2){//�ڶ�����employee���������
        	return cho.getProductNo();
       }else if(columnIndex==3){//�ڶ�����employee���������
         	return cho.getProductName();
       }else if(columnIndex==4){//�ڶ�����employee���������
         	return cho.getQty();
       }else if(columnIndex==5){//�ڶ�����employee���������
         	return cho.getSin_price();
       }else if(columnIndex==6){//�ڶ�����employee���������
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
	        }else if(columnIndex==2){//�ڶ�����name����ֵ
	        	return "��Ʒ��";
	        }else if(columnIndex==3){//�ڶ�����name����ֵ
	        	return "��Ʒ��";
	        }else if(columnIndex==4){//�ڶ�����name����ֵ
	        	return "��Ʒ����";
	        }else if(columnIndex==5){//�ڶ�����name����ֵ
	        	return "��Ʒ����";
	        }else if(columnIndex==6){//�ڶ�����name����ֵ
	        	return "��Ʒ�ܼ�";
	        }
	       
	        else{//�������ʱ�߼����󣬷��򲻻ᵽ����
	        return "����!";
	        }
	 }
	 //��Ӻ��Ƴ��������ķ����ݲ��ã�дΪ�յ�
	 public void addTableModelListener(TableModelListener l){}
public void removeTableModelListener(TableModelListener l){}
}
