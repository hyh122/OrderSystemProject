package com.orsystem.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import com.orsystem.TableModal.ETableModal;
import com.orsystem.TableModal.PTableModal;
import com.orsystem.control.CUI_Control;
import com.orsystem.control.dis_Date;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class CustomerUI extends JFrame implements ItemListener, ActionListener{

	//���������Panel
	private JPanel MainPanel;
	//��Ʒ���ݿ������
	ProductService ps;
	//���ȫ����Ʒ��Ϣ�ļ���
	List<Product> pList;
	//��ʾ��Ʒ��Ϣ�ı��
	private JTable pTable;
	//���Modal
	private PTableModal pTableModal;
	private JTextField JT_pno;
	private JTextField JT_pname;
	private JTextField JT_pclass;
	private JTextField JT_pprice;
	//��ť
	JButton btn_cmsg,btn_hmsg,btn_mycar, btn_changep,btn_exit,btn_addToCar,btn_Topay;
	
	//������
	JComboBox CB_productclass,CB_price,CB_selectnum;
	//��¼���˺�
	private String acount;
	//��ʾ���ڵ���
	dis_Date dis_date;
	//�ͻ������control��
	private CUI_Control ccontrol;
	
	
	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
	new CustomerUI("c2005001");
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	//������һ���˺ţ����˺�Ϊ��¼���˺�
	public CustomerUI(String acount) throws IOException, ClassNotFoundException, SQLException {
		this.setSize(951, 587);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		this.setResizable(false);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.acount=acount;
		//��ʼ��������
		ccontrol=new CUI_Control();
		//�½���������Panel
		MainPanel=new JPanel();
		//��ӵ�JFrame
		getContentPane().add(MainPanel);
		//���ò��ָ�ʽ
		MainPanel.setLayout(new BorderLayout(0, 0));
		
		//*********************�������ֿ�ʼ����***************************//////////////////////
		JPanel JP_N = new JPanel();
		MainPanel.add(JP_N, BorderLayout.PAGE_START);
		JP_N.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		JP_N.add(toolBar);
		toolBar.setBackground(Color.CYAN);
		
		JLabel JL_CustomerNo = new JLabel("\u5BA2\u6237\u53F7\uFF0C");
		JL_CustomerNo.setFont(new Font("����", Font.PLAIN, 20));
		JL_CustomerNo.setText(acount);
		toolBar.add(JL_CustomerNo);
		
		JLabel JL_welcome = new JLabel("\u60A8\u597D\uFF01\u6B22\u8FCE\u767B\u5F55");
		JL_welcome.setFont(new Font("����", Font.PLAIN, 25));
		toolBar.add(JL_welcome);
		///��������Ƕ�׵Ĳ���
		JPanel JP_N1 = new JPanel();
		JP_N1.setBackground(Color.CYAN);
		toolBar.add(JP_N1);
		
		 btn_cmsg = new JButton("\u4E2A\u4EBA\u4FE1\u606F");
		btn_cmsg.setFont(new Font("����", Font.PLAIN, 15));
		//����¼������¼�
		btn_cmsg.addActionListener(this);
		
		 btn_hmsg = new JButton("\u5386\u53F2\u8BA2\u5355");
		btn_hmsg.setFont(new Font("����", Font.PLAIN, 15));
		//��Ӽ����¼�
		btn_hmsg.addActionListener(this);
		
		 btn_mycar = new JButton("\u6211\u7684\u8D2D\u7269\u8F66");
		btn_mycar.setFont(new Font("����", Font.PLAIN, 15));
		
		 btn_changep = new JButton("\u4FEE\u6539\u5BC6\u7801");
		btn_changep.setFont(new Font("����", Font.PLAIN, 15));
		
		 btn_exit = new JButton("\u9000\u51FA");
		btn_exit.setFont(new Font("����", Font.PLAIN, 15));
		
		//��ʾ���ڵ���ǩ
		dis_date=new dis_Date();
		JLabel lb_date = new JLabel("date");
		lb_date.setText(dis_date.get_curDate());
		lb_date.setFont(new Font("����", Font.PLAIN, 15));
		////***********���鲼��************************///////////////////
		GroupLayout gl_JP_N1 = new GroupLayout(JP_N1);
		gl_JP_N1.setHorizontalGroup(
			gl_JP_N1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_JP_N1.createSequentialGroup()
					.addGap(37)
					.addComponent(btn_cmsg)
					.addGap(18)
					.addComponent(btn_hmsg)
					.addGap(18)
					.addComponent(btn_mycar)
					.addGap(43)
					.addComponent(btn_changep)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn_exit)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lb_date)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_JP_N1.setVerticalGroup(
			gl_JP_N1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_JP_N1.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_JP_N1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_exit)
						.addComponent(btn_changep)
						.addComponent(btn_cmsg)
						.addComponent(btn_hmsg)
						.addComponent(btn_mycar)
						.addComponent(lb_date)))
		);
		///*****���鲼�ֽ���**///////////
		JP_N1.setLayout(gl_JP_N1);
		
		//*********�������ֽ�������****////////////////
		
		
		/////************�в����ֿ�ʼ����********************////////////////////////
		JPanel JP_C = new JPanel();
		MainPanel.add(JP_C, BorderLayout.CENTER);
		
		////�в��ֲ�Ƕ�׵ı�������
		JPanel JP_C1 = new JPanel();
	
		JLabel LB_productlist = new JLabel("\u5546\u54C1\u5217\u8868");
		LB_productlist.setFont(new Font("����", Font.PLAIN, 25));
		JP_C1.add(LB_productlist);
		

		//�в�����Ƕ�׵��ϲ�����
		JPanel JP_C3 = new JPanel();
		
		//��ʼ����Ʒ���ݿ������
		ps=new ProductService();
	
		pList=ps.getAllProduct();
		
		//�������Modal
		pTableModal=new PTableModal(pList);
		//�������
		pTable=new JTable();
		//���ñ��Modal
		pTable.setModel(pTableModal);
		
	    //����ÿһ�еĸ߶�
		pTable.setRowHeight(22);
		//��eTable����һ������¼�����������
		 pTable.addMouseListener(new java.awt.event.MouseAdapter(){
     	 public void mouseClicked(MouseEvent ev) {//������굥��ʱ��Ӧ
     		 //�õ�ѡ�е����е�����ֵ
     		int r= pTable.getSelectedRow();
     		Product p=new Product();
     		p=pList.get(r);
     		pDisplay(p.getProductNo(),p.getProductName(),p.getProductClass(),String.valueOf(p.getProductPrice()));

     	 }
      });
		//��ӱ��ScrollPane��
		JScrollPane scrollPane1 = new JScrollPane(pTable);
		scrollPane1.setPreferredSize(new Dimension(800, 200));
		JP_C3.add(scrollPane1);
		JP_C.setLayout(new BorderLayout(0, 0));
		JP_C.add(JP_C1,BorderLayout.NORTH);
		JP_C.add(JP_C3,BorderLayout.SOUTH);
		
		//�в�����Ƕ�׵��в�����
		JPanel JP_C2 = new JPanel();
		JP_C.add(JP_C2, BorderLayout.CENTER);
		
		
		JLabel LB_productclass = new JLabel("\u5546\u54C1\u7C7B\u578B");
		LB_productclass.setFont(new Font("����", Font.PLAIN, 18));
		JP_C2.add(LB_productclass);
		
		//������ѡ����Ʒ���
		CB_productclass = new JComboBox(ps.getAllClassName());
		//��Ӽ����¼�
		CB_productclass.addItemListener(this);
		JP_C2.add(CB_productclass);
		
		JLabel LB_price = new JLabel("\u4EF7\u4F4D");
		LB_price.setFont(new Font("����", Font.PLAIN, 18));
		JP_C2.add(LB_price);
		
		//������ѡ����Ʒ��λ
		CB_price = new JComboBox();
		CB_price.addItem("������");
		CB_price.addItem("<100");
		CB_price.addItem("100-500");
		CB_price.addItem("500-1000");
		CB_price.addItem(">1000");
		//Ϊ��������Ӽ����¼�
		CB_price.addItemListener(this);
		JP_C2.add(CB_price);
		
		//////****************�в����ֽ�������***//****////////////////////////////
		
	
		
		
		//**********************�ϲ����ֿ�ʼ����******************///////////////
		JPanel JP_S = new JPanel();
		MainPanel.add(JP_S, BorderLayout.SOUTH);
		JP_S.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_S1 = new JPanel();
		JP_S.add(JP_S1,BorderLayout.NORTH);
		//�ϲ�����Ƕ�׵��в�����
		JLabel lblNewLabel_5 = new JLabel("\u9009\u4E2D\u7684\u5546\u54C1\u4FE1\u606F");
		lblNewLabel_5.setFont(new Font("����", Font.PLAIN, 25));
		JP_S1.add(lblNewLabel_5);
		
		JPanel JP_S2 = new JPanel();
		JP_S.add(JP_S2, BorderLayout.CENTER);
		
		JPanel panel_9 = new JPanel();
		JP_S2.add(panel_9);
		panel_9.setLayout(new GridLayout(2,4));
		
		JLabel lblNewLabel_7 = new JLabel("\u5546\u54C1\u53F7");
		lblNewLabel_7.setFont(new Font("����", Font.PLAIN, 20));
		panel_9.add(lblNewLabel_7);
		
		JT_pno = new JTextField();
		panel_9.add(JT_pno);
		JT_pno.setColumns(10);
		JT_pno.setEditable(false);
		
		JLabel lblNewLabel_6 = new JLabel("\u5546\u54C1\u540D");
		lblNewLabel_6.setFont(new Font("����", Font.PLAIN, 20));
		panel_9.add(lblNewLabel_6);
		
		JT_pname = new JTextField();
		panel_9.add(JT_pname);
		JT_pname.setColumns(10);
		JT_pname.setEditable(false);
		
		JLabel lblNewLabel_8 = new JLabel("\u5546\u54C1\u7C7B\u578B");
		lblNewLabel_8.setFont(new Font("����", Font.PLAIN, 20));
		panel_9.add(lblNewLabel_8);
		
		JT_pclass = new JTextField();
		panel_9.add(JT_pclass);
		JT_pclass.setColumns(10);
		JT_pclass.setEditable(false);
		
		JLabel lblNewLabel_9 = new JLabel("\u5546\u54C1\u4EF7\u683C");
		lblNewLabel_9.setFont(new Font("����", Font.PLAIN, 20));
		panel_9.add(lblNewLabel_9);
		
		JT_pprice = new JTextField();
		panel_9.add(JT_pprice);
		JT_pprice.setColumns(10);
		JT_pprice.setEditable(false);
		
		//�ϲ�����Ƕ�׵��ϲ�����
		JPanel JP_S3 = new JPanel();
		JP_S.add(JP_S3, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_10 = new JLabel("\u8BF7\u9009\u62E9\u5546\u54C1\u6570\u91CF");
		lblNewLabel_10.setFont(new Font("����", Font.PLAIN, 20));
		String[] num={"1","2","3","4","5"};
		CB_selectnum = new JComboBox(num);
		
		//CB_selectnum.addItem(num);
		
		btn_addToCar = new JButton("\u6DFB\u52A0\u5230\u8D2D\u7269\u8F66");
		btn_addToCar.setFont(new Font("����", Font.PLAIN, 20));
		//���Ӽ����¼�
		btn_addToCar.addActionListener(this);
		
		 btn_Topay = new JButton("\u53BB\u7ED3\u7B97");
		btn_Topay.setFont(new Font("����", Font.PLAIN, 20));
		////******************���鲼�ֲ���*************************/////////////////
		GroupLayout gl_JP_S3 = new GroupLayout(JP_S3);
		gl_JP_S3.setHorizontalGroup(
			gl_JP_S3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_JP_S3.createSequentialGroup()
					.addGroup(gl_JP_S3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_JP_S3.createSequentialGroup()
							.addGap(198)
							.addComponent(lblNewLabel_10)
							.addGap(18)
							.addComponent(CB_selectnum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 274, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_JP_S3.createSequentialGroup()
							.addContainerGap()
							.addComponent(btn_addToCar)
							.addGap(38)))
					.addComponent(btn_Topay)
					.addGap(94))
		);
		gl_JP_S3.setVerticalGroup(
			gl_JP_S3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_JP_S3.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_JP_S3.createParallelGroup(Alignment.LEADING)
						.addComponent(CB_selectnum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_10))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_JP_S3.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_Topay)
						.addComponent(btn_addToCar)))
		);
		//********************���鲼�ֲ���***************************//////////////
		//���ϲ�����Ƕ�׵��ϲ�������Ϊ���鲼��
		JP_S3.setLayout(gl_JP_S3);
		
	}
	
	////*******************��������*************/////////////
	//����JTextField������ʾ��Ʒ��Ϣ�ķ���
	public void pDisplay(String productNo,String productName,String productClass,String productPrice){
		JT_pno.setText(productNo);
		JT_pname.setText(productName);
		JT_pclass.setText(productClass);
		JT_pprice.setText(productPrice);
	
		
	}
	//ˢ����Ʒ�б�ķ���(ȫ����Ʒ)
	public void repTable() throws IOException, ClassNotFoundException, SQLException{
		pList=ps.getAllProduct();
		/**���±����Ϣ***/
		//�������Modal
		pTableModal=new PTableModal(pList);
		//���ñ��Modal
		pTable.setModel(pTableModal);
	}
	//ˢ����Ʒ�б�ķ���(����Ʒ���,��Ʒ��λ)
	public void repcpTable(String productclass,String low_price,String high_price) throws IOException, ClassNotFoundException, SQLException{
		pList=ps.getProductByClassAndprice(productclass,low_price,high_price);
		
		/**���±����Ϣ***/
		//�������Modal
		pTableModal=new PTableModal(pList);
		//���ñ��Modal
		pTable.setModel(pTableModal);
	}
	
	
	//������ļ����¼�����
	public void itemStateChanged(ItemEvent e)  
	{       
	if(e.getStateChange()==ItemEvent.SELECTED)      
	{                  
	String s=(String)CB_productclass.getSelectedItem();  
	String s2=(String) CB_price.getSelectedItem();
	
//	System.out.println(s);
//	System.out.println(s2);
	if(s.equals("ȫ��")){
		if(s2.equals("������")){
			try {
				repcpTable(s,"no","no");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
		else if(s2.equals("<100")){
			try {
				repcpTable(s,"no","100");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
		else if(s2.equals("100-500")){
			try {
				repcpTable(s,"100","500");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
		else if(s2.equals("500-1000")){
			try {
				repcpTable(s,"500","1000");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
		else if(s2.equals(">1000")){
			try {
				repcpTable(s,"1000","no");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
	}
	else{
		if(s2.equals("������")){
			try {
				repcpTable(s,"no","no");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
		else if(s2.equals("<100")){
			try {
				repcpTable(s,"no","100");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
		else if(s2.equals("100-500")){
			try {
				repcpTable(s,"100","500");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
		else if(s2.equals("500-1000")){
			try {
				repcpTable(s,"500","1000");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
		else if(s2.equals(">1000")){
			try {
				repcpTable(s,"1000","no");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
	}
	}
	}
	///****��ť�¼�����******///////////
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//����û����������Ϣ
		if(e.getSource()==btn_cmsg)
		{
			try {
				new CUI_cmsg(this.acount);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
		else if(e.getSource()==btn_hmsg){
			try {
				new CUI_hmsg(this.acount);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
		else if(e.getSource()==btn_addToCar){
			//�õ���ѡ�������
			String qty=(String) CB_selectnum.getSelectedItem();
			//�����Ʒ�����ﳵ
			
			try {
				if(JT_pno.getText().equals("")){
					JOptionPane.showMessageDialog(this,"����ѡ����Ʒ!!");
				}
				else{
					ccontrol.addOrder(JT_pno.getText(), JT_pname.getText(), qty, JT_pprice.getText());
					JOptionPane.showMessageDialog(this,"��ӳɹ�!!");
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
	}    
}
