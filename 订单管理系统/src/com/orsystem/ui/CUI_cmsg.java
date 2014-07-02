package com.orsystem.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.orsystem.DataService.CustomerService;
import com.orsystem.DataService.EmployeeService;
import com.orsystem.DataTable.Customer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CUI_cmsg extends JFrame implements ActionListener{
	//客户业务服务方法
	private CustomerService cservice;
	
	JPanel pl1,pl2,pl3;
	JLabel text;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10;
	JTextField jt1,jt2,jt3,jt4,jt5,jt6,jt7,jt8,jt9,jt10;
	JPasswordField jp1,jp2;
	JButton button1,button2;
	
	//刚开始标志文本框为不可编辑的
	private boolean cflag=false;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public CUI_cmsg(String acount) throws IOException, ClassNotFoundException, SQLException{
		cservice=new CustomerService();
		//得到当前客户的信息
		Customer c=new Customer();
		c=cservice.queryCustomerById(acount);
		
//		Toolkit tk=Toolkit.getDefaultToolkit();
//		Image img=tk.getImage("image/C.gif");
//		this.setIconImage(img);
//		
		pl1=new JPanel();
		pl2=new JPanel(new GridLayout(6,2));
		pl3=new JPanel();
		
		text=new JLabel("客户信息");
		jl1=new JLabel("顾客号",JLabel.CENTER);
		jt1=new JTextField();
		jt1.setSize(10,20);
		//设为不能改动的
		jt1.setEditable(false);
		//显示当前客户的客户号
		jt1.setText(c.getCustomerNo());
		
		jl2=new JLabel("顾客名",JLabel.CENTER);
		jt2=new JTextField();
		jt2.setSize(10,20);
		//设为不能改动的
		jt2.setEditable(false);
		//显示当前客户的客户名
		jt2.setText(c.getCustomerName());
		
		jl3=new JLabel("地址",JLabel.CENTER);
		jt3=new JTextField();
		jt3.setSize(10,20);
		//设为不能改动的
		jt3.setEditable(false);
		//显示当前客户的地址
		jt3.setText(c.getAddress());
		
		jl4=new JLabel("电话",JLabel.CENTER);
		jt4=new JTextField();
		jt4.setSize(10,20);
		//设为不能改动的
		jt4.setEditable(false);
		//显示当前客户的电话
		jt4.setText(c.getTelephone());
		
		jl5=new JLabel("邮编",JLabel.CENTER);
		jt5=new JTextField();
		jt5.setSize(10,20);
		//设为不能改动的
		jt5.setEditable(false);
		//显示当前客户的邮编
		jt5.setText(c.getZip());
		
		
		button1=new JButton("修改");
		button1.addActionListener(this);
		button2=new JButton("取消");
		button2.addActionListener(this);
		
		
		
		
		
		
		pl1.add(text);
		
		pl2.add(jl1);
		pl2.add(jt1);
		pl2.add(jl2);
		pl2.add(jt2);
		pl2.add(jl3);
		pl2.add(jt3);
		pl2.add(jl4);
		pl2.add(jt4);
		pl2.add(jl5);
		pl2.add(jt5);
	
		
		pl3.add(button1);
		pl3.add(button2);
		pl1.setBackground(new Color(100,255,255));
		pl2.setBackground(new Color(100,255,255));
		pl3.setBackground(new Color(100,255,255));
		this.add(pl1,BorderLayout.NORTH);
		this.add(pl2,BorderLayout.CENTER);
		this.add(pl3,BorderLayout.SOUTH);
		this.setSize(300,300);
		
		this.setVisible(true);
		this.setResizable(false);//使框架不能伸缩
		

		
		
		
		
	}
	//将显示客户信息的文本区域显示成可编辑或不可编辑的
	public void setcEdited(){
		//假如原来不可编辑则显示成可编辑的,否则显示成不可编辑的
		if(cflag==false){
		jt2.setEditable(true);
		jt3.setEditable(true);
		jt4.setEditable(true);
		jt5.setEditable(true);
	
		cflag=true;
		}
		else{
			jt2.setEditable(false);
			jt3.setEditable(false);
			jt4.setEditable(false);
			jt5.setEditable(false);
			cflag=false;
		}
	}
	//获取JTextField里面客户信息的方法
	public Customer getcMsg(){
		Customer c=new Customer();
	c.setCustomerNo(jt1.getText().toString());
	c.setCustomerName(jt2.getText().toString());
	c.setAddress(jt3.getText().toString());
	c.setTelephone(jt4.getText().toString());
	c.setZip(jt5.getText().toString());
		return c;
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==button1){
			if(button1.getText().equals("修改"))
			{
				//设置文本域为可编辑的
				setcEdited();
				button1.setText("完成");
			}
			
			else{
				setcEdited();
				Customer c=getcMsg();
				try {
					cservice.update(c);
					JOptionPane.showMessageDialog(this,"修改成功!!");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				button1.setText("修改");
			}
					
	}
		else{
			this.dispose();
		}

	}}
