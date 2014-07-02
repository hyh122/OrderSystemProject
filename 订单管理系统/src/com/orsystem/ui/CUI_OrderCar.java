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

	//主界面的主Panel
	private JPanel MainPanel;
	
	//显示客户购物车订单的表格
	private JTable ocTable;
	//表格Modal
	private OrderCarTableModal ocTableModal;
	//购物车服务类
	private COrderCarService ocservice;
	//存放购物车订单的modal集合
	private List<cHistoryOrder> choList;
	//按钮
	private JButton btn_buy,btn_delete,btn_refresh;
	//控制类
	private CUI_Control control;
	//用户号
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
		//新建主界面主Panel
		MainPanel=new JPanel();
		//添加到JFrame
		getContentPane().add(MainPanel);
		//设置布局格式
		MainPanel.setLayout(new BorderLayout(0, 0));
		//初始化控制类
		control=new CUI_Control();
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		MainPanel.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\u6211\u7684\u8D2D\u7269\u8F66\u5546\u54C1");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 255, 255));
		MainPanel.add(panel_1, BorderLayout.CENTER);

		ocservice=new COrderCarService();
		choList=ocservice.getAllOrderByNo(customerno);
		//创建表格Modal
		ocTableModal=new OrderCarTableModal(choList);
		//创建表格
		ocTable=new JTable();
		//设置表格Modal
		ocTable.setModel(ocTableModal);
		//给table加上一个鼠标事件监听器对象
		 ocTable.addMouseListener(new java.awt.event.MouseAdapter(){
      	 public void mouseClicked(MouseEvent e) {//仅当鼠标单击时响应
      		 //得到选中的行列的索引值
      		int r= ocTable.getSelectedRow();
      		
      		System.out.println(r);
   			
   		   
      	 }
       });


		//设置第一列的宽度
//		choTable.getColumnModel().getColumn(0).setPreferredWidth(100); 

	    //设置每一列的高度
		ocTable.setRowHeight(22);
		//添加表格到ScrollPane上
		
		
		JScrollPane scrollPane = new JScrollPane(ocTable);
		scrollPane.setPreferredSize(new Dimension(850, 200));
		panel_1.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 255, 255));
		MainPanel.add(panel_2, BorderLayout.SOUTH);
		
		btn_buy = new JButton("\u8D2D\u4E70");
		btn_buy.setFont(new Font("宋体", Font.PLAIN, 20));
		//添加监听事件
		btn_buy.addActionListener(this);
		
		JLabel lblNewLabel_1 = new JLabel("\u9009\u62E9\u5904\u7406\u8BA2\u5355\u7684\u5458\u5DE5");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_1);
		
		 CB_selectEmp = new JComboBox(control.getAllEmployeeNo());
		
		panel_2.add(CB_selectEmp);
		panel_2.add(btn_buy);
		
		 btn_delete = new JButton("清空购物车");
		btn_delete.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_2.add(btn_delete);
		btn_delete.addActionListener(this);
		
		 btn_refresh = new JButton("\u5237\u65B0");
		btn_refresh.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_2.add(btn_refresh);
		btn_refresh.addActionListener(this);
		
		
		this.setSize(919, 361);
		
		this.setVisible(true);
		
		this.setResizable(false);
	}
	///*******方法部分*************************////////////////////
	//刷新购物车列表的方法(全部商品)
	public void reTable() throws IOException, ClassNotFoundException, SQLException{
		choList=ocservice.getAllOrderByNo(customerno);
		/**更新表格信息***/
		//创建表格Modal
		ocTableModal=new OrderCarTableModal(choList);
		//创建表格
		ocTable.setModel(ocTableModal);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn_buy){
			if(choList.size()==0){
				JOptionPane.showMessageDialog(this,"购物车没有商品,请先添加商品!!");
			}
			else{
				control.UpLoadOrder(customerno, choList);
				//将购物车里的订单添加到待处理的订单表中
				control.addToNoDoOrder((String) CB_selectEmp.getSelectedItem(), choList);
				
			//清空该用户客户车里面的商品
			control.deleteOrderByno(customerno);
			JOptionPane.showMessageDialog(this,"提交订单成功!!");
			//刷新列表
			try {
//				//创建新的订单
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
