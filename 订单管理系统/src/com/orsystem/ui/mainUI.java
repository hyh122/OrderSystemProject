package com.orsystem.ui;
/**

 * ����:��������ϵͳ����
 */

import java.io.*;
import java.sql.Connection;
import java.util.Date;

import javax.swing.*;



import java.awt.*;
import java.awt.event.*;

public class mainUI extends JFrame implements ActionListener{
	

	
	//�����в���Ҫ�����
	//.�в������JPanel,��һ����ѡ����ڹ���
	JTabbedPane jtp;//ѡ�
	//�������JPanel�ֱ�Ϊ��ҳ,Ա�������ͻ���������������Ʒ�����˺Ź���
	JPanel jp_main,jp_em,jp_cm,jp_omm,jp_pm,jp_zm;
	//Ա������panel�������panel
	JPanel jp_em_jp1,jp_em_jp2;
	JPanel je2_jp1,je2_jp2,je2_jp3;
	JScrollPane je2_jsp;
	JLabel jl_em_show,jl_em_menu;
	JTable je2_table;
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mainUI qqClientLogin=new mainUI();//�½�һ��QqClientLogin�࣬�޲����Ĺ��캯��
	}
	
	public mainUI()//��QqClientLogin�Ĺ��캯��
	{
		Toolkit tk=Toolkit.getDefaultToolkit();
		Image img=tk.getImage("image/C.gif");
		this.setIconImage(img);
		
	
		 
	//��ʼ��JPanel���
		jp_main=new JPanel();
		jp_em=new JPanel();
		jp_cm=new JPanel();
		jp_omm=new JPanel();
		jp_pm=new JPanel();
		jp_zm=new JPanel();
	//��ʼ��Ա������������panel
		jp_em_jp1=new JPanel();
		jp_em_jp2=new JPanel();
	//��jp_em_jp2���ӽ����ʼ��
		je2_jp1=new JPanel();
		je2_jp2=new JPanel();
		je2_jp3=new JPanel();
		
		//�����ά������Ϊ�������     
		Object[][] tableData =       
			{          new Object[]{"","","","","","","","","",""},          
				new Object[]{"","","","","","","","","",""},          
				new Object[]{"","","","","","","","","",""},          
				new Object[]{"","","","","","","","","",""},  
			};      
		//����һά������Ϊ�б���     
		Object[] columnTitle = {"Ա����" , "Ա����" , "�Ա�","��������","��ַ","�绰����","��Ӷ����" +
				"����","ְλ","нˮ"};    
		//�Զ�ά�����һά����������һ��JTable����         
		je2_table = new JTable(tableData , columnTitle); 
		
		  
		JSplitPane splitPane = new JSplitPane ();//����һ���ָ�������
		  splitPane.setOneTouchExpandable (true); //�÷ָ�����ʾ����ͷ
		//  splitPane.setContinuousLayout (true); //���û������ָ��߼�ͷʱ��ϵͳ���ػ�ͼ��
		  splitPane.setPreferredSize (new Dimension (850,660));
		  splitPane.setOrientation (JSplitPane.HORIZONTAL_SPLIT); //���÷ָ���Ϊˮƽ�ָ���
		  splitPane.setLeftComponent (jp_em_jp1); //��b1�ŵ��ָ�����ߣ���b2�ŵ��ָ����ұ�
		  splitPane.setRightComponent (jp_em_jp2);
		  splitPane.setDividerSize (8); //���÷ָ��ߴ�СΪ3����λ
		  splitPane.setDividerLocation(200); //���÷ָ��ߵ�λ��λ���м�
		 
		  
		  jp_em.add(splitPane);
		  
		 
		
		//�����ʾ�˵�
			jl_em_menu=new JLabel("Ա������");
		//��ӭ��ǩ
		
		jl_em_show=new JLabel("����Ա���������");
		JLabel jl_em_show2=new JLabel("����Ա���������");
		je2_jp1.add(jl_em_show);
		je2_jp2.add(jl_em_show2);
		je2_jsp=new JScrollPane(je2_table);
		je2_jp3.add(je2_jsp);
		//��ӵ�jp_em_jp1
		jp_em_jp1.add(jl_em_menu);
		//��ӵ�jp_em_jp2
		jp_em_jp2.add(je2_jp1,BorderLayout.NORTH);
		jp_em_jp2.add(je2_jp2,BorderLayout.CENTER);
		jp_em_jp2.add(je2_jp3,BorderLayout.SOUTH);

		
		
	
		//����ѡ�����
		jtp=new JTabbedPane();
		jtp.add("��ҳ",jp_main);
		jtp.add("Ա������",jp_em);
		jtp.add("�ͻ�����",jp_cm);
		jtp.add("��������",jp_omm);
		jtp.add("��Ʒ����",jp_pm);
		jtp.add("�˺Ź���",jp_zm);
		
		
		
		
		this.add(jtp,"Center");
	
		this.setSize(850, 660);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);//ʹ��ܲ�������
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//����û������¼
//		if(arg0.getSource()==jp1_jb1)
//		{
//			
//		}
//			else if(arg0.getSource()==jp1_jb2){
//				//�رյ���¼����
//				this.dispose();
//			}
//			else if(arg0.getSource()==jp1_jb3){
//				
//			}
		}
	}


