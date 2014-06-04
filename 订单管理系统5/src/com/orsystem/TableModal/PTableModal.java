package com.orsystem.TableModal;

import java.util.List;

import javax.swing.event.TableModelListener;

import javax.swing.table.TableModel;

import com.orsystem.DataTable.Product;

public class PTableModal implements TableModel{
	private List<Product> pList; //Ҫ��ʾ��UserInfo�����б�
    //����ģ�Ͷ���ʱ�����봫��Ҫ��ʾ��UserInfo�����б�
	  public PTableModal(List<Product> pList){
		   this.pList=pList;
	  }
	//�õ�����:�б����м���employee���󣬾���ʾ����
	 public int getRowCount(){
		 return pList.size();
	 }
	 //�õ�����,UserInfo�����ÿ��������һ�У�id,name,age,��3��
	 public int getColumnCount(){
		 return 4;
	 }
	 //ָ��ĳ�е�����:��ʱ�����ַ������ͣ�
	 public Class<?> getColumnClass(int columnIndex){
		 return String.class;
	 }
	 //�õ�ָ����Ԫ���ֵ:�ڼ��У������б��еĵڼ���employee����
	 public Object getValueAt(int rowIndex, int columnIndex){
		// �ڼ��У������б��еĵڼ���employee����
         Product product=pList.get(rowIndex);
      if(columnIndex==0){//��һ����employee�����Ա����
      	return product.getProductNo();
      }else if(columnIndex==1){//�ڶ�����employee���������
      	return product.getProductName();
      }else if(columnIndex==2){
      	return product.getProductClass();
      }else if(columnIndex==3){
      	return product.getProductPrice();
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
	        	return "��Ʒ��";
	        }else if(columnIndex==1){//�ڶ�����name����ֵ
	        	return "��Ʒ��";
	        }else if(columnIndex==2){
	        	return "��Ʒ����";
	        }else if(columnIndex==3){
	        return "��Ʒ�۸�";
	        }
	       
	       
	        else{//�������ʱ�߼����󣬷��򲻻ᵽ����
	        return "����!";
	        }
	 }
	 //��Ӻ��Ƴ��������ķ����ݲ��ã�дΪ�յ�
	 public void addTableModelListener(TableModelListener l){}
public void removeTableModelListener(TableModelListener l){}
}
