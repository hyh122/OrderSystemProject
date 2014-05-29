package com.orsystem.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import com.mysql.jdbc.Statement;
import com.orsystem.Service.EmployeeService;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class EmployeeAdd extends JFrame implements ActionListener{
	//Ա��ҵ����񷽷�
	private EmployeeService eservice;
	
	JPanel pl1,pl2,pl3;
	JLabel text;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10;
	JTextField jt1,jt2,jt3,jt4,jt5,jt6,jt7,jt8,jt9,jt10;
	JPasswordField jp1,jp2;
	JButton button1,button2;
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeAdd qq=new EmployeeAdd();
	}
	public EmployeeAdd(){
		eservice=new EmployeeService();
		Toolkit tk=Toolkit.getDefaultToolkit();
		Image img=tk.getImage("image/C.gif");
		this.setIconImage(img);
		pl1=new JPanel();
		pl2=new JPanel(new GridLayout(6,2));
		pl3=new JPanel();
		text=new JLabel("������Ҫע���Ա����Ϣ,��ɵ���ύ");
		jl1=new JLabel("Ա����",JLabel.CENTER);
		jt1=new JTextField();
		jt1.setSize(10,20);
		jl2=new JLabel("Ա����",JLabel.CENTER);
		jt2=new JTextField();
		jt2.setSize(10,20);
		jl3=new JLabel("�Ա�",JLabel.CENTER);
		jt3=new JTextField();
		jt3.setSize(10,20);
		jl4=new JLabel("��������",JLabel.CENTER);
		jt4=new JTextField();
		jt4.setSize(10,20);
		jl5=new JLabel("��ͥסַ",JLabel.CENTER);
		jt5=new JTextField();
		jt5.setSize(10,20);
		jl6=new JLabel("�绰����",JLabel.CENTER);
		jt6=new JTextField();
		jt6.setSize(10,20);
		jl7=new JLabel("��Ӷ����",JLabel.CENTER);
		jt7=new JTextField();
		jt7.setSize(10,20);
		jl8=new JLabel("����",JLabel.CENTER);
		jt8=new JTextField();
		jt8.setSize(10,20);
		jl9=new JLabel("ְ��",JLabel.CENTER);
		jt9=new JTextField();
		jt9.setSize(10,20);
		jl10=new JLabel("нˮ",JLabel.CENTER);
		jt10=new JTextField();
		jt10.setSize(10,20);
		
		button1=new JButton("�ύ");
		button1.addActionListener(this);
		button2=new JButton("ȡ��");
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
		pl2.add(jl6);
		pl2.add(jt6);
		pl2.add(jl7);
		pl2.add(jt7);
		pl2.add(jl8);
		pl2.add(jt8);
		pl2.add(jl9);
		pl2.add(jt9);
		pl2.add(jl10);
		pl2.add(jt10);
		
		pl3.add(button1);
		pl3.add(button2);
		
		this.add(pl1,BorderLayout.NORTH);
		this.add(pl2,BorderLayout.CENTER);
		this.add(pl3,BorderLayout.SOUTH);
		this.setSize(300,300);
		
		this.setVisible(true);
		this.setResizable(false);//ʹ��ܲ�������
		

		
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==button1){
			if(jt1.getText().equals("")||jt2.getText().equals("")||jt3.getText().equals("")||jt4.getText().toString().equals("")||jt5.getText().toString().equals("")
					||jt6.getText().toString().equals("")||jt7.getText().toString().equals("")||jt8.getText().toString().equals("")
					||jt9.getText().toString().equals("")||jt10.getText().toString().equals(""))
			{
				JOptionPane.showMessageDialog(this,"������Ա����Ϣ!!");
			}
			else{
			eservice.addEmployee(jt1.getText().toString(),jt2.getText().toString(),jt3.getText().toString(),jt4.getText().toString(),
					jt5.getText().toString(),jt6.getText().toString(),jt7.getText().toString(),jt8.getText().toString(),
					jt9.getText().toString(),jt10.getText().toString());
			JOptionPane.showMessageDialog(this,"��ӳɹ�!!");
			this.dispose();
			}
					
	}
		else{
			this.dispose();
		}

	}}
