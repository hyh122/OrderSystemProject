package com.orsystem.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import com.mysql.jdbc.Statement;
import com.orsystem.DataService.CustomerService;
import com.orsystem.DataService.EmployeeService;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CustomerAdd extends JFrame implements ActionListener{
	//员工业务服务方法
	private CustomerService cservice;
	
	JPanel pl1,pl2,pl3;
	JLabel text;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10;
	JTextField jt1,jt2,jt3,jt4,jt5,jt6,jt7,jt8,jt9,jt10;
	JPasswordField jp1,jp2;
	JButton button1,button2;
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerAdd qq=new CustomerAdd();
	}
	public CustomerAdd(){
		cservice=new CustomerService();
//		Toolkit tk=Toolkit.getDefaultToolkit();
//		Image img=tk.getImage("image/C.gif");
//		this.setIconImage(img);
		pl1=new JPanel();
		pl2=new JPanel(new GridLayout(6,2));
		pl3=new JPanel();
		text=new JLabel("请输入要注册的客户信息,完成点击提交");
		jl1=new JLabel("顾客号",JLabel.CENTER);
		jt1=new JTextField();
		jt1.setSize(10,20);
		jl2=new JLabel("顾客名",JLabel.CENTER);
		jt2=new JTextField();
		jt2.setSize(10,20);
		jl3=new JLabel("地址",JLabel.CENTER);
		jt3=new JTextField();
		jt3.setSize(10,20);
		jl4=new JLabel("电话",JLabel.CENTER);
		jt4=new JTextField();
		jt4.setSize(10,20);
		jl5=new JLabel("邮编",JLabel.CENTER);
		jt5=new JTextField();
		jt5.setSize(10,20);
		
		
		button1=new JButton("提交");
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
		
		this.add(pl1,BorderLayout.NORTH);
		this.add(pl2,BorderLayout.CENTER);
		this.add(pl3,BorderLayout.SOUTH);
		this.setSize(300,300);
		
		this.setVisible(true);
		this.setResizable(false);//使框架不能伸缩
		

		
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==button1){
			if(jt1.getText().equals("")||jt2.getText().equals("")||jt3.getText().equals("")||jt4.getText().toString().equals("")||jt5.getText().toString().equals(""))
			{
				JOptionPane.showMessageDialog(this,"请填满客户信息!!");
			}
			else{
			cservice.addCustomer(jt1.getText().toString(),jt2.getText().toString(),jt3.getText().toString(),jt4.getText().toString(),
					jt5.getText().toString());
			JOptionPane.showMessageDialog(this,"添加成功!!");
			cservice.addCustomer2(jt1.getText().toString(),"000000");
			this.dispose();
			}
					
	}
		else{
			this.dispose();
		}

	}}
