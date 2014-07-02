package com.orsystem.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JScrollPane;


import com.orsystem.DataService.COrderCarService;
import com.orsystem.Modal.cHistoryOrder;
import com.orsystem.TableModal.ChoTableModal;
import com.orsystem.TableModal.OrderCarTableModal;
import com.orsystem.control.CUI_Control;
import com.orsystem.control.dis_historyOrder;
import javax.swing.JButton;
import java.awt.Color;

public class CUI_OrderCar extends JFrame implements ActionListener{

	//���������Panel
	private JPanel MainPanel;
	
	//��ʾ�ͻ����ﳵ�����ı��
	private JTable ocTable;
	//���Modal
	private OrderCarTableModal ocTableModal;
	//���ﳵ������
	private COrderCarService ocservice;
	//��Ź��ﳵ������modal����
	private List<cHistoryOrder> choList;
	//��ť
	private JButton btn_buy,btn_delete,btn_refresh;
	//������
	private CUI_Control control;
	//�û���
	private String customerno;
	JComboBox CB_selectEmp;
	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		new CUI_OrderCar("c2005001");
	
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public CUI_OrderCar(String customerno) throws IOException, ClassNotFoundException, SQLException {
		getContentPane().setBackground(new Color(204, 255, 255));
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.customerno=customerno;
		//�½���������Panel
		MainPanel=new JPanel();
		//��ӵ�JFrame
		getContentPane().add(MainPanel);
		//���ò��ָ�ʽ
		MainPanel.setLayout(new BorderLayout(0, 0));
		//��ʼ��������
		control=new CUI_Control();
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		MainPanel.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\u6211\u7684\u8D2D\u7269\u8F66\u5546\u54C1");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 25));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 255, 255));
		MainPanel.add(panel_1, BorderLayout.CENTER);

		ocservice=new COrderCarService();
		choList=ocservice.getAllOrderByNo(customerno);
		//�������Modal
		ocTableModal=new OrderCarTableModal(choList);
		//�������
		ocTable=new JTable();
		//���ñ��Modal
		ocTable.setModel(ocTableModal);
		//��table����һ������¼�����������
		 ocTable.addMouseListener(new java.awt.event.MouseAdapter(){
      	 public void mouseClicked(MouseEvent e) {//������굥��ʱ��Ӧ
      		 //�õ�ѡ�е����е�����ֵ
      		int r= ocTable.getSelectedRow();
      		
      		System.out.println(r);
   			
   		   
      	 }
       });


		//���õ�һ�еĿ��
//		choTable.getColumnModel().getColumn(0).setPreferredWidth(100); 

	    //����ÿһ�еĸ߶�
		ocTable.setRowHeight(22);
		//��ӱ��ScrollPane��
		
		
		JScrollPane scrollPane = new JScrollPane(ocTable);
		scrollPane.setPreferredSize(new Dimension(850, 200));
		panel_1.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 255, 255));
		MainPanel.add(panel_2, BorderLayout.SOUTH);
		
		btn_buy = new JButton("\u8D2D\u4E70");
		btn_buy.setFont(new Font("����", Font.PLAIN, 20));
		//��Ӽ����¼�
		btn_buy.addActionListener(this);
		
		JLabel lblNewLabel_1 = new JLabel("\u9009\u62E9\u5904\u7406\u8BA2\u5355\u7684\u5458\u5DE5");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_1);
		
		 CB_selectEmp = new JComboBox(control.getAllEmployeeNo());
		
		panel_2.add(CB_selectEmp);
		panel_2.add(btn_buy);
		
		 btn_delete = new JButton("��չ��ﳵ");
		btn_delete.setFont(new Font("����", Font.PLAIN, 20));
		panel_2.add(btn_delete);
		btn_delete.addActionListener(this);
		
		 btn_refresh = new JButton("\u5237\u65B0");
		btn_refresh.setFont(new Font("����", Font.PLAIN, 20));
		panel_2.add(btn_refresh);
		btn_refresh.addActionListener(this);
		
		
		this.setSize(919, 361);
		
		this.setVisible(true);
		
		this.setResizable(false);
	}
	///*******��������*************************////////////////////
	//ˢ�¹��ﳵ�б�ķ���(ȫ����Ʒ)
	public void reTable() throws IOException, ClassNotFoundException, SQLException{
		choList=ocservice.getAllOrderByNo(customerno);
		/**���±����Ϣ***/
		//�������Modal
		ocTableModal=new OrderCarTableModal(choList);
		//�������
		ocTable.setModel(ocTableModal);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn_buy){
			if(choList.size()==0){
				JOptionPane.showMessageDialog(this,"���ﳵû����Ʒ,���������Ʒ!!");
			}
			else{
				control.UpLoadOrder(customerno, choList);
				//�����ﳵ��Ķ�����ӵ�������Ķ�������
				control.addToNoDoOrder((String) CB_selectEmp.getSelectedItem(), choList);
				
			//��ո��û��ͻ����������Ʒ
			control.deleteOrderByno(customerno);
			JOptionPane.showMessageDialog(this,"�ύ�����ɹ�!!");
			//ˢ���б�
			try {
//				//�����µĶ���
//				control.createOrderNo();
				reTable();
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			}
		}
		else if(e.getSource()==btn_delete){
			control.deleteOrderByno(customerno);
			try {
				reTable();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==btn_refresh){
		
			try {
				reTable();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
