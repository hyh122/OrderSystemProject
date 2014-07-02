package com.orsystem.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.orsystem.Modal.DataCountModal;
import com.orsystem.control.dis_historyOrder;

public class EDataCountUI extends JFrame {

	private JPanel contentPane;
	private DataCountModal dcm;
	private dis_historyOrder d;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	public EDataCountUI(String EmployeeNo) {
		getContentPane().setBackground(new Color(204, 255, 255));
		setBackground(new Color(204, 255, 255));
		this.setSize(342, 357);
		this.setVisible(true);
		this.setResizable(false);
		getContentPane().setLayout(null);
		//实例化业务服务类和modal
		d=new dis_historyOrder();
		dcm=new DataCountModal();
		dcm=d.DataCountByeNo(EmployeeNo);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(68, 10, 213, 41);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("\u7EDF\u8BA1\u6E05\u5355");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 204));
		panel_1.setBounds(29, 73, 287, 237);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("累计订单总量");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(25, 10, 117, 24);
		panel_1.add(lblNewLabel_1);
		
		JLabel lb_ordernum = new JLabel(String.valueOf(dcm.getOrderNum()));
		
		lb_ordernum.setFont(new Font("宋体", Font.PLAIN, 15));
		lb_ordernum.setBounds(173, 10, 81, 24);
		panel_1.add(lb_ordernum);
		
		JLabel lblNewLabel_3 = new JLabel("累计订单总额");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(25, 50, 117, 24);
		panel_1.add(lblNewLabel_3);
		
		JLabel lb_ordertotalprice = new JLabel(String.valueOf(dcm.getHorderTotalPrice())+"元");
		lb_ordertotalprice.setFont(new Font("宋体", Font.PLAIN, 15));
		lb_ordertotalprice.setBounds(173, 50, 89, 24);
		panel_1.add(lb_ordertotalprice);
		
		JLabel lblNewLabel_5 = new JLabel("今天处理的订单数");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(22, 90, 133, 24);
		panel_1.add(lblNewLabel_5);
		
		JLabel lb_highestOrder = new JLabel(String.valueOf(dcm.getTodayOrderNum()));
		lb_highestOrder.setFont(new Font("宋体", Font.PLAIN, 15));
		lb_highestOrder.setBounds(173, 90, 104, 24);
		panel_1.add(lb_highestOrder);
		
		JLabel lblNewLabel_7 = new JLabel("今天处理的订单总额");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(22, 134, 140, 31);
		panel_1.add(lblNewLabel_7);
		
		JLabel lb_highestPrice = new JLabel(String.valueOf(dcm.getTodayOrderPrice())+"元");
		lb_highestPrice.setFont(new Font("宋体", Font.PLAIN, 15));
		lb_highestPrice.setBounds(173, 134, 89, 23);
		panel_1.add(lb_highestPrice);
		
		JLabel lblNewLabel_9 = new JLabel("业务量排行位置");
		lblNewLabel_9.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(25, 175, 117, 36);
		panel_1.add(lblNewLabel_9);
		
		JLabel lb_todayPrice = new JLabel("第"+String.valueOf(dcm.getLevel())+"名");
		lb_todayPrice.setFont(new Font("宋体", Font.PLAIN, 15));
		lb_todayPrice.setBounds(173, 175, 81, 26);
		panel_1.add(lb_todayPrice);
	}
}

