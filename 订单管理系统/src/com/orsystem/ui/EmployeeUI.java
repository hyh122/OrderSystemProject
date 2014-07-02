package com.orsystem.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import java.util.List;

import javax.swing.JTextField;
import javax.swing.JScrollPane;

import com.orsystem.DataTable.Employee;
import com.orsystem.Modal.cHistoryOrder;
import com.orsystem.TableModal.EhoTableModal;
import com.orsystem.control.EUI_Control;
import com.tecService.DataClassChange;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EmployeeUI extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField JT_eno;
	private JTextField JT_ename;
	private JTextField JT_esex;
	private JTextField JT_ebirthday;
	private JTextField JT_eaddress;
	private JTextField JT_etelephone;
	private JTextField JT_ehiredate;
	private JTextField JT_edepartment;
	private JTextField JT_eheadship;
	private JTextField JT_esalary;
	
	private int flag=1;
	private Employee e;
	private JButton btn_NoDoOrder,btn_eHisOrder,btn_doOrder,btn_changeMsg,btn_changeP,btn_exit,btn_dataCount;
	private String employeeno;
	//��ʾԱ����ʷ����Ķ����ı��
	private JTable eoTable;
	//���Modal
	private EhoTableModal ehoTableModal;
	//control��
	private EUI_Control control;
	//��Ź��ﳵ������modal����
	private List<cHistoryOrder> ehoList;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		new EmployeeUI("E2005003");
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public EmployeeUI(String employeeno) throws IOException, ClassNotFoundException, SQLException {
		getContentPane().setBackground(new Color(102, 255, 255));
		
		//ʵ����������
		control=new EUI_Control();
		e=new Employee();
		this.employeeno=employeeno;
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\u4E2A\u4EBA\u4FE1\u606F\u680F");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 28));
		lblNewLabel_2.setBounds(314, 65, 150, 30);
		getContentPane().add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(116, 105, 604, 160);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(5,4));
		//�õ���Ա������Ϣ
		e=control.getMsgOfEmployeeno(employeeno);
		
		JLabel lblNewLabel_4 = new JLabel("\u5458\u5DE5\u53F7",JLabel.CENTER);
		panel.add(lblNewLabel_4);
		
		JT_eno= new JTextField(e.getEmployeeNo());
		panel.add(JT_eno);
		JT_eno.setColumns(10);
		JT_eno.setEditable(false);
		
		JLabel lblNewLabel_3 = new JLabel("\u5458\u5DE5\u540D",JLabel.CENTER);
		panel.add(lblNewLabel_3);
		
		JT_ename = new JTextField(e.getEmployeeName());
		panel.add(JT_ename);
		JT_ename.setColumns(10);
		JT_ename.setEditable(false);
		
		JLabel lblNewLabel_5 = new JLabel("\u6027\u522B",JLabel.CENTER);
		panel.add(lblNewLabel_5);
		
		JT_esex = new JTextField(e.getSex());
		panel.add(JT_esex );
		JT_esex.setColumns(10);
		JT_esex.setEditable(false);
		
		JLabel lblNewLabel_6 = new JLabel("\u751F\u65E5\u65E5\u671F",JLabel.CENTER);
		panel.add(lblNewLabel_6);
		
		JT_ebirthday = new JTextField(String.valueOf(e.getBirthday()));
		panel.add(JT_ebirthday );
		JT_ebirthday .setColumns(10);
		JT_ebirthday.setEditable(false);
		
		JLabel lblNewLabel_7 = new JLabel("\u5730\u5740",JLabel.CENTER);
		panel.add(lblNewLabel_7);
		
		JT_eaddress = new JTextField(e.getAddress());
		panel.add(JT_eaddress);
		JT_eaddress.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\u7535\u8BDD\u53F7\u7801",JLabel.CENTER);
		panel.add(lblNewLabel_8);
		
		JT_etelephone = new JTextField(e.getTelephone());
		panel.add(JT_etelephone);
		JT_etelephone.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("\u96C7\u4F63\u65E5\u671F",JLabel.CENTER);
		panel.add(lblNewLabel_9);
		
		JT_ehiredate = new JTextField(String.valueOf(e.getHireday()));
		panel.add(JT_ehiredate);
		JT_ehiredate.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("\u90E8\u95E8",JLabel.CENTER);
		panel.add(lblNewLabel_10);
		
		JT_edepartment= new JTextField(e.getDepartment());
		panel.add(JT_edepartment);
		JT_edepartment.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("\u804C\u4F4D",JLabel.CENTER);
		panel.add(lblNewLabel_11);
		
		JT_eheadship = new JTextField(e.getHeadship());
		panel.add(JT_eheadship);
		JT_eheadship.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("\u5DE5\u8D44",JLabel.CENTER);
		panel.add(lblNewLabel_12);
		
		JT_esalary = new JTextField(String.valueOf(e.getSalary()));
		panel.add(JT_esalary);
		JT_esalary.setColumns(10);
		//��JT_Field����Ϊ���ɱ༭��
		setEdited();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 255, 255));
		panel_1.setBounds(77, 376, 689, 202);
		getContentPane().add(panel_1);
		
		
		//�õ���ʷ����
		ehoList=control.gethistoryorder(employeeno);
		//�������Modal
		ehoTableModal=new EhoTableModal(ehoList);
		//�������
		eoTable=new JTable();
		//���ñ��Modal
		eoTable.setModel(ehoTableModal);
		//�����еĿ��
		eoTable.getColumnModel().getColumn(1).setPreferredWidth(100); 
	    //����ÿһ�еĸ߶�
		eoTable.setRowHeight(25);
		JScrollPane scrollPane = new JScrollPane(eoTable);
		scrollPane.setPreferredSize(new Dimension(670, 190));
		panel_1.add(scrollPane);
		
		//��ʾδ�������İ�ť
		 btn_NoDoOrder = new JButton("\u672A\u53D7\u7406\u8BA2\u5355\u5217\u8868");
		btn_NoDoOrder.setFont(new Font("����", Font.PLAIN, 18));
		btn_NoDoOrder.setBounds(107, 331, 173, 35);
		//���ü����¼�
		btn_NoDoOrder.addActionListener(this);
		getContentPane().add(btn_NoDoOrder);
		
		//��ʾ��ʷ�����İ�ť
		btn_eHisOrder = new JButton("\u5386\u53F2\u8BA2\u5355\u5217\u8868");
		btn_eHisOrder.addActionListener(this); 
		
		btn_eHisOrder.setFont(new Font("����", Font.PLAIN, 18));
		btn_eHisOrder.setBounds(519, 331, 150, 35);
		getContentPane().add(btn_eHisOrder);
		
		btn_changeMsg = new JButton("\u4FEE\u6539");
		btn_changeMsg.setFont(new Font("����", Font.PLAIN, 15));
		btn_changeMsg.setBounds(589, 65, 76, 35);
		getContentPane().add(btn_changeMsg);
		//���ü���
		btn_changeMsg.addActionListener(this);
		
		//�������İ�ť
		btn_doOrder = new JButton("\u53D7\u7406\u8BA2\u5355");
		btn_doOrder.setFont(new Font("����", Font.PLAIN, 15));
		btn_doOrder.setBounds(178, 588, 102, 30);
		//�տ�ʼ��ʾ���ɼ�
		btn_doOrder.setVisible(false);
		//���ü���
		btn_doOrder.addActionListener(this);
		getContentPane().add(btn_doOrder);
		
		JLabel lblNewLabel_13 = new JLabel("\u8BA2\u5355\u5904\u7406\u680F");
		lblNewLabel_13.setFont(new Font("����", Font.PLAIN, 28));
		lblNewLabel_13.setBounds(314, 290, 163, 36);
		getContentPane().add(lblNewLabel_13);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(153, 255, 255));
		panel_2.setBounds(0, 0, 845, 55);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel LB_employeeno = new JLabel("employeeno");
		LB_employeeno.setBounds(31, 9, 100, 31);
		LB_employeeno.setFont(new Font("����", Font.PLAIN, 20));
		LB_employeeno.setText(employeeno);
		panel_2.add(LB_employeeno);
		
		JLabel label_1 = new JLabel("\u60A8\u597D\uFF0C\u6B22\u8FCE\u767B\u5F55!");
		label_1.setBounds(128, 7, 202, 31);
		label_1.setFont(new Font("����", Font.PLAIN, 25));
		panel_2.add(label_1);
		
		 btn_exit = new JButton("\u9000\u51FA");
		btn_exit.setFont(new Font("����", Font.PLAIN, 20));
		btn_exit.setBounds(731, 3, 93, 37);
		btn_exit.addActionListener(this);
		panel_2.add(btn_exit);
		
		btn_changeP = new JButton("\u4FEE\u6539\u5BC6\u7801");
		btn_changeP.addActionListener(this);
		
		btn_changeP.setFont(new Font("����", Font.PLAIN, 20));
		btn_changeP.setBounds(600, 3, 121, 37);
		panel_2.add(btn_changeP);
		
		btn_dataCount = new JButton("\u4E1A\u52A1\u7EDF\u8BA1");
		btn_dataCount.addActionListener(this);
			
		btn_dataCount.setFont(new Font("����", Font.PLAIN, 15));
		btn_dataCount.setBounds(561, 588, 108, 30);
		getContentPane().add(btn_dataCount);
		
		this.setSize(861, 675);
		
		this.setVisible(true);
		this.setResizable(false);
		
		
	}
	//��JTextField��Ϊ���ɱ༭��ɱ༭��
	public void setEdited(){
		if(flag==0){
			
			JT_eaddress.setEditable(true);
			
			JT_edepartment.setEditable(true);
			JT_eheadship.setEditable(true);
			JT_ehiredate.setEditable(true);
			
			JT_esalary.setEditable(true);
			JT_etelephone.setEditable(true);
			flag=1;
		}
		else{
			
			JT_eaddress.setEditable(false);
			
			JT_edepartment.setEditable(false);
			JT_eheadship.setEditable(false);
			JT_ehiredate.setEditable(false);
			
			JT_esalary.setEditable(false);
			JT_etelephone.setEditable(false);
			flag=0;
		}
	}
	//�õ��ı������Ϣ
	public Employee getMsg(){
		Employee e=new Employee();
		e.setEmployeeNo(JT_eno.getText().toString());
		e.setEmployeeName(JT_ename.getText().toString());
		e.setSex(JT_esex.getText().toString());
		e.setBirthday(Date.valueOf(JT_ebirthday.getText()));
		e.setAddress(JT_eaddress.getText());
		e.setTelephone(JT_etelephone.getText());
		e.setHireday(Date.valueOf(JT_ehiredate.getText()));
		e.setDepartment(JT_edepartment.getText());
		e.setHeadship(JT_eheadship.getText());
		e.setSalary(Float.valueOf(JT_esalary.getText()));
		
		return e;
	}
	//ˢ���б�
	public void reTable() throws IOException, ClassNotFoundException, SQLException{
		ehoList=control.getNoDoOrder(employeeno);
		ehoTableModal=new EhoTableModal(ehoList);
		eoTable.setModel(ehoTableModal);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//�������ʾ��Ա����ʷ����Ķ���
		if(e.getSource()==btn_eHisOrder){
			try {
				ehoList=control.gethistoryorder(employeeno);
				ehoTableModal=new EhoTableModal(ehoList);
				eoTable.setModel(ehoTableModal);
				//ʹ�������İ�ť���ɼ�
				btn_doOrder.setVisible(false);
				btn_dataCount.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
		//�������ʾ��Ա����û����Ķ���
		else if(e.getSource()==btn_NoDoOrder){
			try {
				ehoList=control.getNoDoOrder(employeeno);
				ehoTableModal=new EhoTableModal(ehoList);
				eoTable.setModel(ehoTableModal);
				//ʹ�������İ�ť�ɼ�
				btn_doOrder.setVisible(true);
				btn_dataCount.setVisible(false);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
		//�������Ϊ����Ķ���
		else if(e.getSource()==btn_doOrder){
			try {
				if(ehoList.size()==0){
				JOptionPane.showMessageDialog(this,"û��û����Ķ���!!");
				}
				else{
				control.addEmployeeNoToOM(employeeno);
				
				JOptionPane.showMessageDialog(this,"��������ɹ�!!");
				//ˢ���б�
				reTable();
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
		//�������Ϊ����Ķ���
		else if(e.getSource()==btn_changeMsg){
			if(flag==0){
			//��Ϊ�ɱ༭��
			setEdited();
			
			
			btn_changeMsg.setText("���");
			}
			else{
				//��Ϊ�ɱ༭��
				setEdited();
				
				Employee emp=new Employee();
				emp=getMsg();
				//����Ա����Ϣ
				control.update(emp);
				JOptionPane.showMessageDialog(this, "��Ϣ�޸ĳɹ�");
				btn_changeMsg.setText("�޸�");
				}
			}
		else if(e.getSource()==btn_changeP){
			new changePasswdUI("Employee",employeeno);
		}
		else if(e.getSource()==btn_exit){
			this.dispose();
		}
		else if(e.getSource()==btn_dataCount){
			new EDataCountUI(employeeno);
		}
	}
	

}
