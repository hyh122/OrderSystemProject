/**
 * 功能:qq客户端登录界面
 */
package com.orsystem.ui;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.*;

import com.orsystem.Service.ManagerService;



import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
	//定义管理员服务类
	private ManagerService managerservice;
	//定义北部需要的组件
	//Download by http://www.codefans.net
	JLabel jbl1;
	private JPanel MainPanel;
	//定义中部需要的组件
	JPanel jp2,jp3,jp4;
	JLabel jp2_jlb_id,jp2_jlb_pw,jp2_jbl3,jp2_jbl4;
	
	JTextField jp2_jtf_id;
	JPasswordField jp2_jpf_pw;
//	JCheckBox jp2_jcb1,jp2_jcb2;
	
	
	
	//定义南部需要的组件
	JPanel jp1;
	JButton jp1_jb1,jp1_jb2,jp1_jb3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login qqClientLogin=new Login();//新建一个QqClientLogin类，无参数的构造函数
	}
	
	public Login()//类QqClientLogin的构造函数
	{
		//初始化managerService服务
		managerservice=new ManagerService();
		Toolkit tk=Toolkit.getDefaultToolkit();
		Image img=tk.getImage("image/C.gif");
		this.setIconImage(img);
	//初始化主面板
		MainPanel=new JPanel();
		MainPanel.setBackground(Color.LIGHT_GRAY);
		//处理北部
		jbl1=new JLabel(new ImageIcon("image/tou.gif"));
		
		//处理中部
		jp2=new JPanel(new GridLayout(3,2));//的组件按你指定的几行几列给分开，你添加其他组件时，会按你添加的顺序挨个添加到该组件上
		
		jp2_jlb_id=new JLabel("用户号",JLabel.CENTER);
		jp2_jlb_pw=new JLabel("密码",JLabel.CENTER);
		
		//jp2_jbl3.setForeground(Color.red);//设置字体颜色
		
		//jp2_jb1=new JButton(new ImageIcon("image/clear.gif"));
		jp2_jtf_id=new JTextField();
		jp2_jpf_pw=new JPasswordField();
		
		
//		jp2_jcb1=new JCheckBox("隐身登录");
//		jp2_jcb2=new JCheckBox("记住密码");
		
		//把控件按照顺序加入到jp2
		jp2.add(jp2_jlb_id);
		jp2.add(jp2_jtf_id);
		jp2.add(jp2_jlb_pw);
		jp2.add(jp2_jpf_pw);
//	
//		jp2.add(jp2_jcb1);
//		jp2.add(jp2_jcb2);
		
	
		
		//处理南部
		jp1=new JPanel();
		jp1_jb1=new JButton(new ImageIcon("image/denglu.gif"));
		//响应用户点击登录
		jp1_jb1.addActionListener(this);
		jp1_jb2=new JButton(new ImageIcon("image/quxiao.gif"));
		//响应用户取消登录
		jp1_jb2.addActionListener(this);
		jp1_jb3=new JButton(new ImageIcon("image/xiangdao.gif"));
		//响应用户注册登录
		jp1_jb3.addActionListener(this);
		
		//把三个按钮放入到jp1
		jp1.add(jp1_jb1);
		jp1.add(jp1_jb2);
		jp1.add(jp1_jb3);
		
		MainPanel.add(jbl1,BorderLayout.NORTH);
		MainPanel.add(jp2,BorderLayout.CENTER);
		MainPanel.add(jp1,BorderLayout.SOUTH);
		this.add(MainPanel);
		this.setSize(350, 240);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);//使框架不能伸缩
	}

	public void actionPerformed(ActionEvent arg0){
		
		if(arg0.getSource()==jp1_jb1)
		{
			
			try {
				if(managerservice.queryManagerById1(jp2_jtf_id.getText().toString().trim())){
					JOptionPane.showMessageDialog(this,"登录成功");
				}
				else
				{	//JOptionPane.showMessageDialog(this,"登录失败");
				new Main();}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
		else if(arg0.getSource()==jp1_jb2){
			this.dispose();
		}
		
			
			
			
		
		}
	}


