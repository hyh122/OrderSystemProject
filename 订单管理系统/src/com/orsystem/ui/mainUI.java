package com.orsystem.ui;
/**

 * 功能:订单管理系统界面
 */

import java.io.*;
import java.sql.Connection;
import java.util.Date;

import javax.swing.*;



import java.awt.*;
import java.awt.event.*;

public class mainUI extends JFrame implements ActionListener{
	

	
	//定义中部需要的组件
	//.中部有五个JPanel,有一个叫选项卡窗口管理
	JTabbedPane jtp;//选项卡
	//定义五个JPanel分别为主页,员工管理，客户管理，订单管理，产品管理，账号管理
	JPanel jp_main,jp_em,jp_cm,jp_omm,jp_pm,jp_zm;
	//员工管理panel里面的子panel
	JPanel jp_em_jp1,jp_em_jp2;
	JPanel je2_jp1,je2_jp2,je2_jp3;
	JScrollPane je2_jsp;
	JLabel jl_em_show,jl_em_menu;
	JTable je2_table;
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mainUI qqClientLogin=new mainUI();//新建一个QqClientLogin类，无参数的构造函数
	}
	
	public mainUI()//类QqClientLogin的构造函数
	{
		Toolkit tk=Toolkit.getDefaultToolkit();
		Image img=tk.getImage("image/C.gif");
		this.setIconImage(img);
		
	
		 
	//初始化JPanel组件
		jp_main=new JPanel();
		jp_em=new JPanel();
		jp_cm=new JPanel();
		jp_omm=new JPanel();
		jp_pm=new JPanel();
		jp_zm=new JPanel();
	//初始化员工管理界面的子panel
		jp_em_jp1=new JPanel();
		jp_em_jp2=new JPanel();
	//对jp_em_jp2的子界面初始化
		je2_jp1=new JPanel();
		je2_jp2=new JPanel();
		je2_jp3=new JPanel();
		
		//定义二维数组作为表格数据     
		Object[][] tableData =       
			{          new Object[]{"","","","","","","","","",""},          
				new Object[]{"","","","","","","","","",""},          
				new Object[]{"","","","","","","","","",""},          
				new Object[]{"","","","","","","","","",""},  
			};      
		//定义一维数据作为列标题     
		Object[] columnTitle = {"员工号" , "员工名" , "性别","出生日期","地址","电话号码","雇佣日期" +
				"部门","职位","薪水"};    
		//以二维数组和一维数组来创建一个JTable对象         
		je2_table = new JTable(tableData , columnTitle); 
		
		  
		JSplitPane splitPane = new JSplitPane ();//创建一个分隔容器类
		  splitPane.setOneTouchExpandable (true); //让分割线显示出箭头
		//  splitPane.setContinuousLayout (true); //当用户操作分割线箭头时，系统会重绘图形
		  splitPane.setPreferredSize (new Dimension (850,660));
		  splitPane.setOrientation (JSplitPane.HORIZONTAL_SPLIT); //设置分割线为水平分割线
		  splitPane.setLeftComponent (jp_em_jp1); //将b1放到分割线左边，将b2放到分割线右边
		  splitPane.setRightComponent (jp_em_jp2);
		  splitPane.setDividerSize (8); //设置分割线大小为3个单位
		  splitPane.setDividerLocation(200); //设置分割线的位置位于中间
		 
		  
		  jp_em.add(splitPane);
		  
		 
		
		//左边显示菜单
			jl_em_menu=new JLabel("员工管理");
		//欢迎标签
		
		jl_em_show=new JLabel("这是员工管理界面");
		JLabel jl_em_show2=new JLabel("这是员工管理界面");
		je2_jp1.add(jl_em_show);
		je2_jp2.add(jl_em_show2);
		je2_jsp=new JScrollPane(je2_table);
		je2_jp3.add(je2_jsp);
		//添加到jp_em_jp1
		jp_em_jp1.add(jl_em_menu);
		//添加到jp_em_jp2
		jp_em_jp2.add(je2_jp1,BorderLayout.NORTH);
		jp_em_jp2.add(je2_jp2,BorderLayout.CENTER);
		jp_em_jp2.add(je2_jp3,BorderLayout.SOUTH);

		
		
	
		//创建选项卡窗口
		jtp=new JTabbedPane();
		jtp.add("主页",jp_main);
		jtp.add("员工管理",jp_em);
		jtp.add("客户管理",jp_cm);
		jtp.add("订单管理",jp_omm);
		jtp.add("产品管理",jp_pm);
		jtp.add("账号管理",jp_zm);
		
		
		
		
		this.add(jtp,"Center");
	
		this.setSize(850, 660);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);//使框架不能伸缩
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//如果用户点击登录
//		if(arg0.getSource()==jp1_jb1)
//		{
//			
//		}
//			else if(arg0.getSource()==jp1_jb2){
//				//关闭掉登录界面
//				this.dispose();
//			}
//			else if(arg0.getSource()==jp1_jb3){
//				
//			}
		}
	}


