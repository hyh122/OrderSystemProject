/**
 * ����:qq�ͻ��˵�¼����
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
	//�������Ա������
	private ManagerService managerservice;
	//���山����Ҫ�����
	//Download by http://www.codefans.net
	JLabel jbl1;
	private JPanel MainPanel;
	//�����в���Ҫ�����
	JPanel jp2,jp3,jp4;
	JLabel jp2_jlb_id,jp2_jlb_pw,jp2_jbl3,jp2_jbl4;
	
	JTextField jp2_jtf_id;
	JPasswordField jp2_jpf_pw;
//	JCheckBox jp2_jcb1,jp2_jcb2;
	
	
	
	//�����ϲ���Ҫ�����
	JPanel jp1;
	JButton jp1_jb1,jp1_jb2,jp1_jb3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login qqClientLogin=new Login();//�½�һ��QqClientLogin�࣬�޲����Ĺ��캯��
	}
	
	public Login()//��QqClientLogin�Ĺ��캯��
	{
		//��ʼ��managerService����
		managerservice=new ManagerService();
		Toolkit tk=Toolkit.getDefaultToolkit();
		Image img=tk.getImage("image/C.gif");
		this.setIconImage(img);
	//��ʼ�������
		MainPanel=new JPanel();
		MainPanel.setBackground(Color.LIGHT_GRAY);
		//������
		jbl1=new JLabel(new ImageIcon("image/tou.gif"));
		
		//�����в�
		jp2=new JPanel(new GridLayout(3,2));//���������ָ���ļ��м��и��ֿ���������������ʱ���ᰴ����ӵ�˳�򰤸���ӵ��������
		
		jp2_jlb_id=new JLabel("�û���",JLabel.CENTER);
		jp2_jlb_pw=new JLabel("����",JLabel.CENTER);
		
		//jp2_jbl3.setForeground(Color.red);//����������ɫ
		
		//jp2_jb1=new JButton(new ImageIcon("image/clear.gif"));
		jp2_jtf_id=new JTextField();
		jp2_jpf_pw=new JPasswordField();
		
		
//		jp2_jcb1=new JCheckBox("�����¼");
//		jp2_jcb2=new JCheckBox("��ס����");
		
		//�ѿؼ�����˳����뵽jp2
		jp2.add(jp2_jlb_id);
		jp2.add(jp2_jtf_id);
		jp2.add(jp2_jlb_pw);
		jp2.add(jp2_jpf_pw);
//	
//		jp2.add(jp2_jcb1);
//		jp2.add(jp2_jcb2);
		
	
		
		//�����ϲ�
		jp1=new JPanel();
		jp1_jb1=new JButton(new ImageIcon("image/denglu.gif"));
		//��Ӧ�û������¼
		jp1_jb1.addActionListener(this);
		jp1_jb2=new JButton(new ImageIcon("image/quxiao.gif"));
		//��Ӧ�û�ȡ����¼
		jp1_jb2.addActionListener(this);
		jp1_jb3=new JButton(new ImageIcon("image/xiangdao.gif"));
		//��Ӧ�û�ע���¼
		jp1_jb3.addActionListener(this);
		
		//��������ť���뵽jp1
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
		this.setResizable(false);//ʹ��ܲ�������
	}

	public void actionPerformed(ActionEvent arg0){
		
		if(arg0.getSource()==jp1_jb1)
		{
			
			try {
				if(managerservice.queryManagerById1(jp2_jtf_id.getText().toString().trim())){
					JOptionPane.showMessageDialog(this,"��¼�ɹ�");
				}
				else
				{	//JOptionPane.showMessageDialog(this,"��¼ʧ��");
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


