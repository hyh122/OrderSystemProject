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

	//主界面的主Panel
	private JPanel MainPanel;
	//商品数据库服务类
	ProductService ps;
	//存放全部商品信息的集合
	List<Product> pList;
	//显示产品信息的表格
	private JTable pTable;
	//表格Modal
	private PTableModal pTableModal;
	private JTextField JT_pno;
	private JTextField JT_pname;
	private JTextField JT_pclass;
	private JTextField JT_pprice;
	//按钮
	JButton btn_cmsg,btn_hmsg,btn_mycar, btn_changep,btn_exit,btn_addToCar,btn_Topay;
	
	//下拉框
	JComboBox CB_productclass,CB_price,CB_selectnum;
	//登录的账号
	private String acount;
	//显示日期的类
	dis_Date dis_date;
	//客户界面的control类
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
	//传进来一个账号，该账号为登录的账号
	public CustomerUI(String acount) throws IOException, ClassNotFoundException, SQLException {
		this.setSize(951, 587);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		this.setResizable(false);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.acount=acount;
		//初始化控制类
		ccontrol=new CUI_Control();
		//新建主界面主Panel
		MainPanel=new JPanel();
		//添加到JFrame
		getContentPane().add(MainPanel);
		//设置布局格式
		MainPanel.setLayout(new BorderLayout(0, 0));
		
		//*********************北部布局开始界限***************************//////////////////////
		JPanel JP_N = new JPanel();
		MainPanel.add(JP_N, BorderLayout.PAGE_START);
		JP_N.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		JP_N.add(toolBar);
		toolBar.setBackground(Color.CYAN);
		
		JLabel JL_CustomerNo = new JLabel("\u5BA2\u6237\u53F7\uFF0C");
		JL_CustomerNo.setFont(new Font("宋体", Font.PLAIN, 20));
		JL_CustomerNo.setText(acount);
		toolBar.add(JL_CustomerNo);
		
		JLabel JL_welcome = new JLabel("\u60A8\u597D\uFF01\u6B22\u8FCE\u767B\u5F55");
		JL_welcome.setFont(new Font("宋体", Font.PLAIN, 25));
		toolBar.add(JL_welcome);
		///北部布局嵌套的布局
		JPanel JP_N1 = new JPanel();
		JP_N1.setBackground(Color.CYAN);
		toolBar.add(JP_N1);
		
		 btn_cmsg = new JButton("\u4E2A\u4EBA\u4FE1\u606F");
		btn_cmsg.setFont(new Font("宋体", Font.PLAIN, 15));
		//添加事件监听事件
		btn_cmsg.addActionListener(this);
		
		 btn_hmsg = new JButton("\u5386\u53F2\u8BA2\u5355");
		btn_hmsg.setFont(new Font("宋体", Font.PLAIN, 15));
		//添加监听事件
		btn_hmsg.addActionListener(this);
		
		 btn_mycar = new JButton("\u6211\u7684\u8D2D\u7269\u8F66");
		btn_mycar.setFont(new Font("宋体", Font.PLAIN, 15));
		
		 btn_changep = new JButton("\u4FEE\u6539\u5BC6\u7801");
		btn_changep.setFont(new Font("宋体", Font.PLAIN, 15));
		
		 btn_exit = new JButton("\u9000\u51FA");
		btn_exit.setFont(new Font("宋体", Font.PLAIN, 15));
		
		//显示日期的书签
		dis_date=new dis_Date();
		JLabel lb_date = new JLabel("date");
		lb_date.setText(dis_date.get_curDate());
		lb_date.setFont(new Font("宋体", Font.PLAIN, 15));
		////***********分组布局************************///////////////////
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
		///*****分组布局结束**///////////
		JP_N1.setLayout(gl_JP_N1);
		
		//*********北部布局结束界限****////////////////
		
		
		/////************中部布局开始界限********************////////////////////////
		JPanel JP_C = new JPanel();
		MainPanel.add(JP_C, BorderLayout.CENTER);
		
		////中部局部嵌套的北部布局
		JPanel JP_C1 = new JPanel();
	
		JLabel LB_productlist = new JLabel("\u5546\u54C1\u5217\u8868");
		LB_productlist.setFont(new Font("宋体", Font.PLAIN, 25));
		JP_C1.add(LB_productlist);
		

		//中部布局嵌套的南部布局
		JPanel JP_C3 = new JPanel();
		
		//初始化商品数据库服务类
		ps=new ProductService();
	
		pList=ps.getAllProduct();
		
		//创建表格Modal
		pTableModal=new PTableModal(pList);
		//创建表格
		pTable=new JTable();
		//设置表格Modal
		pTable.setModel(pTableModal);
		
	    //设置每一列的高度
		pTable.setRowHeight(22);
		//给eTable加上一个鼠标事件监听器对象
		 pTable.addMouseListener(new java.awt.event.MouseAdapter(){
     	 public void mouseClicked(MouseEvent ev) {//仅当鼠标单击时响应
     		 //得到选中的行列的索引值
     		int r= pTable.getSelectedRow();
     		Product p=new Product();
     		p=pList.get(r);
     		pDisplay(p.getProductNo(),p.getProductName(),p.getProductClass(),String.valueOf(p.getProductPrice()));

     	 }
      });
		//添加表格到ScrollPane上
		JScrollPane scrollPane1 = new JScrollPane(pTable);
		scrollPane1.setPreferredSize(new Dimension(800, 200));
		JP_C3.add(scrollPane1);
		JP_C.setLayout(new BorderLayout(0, 0));
		JP_C.add(JP_C1,BorderLayout.NORTH);
		JP_C.add(JP_C3,BorderLayout.SOUTH);
		
		//中部布局嵌套的中部布局
		JPanel JP_C2 = new JPanel();
		JP_C.add(JP_C2, BorderLayout.CENTER);
		
		
		JLabel LB_productclass = new JLabel("\u5546\u54C1\u7C7B\u578B");
		LB_productclass.setFont(new Font("宋体", Font.PLAIN, 18));
		JP_C2.add(LB_productclass);
		
		//下拉框，选择商品类别
		CB_productclass = new JComboBox(ps.getAllClassName());
		//添加监听事件
		CB_productclass.addItemListener(this);
		JP_C2.add(CB_productclass);
		
		JLabel LB_price = new JLabel("\u4EF7\u4F4D");
		LB_price.setFont(new Font("宋体", Font.PLAIN, 18));
		JP_C2.add(LB_price);
		
		//下拉框，选择商品价位
		CB_price = new JComboBox();
		CB_price.addItem("无限制");
		CB_price.addItem("<100");
		CB_price.addItem("100-500");
		CB_price.addItem("500-1000");
		CB_price.addItem(">1000");
		//为下拉框添加监听事件
		CB_price.addItemListener(this);
		JP_C2.add(CB_price);
		
		//////****************中部布局结束界限***//****////////////////////////////
		
	
		
		
		//**********************南部布局开始界限******************///////////////
		JPanel JP_S = new JPanel();
		MainPanel.add(JP_S, BorderLayout.SOUTH);
		JP_S.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_S1 = new JPanel();
		JP_S.add(JP_S1,BorderLayout.NORTH);
		//南部布局嵌套的中部布局
		JLabel lblNewLabel_5 = new JLabel("\u9009\u4E2D\u7684\u5546\u54C1\u4FE1\u606F");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 25));
		JP_S1.add(lblNewLabel_5);
		
		JPanel JP_S2 = new JPanel();
		JP_S.add(JP_S2, BorderLayout.CENTER);
		
		JPanel panel_9 = new JPanel();
		JP_S2.add(panel_9);
		panel_9.setLayout(new GridLayout(2,4));
		
		JLabel lblNewLabel_7 = new JLabel("\u5546\u54C1\u53F7");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_9.add(lblNewLabel_7);
		
		JT_pno = new JTextField();
		panel_9.add(JT_pno);
		JT_pno.setColumns(10);
		JT_pno.setEditable(false);
		
		JLabel lblNewLabel_6 = new JLabel("\u5546\u54C1\u540D");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_9.add(lblNewLabel_6);
		
		JT_pname = new JTextField();
		panel_9.add(JT_pname);
		JT_pname.setColumns(10);
		JT_pname.setEditable(false);
		
		JLabel lblNewLabel_8 = new JLabel("\u5546\u54C1\u7C7B\u578B");
		lblNewLabel_8.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_9.add(lblNewLabel_8);
		
		JT_pclass = new JTextField();
		panel_9.add(JT_pclass);
		JT_pclass.setColumns(10);
		JT_pclass.setEditable(false);
		
		JLabel lblNewLabel_9 = new JLabel("\u5546\u54C1\u4EF7\u683C");
		lblNewLabel_9.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_9.add(lblNewLabel_9);
		
		JT_pprice = new JTextField();
		panel_9.add(JT_pprice);
		JT_pprice.setColumns(10);
		JT_pprice.setEditable(false);
		
		//南部布局嵌套的南部布局
		JPanel JP_S3 = new JPanel();
		JP_S.add(JP_S3, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_10 = new JLabel("\u8BF7\u9009\u62E9\u5546\u54C1\u6570\u91CF");
		lblNewLabel_10.setFont(new Font("宋体", Font.PLAIN, 20));
		String[] num={"1","2","3","4","5"};
		CB_selectnum = new JComboBox(num);
		
		//CB_selectnum.addItem(num);
		
		btn_addToCar = new JButton("\u6DFB\u52A0\u5230\u8D2D\u7269\u8F66");
		btn_addToCar.setFont(new Font("宋体", Font.PLAIN, 20));
		//增加监听事件
		btn_addToCar.addActionListener(this);
		
		 btn_Topay = new JButton("\u53BB\u7ED3\u7B97");
		btn_Topay.setFont(new Font("宋体", Font.PLAIN, 20));
		////******************分组布局部分*************************/////////////////
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
		//********************分组布局部分***************************//////////////
		//将南部布局嵌套的南部布局设为分组布局
		JP_S3.setLayout(gl_JP_S3);
		
	}
	
	////*******************方法部分*************/////////////
	//设置JTextField里面显示商品信息的方法
	public void pDisplay(String productNo,String productName,String productClass,String productPrice){
		JT_pno.setText(productNo);
		JT_pname.setText(productName);
		JT_pclass.setText(productClass);
		JT_pprice.setText(productPrice);
	
		
	}
	//刷新商品列表的方法(全部商品)
	public void repTable() throws IOException, ClassNotFoundException, SQLException{
		pList=ps.getAllProduct();
		/**更新表格信息***/
		//创建表格Modal
		pTableModal=new PTableModal(pList);
		//设置表格Modal
		pTable.setModel(pTableModal);
	}
	//刷新商品列表的方法(按商品类别,商品价位)
	public void repcpTable(String productclass,String low_price,String high_price) throws IOException, ClassNotFoundException, SQLException{
		pList=ps.getProductByClassAndprice(productclass,low_price,high_price);
		
		/**更新表格信息***/
		//创建表格Modal
		pTableModal=new PTableModal(pList);
		//设置表格Modal
		pTable.setModel(pTableModal);
	}
	
	
	//下拉框的监听事件处理
	public void itemStateChanged(ItemEvent e)  
	{       
	if(e.getStateChange()==ItemEvent.SELECTED)      
	{                  
	String s=(String)CB_productclass.getSelectedItem();  
	String s2=(String) CB_price.getSelectedItem();
	
//	System.out.println(s);
//	System.out.println(s2);
	if(s.equals("全部")){
		if(s2.equals("无限制")){
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
		if(s2.equals("无限制")){
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
	///****按钮事件监听******///////////
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//如果用户点击个人信息
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
			//得到被选择的数量
			String qty=(String) CB_selectnum.getSelectedItem();
			//添加商品到购物车
			
			try {
				if(JT_pno.getText().equals("")){
					JOptionPane.showMessageDialog(this,"请先选择商品!!");
				}
				else{
					ccontrol.addOrder(JT_pno.getText(), JT_pname.getText(), qty, JT_pprice.getText());
					JOptionPane.showMessageDialog(this,"添加成功!!");
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
	}    
}
