package com.orsystem.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

import com.orsystem.DataService.ProductService;
import com.orsystem.DataTable.Product;
import com.orsystem.Modal.cHistoryOrder;
import com.orsystem.TableModal.ChoTableModal;
import com.orsystem.TableModal.ETableModal;
import com.orsystem.TableModal.PTableModal;
import com.orsystem.control.dis_Date;
import com.orsystem.control.dis_historyOrder;

import javax.swing.JTextField;
import java.awt.GridLayout;

public class CUI_hmsg extends JFrame {

	//���������Panel
	private JPanel MainPanel;
	
	
	//��ʾ�ͻ���ʷ�����ı��
	private JTable choTable;
	//���Modal
	private ChoTableModal choTableModal;
	//��ʾ�ͻ���ʷ�����ķ���
	private dis_historyOrder dis_ho;
	//�����ʷ������modal����
	private List<cHistoryOrder> choList;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
	new CUI_hmsg("c2006002");
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	//������һ���˺ţ����˺�Ϊ��¼���˺�
	public CUI_hmsg(final String CustomerNo) throws IOException, ClassNotFoundException, SQLException {
		getContentPane().setBackground(new Color(204, 255, 255));
		
	
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		//�½���������Panel
		MainPanel=new JPanel();
		MainPanel.setBackground(new Color(102, 255, 255));
		//��ӵ�JFrame
		getContentPane().add(MainPanel);
		//���ò��ָ�ʽ
		MainPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_C = new JPanel();
		MainPanel.add(JP_C, BorderLayout.CENTER);
		
		////�в��ֲ�Ƕ�׵ı�������
		JPanel JP_C1 = new JPanel();
		JP_C1.setBackground(new Color(204, 255, 255));
	
		JLabel LB_productlist = new JLabel("\u6211\u7684\u5386\u53F2\u8BA2\u5355\u5217\u8868");
		LB_productlist.setFont(new Font("����", Font.PLAIN, 25));
		JP_C1.add(LB_productlist);
		

		//�в�����Ƕ�׵��ϲ�����
		JPanel JP_C3 = new JPanel();
		JP_C3.setBackground(new Color(204, 255, 255));
		

		dis_ho=new dis_historyOrder();
		choList=dis_ho.getHisOrderBycNo(CustomerNo);
		//�������Modal
		choTableModal=new ChoTableModal(choList);
		//�������
		choTable=new JTable();
		//���ñ��Modal
		choTable.setModel(choTableModal);
		//���õ�һ�еĿ��
		choTable.getColumnModel().getColumn(0).setPreferredWidth(100); 
		choTable.getColumnModel().getColumn(1).setPreferredWidth(120); 
		choTable.getColumnModel().getColumn(2).setPreferredWidth(120); 
		choTable.getColumnModel().getColumn(3).setPreferredWidth(120);
		choTable.getColumnModel().getColumn(4).setPreferredWidth(120); 
	    //����ÿһ�еĸ߶�
		choTable.setRowHeight(22);
		//��ӱ��ScrollPane��
		JScrollPane scrollPane1 = new JScrollPane(choTable);
		scrollPane1.setPreferredSize(new Dimension(650, 200));
		JP_C3.add(scrollPane1);
		JP_C.setLayout(new BorderLayout(0, 0));
		JP_C.add(JP_C1,BorderLayout.NORTH);
		JP_C.add(JP_C3,BorderLayout.SOUTH);
		
		JPanel JP_C2 = new JPanel();
		JP_C.add(JP_C2, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("\u65E5\u671F");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btn_query = new JButton("\u67E5\u8BE2");
		btn_query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					choList=dis_ho.getHisOrderBycDate(CustomerNo, "%"+textField.getText().toString()+"%");
					//�������Modal
					choTableModal=new ChoTableModal(choList);
					//���ñ��Modal
					choTable.setModel(choTableModal);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		btn_query.setFont(new Font("����", Font.PLAIN, 15));
		
		JButton btnNewButton_1 = new JButton("\u6570\u636E\u7EDF\u8BA1");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DataCountUI(CustomerNo);
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 15));
		
		JButton btnNewButton = new JButton("\u5168\u90E8");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					choList=dis_ho.getHisOrderBycNo(CustomerNo);
					//�������Modal
					choTableModal=new ChoTableModal(choList);
					//���ñ��Modal
					choTable.setModel(choTableModal);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 15));
		GroupLayout gl_JP_C2 = new GroupLayout(JP_C2);
		gl_JP_C2.setHorizontalGroup(
			gl_JP_C2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_JP_C2.createSequentialGroup()
					.addGap(39)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btn_query)
					.addGap(138)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addGap(20))
		);
		gl_JP_C2.setVerticalGroup(
			gl_JP_C2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_JP_C2.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_JP_C2.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_query)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		JP_C2.setLayout(gl_JP_C2);
	
		
		
	
		this.setSize(695, 336);
		
		this.setVisible(true);
		
		this.setResizable(false);
	}
}
