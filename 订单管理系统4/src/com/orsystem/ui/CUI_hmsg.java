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
	public CUI_hmsg(String CustomerNo) throws IOException, ClassNotFoundException, SQLException {
		
	
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		//�½���������Panel
		MainPanel=new JPanel();
		//��ӵ�JFrame
		getContentPane().add(MainPanel);
		//���ò��ָ�ʽ
		MainPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_C = new JPanel();
		MainPanel.add(JP_C, BorderLayout.CENTER);
		
		////�в��ֲ�Ƕ�׵ı�������
		JPanel JP_C1 = new JPanel();
	
		JLabel LB_productlist = new JLabel("\u6211\u7684\u5386\u53F2\u8BA2\u5355\u5217\u8868");
		LB_productlist.setFont(new Font("����", Font.PLAIN, 25));
		JP_C1.add(LB_productlist);
		

		//�в�����Ƕ�׵��ϲ�����
		JPanel JP_C3 = new JPanel();
		

		dis_ho=new dis_historyOrder();
		choList=dis_ho.getHisOrderBycName(CustomerNo);
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
	
		
		
	
		this.setSize(695, 307);
		
		this.setVisible(true);
		
		this.setResizable(false);
	}
	
	 
}
