package com.orsystem.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JPasswordField;

import com.orsystem.control.LoginControl;

public class LoginUI extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField JT_acount;
	private JPasswordField JPa_passwd;
	private JButton btn_login,btn_cancel;
	private JRadioButton JR_em,JR_cm,JR_sm;
	private String PersonType=null;
	private LoginControl lc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new LoginUI();
	}

	/**
	 * Create the frame.
	 */
	public LoginUI() {
		lc=new LoginControl();
		getContentPane().setBackground(Color.CYAN);

		this.setSize(511, 360);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		//定义北部面板
		JPanel Npanel = new JPanel();
		Npanel.setBackground(Color.CYAN);
		getContentPane().add(Npanel, BorderLayout.CENTER);
		Npanel.setLayout(new BorderLayout(0, 0));
		
		//北部面板的子面板1
		JPanel NP_1 = new JPanel();
		NP_1.setBackground(Color.CYAN);
		Npanel.add(NP_1, BorderLayout.NORTH);
		
		JLabel JL_Title = new JLabel("\u8BA2\u5355\u7BA1\u7406\u7CFB\u7EDF\u767B\u5F55\u754C\u9762");
		NP_1.add(JL_Title);
		JL_Title.setFont(new Font("宋体", Font.PLAIN, 30));
		
		//北部面板的子面板2
		JPanel NP_2 = new JPanel();
		NP_2.setBackground(Color.GREEN);
		Npanel.add(NP_2, BorderLayout.CENTER);
		
		JLabel JL_acount = new JLabel("\u8D26\u53F7");
		JL_acount.setFont(new Font("宋体", Font.PLAIN, 25));
		
		JT_acount = new JTextField();
		JT_acount.setFont(new Font("宋体", Font.PLAIN, 20));
		JT_acount.setColumns(10);
		
		JLabel JL_passwd = new JLabel("\u5BC6\u7801");
		JPa_passwd = new JPasswordField();
		JL_passwd.setFont(new Font("宋体", Font.PLAIN, 25));
		
		
		//定义南部
		JPanel NP_2_S = new JPanel();
		NP_2_S.setBackground(Color.GREEN);
		
		
		GroupLayout gl_NP_2 = new GroupLayout(NP_2);
		gl_NP_2.setHorizontalGroup(
			gl_NP_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_NP_2.createSequentialGroup()
					.addGap(173)
					.addGroup(gl_NP_2.createParallelGroup(Alignment.LEADING)
						.addComponent(JL_acount)
						.addComponent(JL_passwd))
					.addGap(52)
					.addGroup(gl_NP_2.createParallelGroup(Alignment.LEADING)
						.addComponent(JPa_passwd, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
						.addComponent(JT_acount, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
					.addGap(43))
				.addComponent(NP_2_S, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
		);
		gl_NP_2.setVerticalGroup(
			gl_NP_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_NP_2.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_NP_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(JL_acount)
						.addComponent(JT_acount, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_NP_2.createParallelGroup(Alignment.LEADING)
						.addComponent(JL_passwd)
						.addComponent(JPa_passwd, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(NP_2_S, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
		);
		
		JLabel JL_choose = new JLabel("\u8BF7\u9009\u62E9\u8EAB\u4EFD");
		JL_choose.setHorizontalAlignment(SwingConstants.CENTER);
		JL_choose.setFont(new Font("黑体", Font.PLAIN, 25));
		//将单选按钮添加到同一组中
		ButtonGroup  bg=new ButtonGroup();
		 JR_em = new JRadioButton("\u5458\u5DE5");
		JR_em.setBackground(Color.GREEN);
		JR_em.setFont(new Font("宋体", Font.PLAIN, 15));
		//设置员工某人已经被选中
		JR_em.setSelected(true);
		
		 JR_cm = new JRadioButton("\u5BA2\u6237");
		JR_cm.setBackground(Color.GREEN);
		JR_cm.setFont(new Font("宋体", Font.PLAIN, 15));
		
		 JR_sm = new JRadioButton("\u7CFB\u7EDF\u7BA1\u7406\u5458");
		JR_sm.setBackground(Color.GREEN);
		JR_sm.setFont(new Font("宋体", Font.PLAIN, 15));
		//将单选按钮添加到同一组中
		bg.add(JR_em);
		bg.add(JR_cm);
		bg.add(JR_sm);
		
		///**************************分组布局部分代码****************************************////////////////////	
		GroupLayout gl_NP_2_S = new GroupLayout(NP_2_S);
		gl_NP_2_S.setHorizontalGroup(
			gl_NP_2_S.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_NP_2_S.createSequentialGroup()
					.addGap(32)
					.addComponent(JL_choose)
					.addGap(31)
					.addGroup(gl_NP_2_S.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_NP_2_S.createSequentialGroup()
							.addComponent(JR_em)
							.addGap(71)
							.addComponent(JR_cm))
						.addComponent(JR_sm))
					.addContainerGap(136, Short.MAX_VALUE))
		);
		gl_NP_2_S.setVerticalGroup(
			gl_NP_2_S.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_NP_2_S.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_NP_2_S.createParallelGroup(Alignment.LEADING)
						.addComponent(JL_choose)
						.addGroup(gl_NP_2_S.createSequentialGroup()
							.addComponent(JR_em)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(JR_sm))
						.addComponent(JR_cm))
					.addContainerGap(8, Short.MAX_VALUE))
		);
	///**************************分组布局部分代码****************************************////////////////////	
		//将面板设为分组布局
		NP_2_S.setLayout(gl_NP_2_S);
		NP_2.setLayout(gl_NP_2);
		
		JPanel Spanel = new JPanel();
		Spanel.setBackground(Color.YELLOW);
		getContentPane().add(Spanel, BorderLayout.SOUTH);
		
		 btn_login = new JButton("\u767B\u5F55");
		btn_login.setBackground(Color.PINK);
		btn_login.setFont(new Font("宋体", Font.PLAIN, 25));
		//为登录按钮添加监听事件
		btn_login.addActionListener(this);
		
		btn_cancel = new JButton("\u53D6\u6D88");
		btn_cancel.setBackground(Color.PINK);
		btn_cancel.setFont(new Font("宋体", Font.PLAIN, 25));
		//为取消按钮添加监听
		btn_cancel.addActionListener(this);
		
	///**************************分组布局部分代码****************************************////////////////////	
		GroupLayout gl_Spanel = new GroupLayout(Spanel);
		gl_Spanel.setHorizontalGroup(
			gl_Spanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Spanel.createSequentialGroup()
					.addGap(125)
					.addComponent(btn_login)
					.addGap(80)
					.addComponent(btn_cancel)
					.addGap(129))
		);
		gl_Spanel.setVerticalGroup(
			gl_Spanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Spanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Spanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_cancel)
						.addComponent(btn_login))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		//将Spanel设为分组布局
	
		///**************************分组布局部分代码****************************************////////////////////	
		Spanel.setLayout(gl_Spanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn_login){
			if(JR_em.isSelected())
				PersonType="employee";
			else if(JR_cm.isSelected())
				PersonType="customer";
			else if(JR_sm.isSelected())
				PersonType="manager";
			System.out.println(PersonType);
			try {
			lc.Login(PersonType, JT_acount.getText().toString(), JPa_passwd.getText().toString());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
		}
		else if(e.getSource()==btn_cancel){
			this.dispose();
		}
	}
	
}
