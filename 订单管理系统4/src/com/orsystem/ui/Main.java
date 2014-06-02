package com.orsystem.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;


import com.orsystem.DataService.CustomerService;
import com.orsystem.DataService.EmployeeService;
import com.orsystem.DataTable.Customer;
import com.orsystem.DataTable.Employee;
import com.orsystem.TableModal.CTableModal;
import com.orsystem.TableModal.ETableModal;
import com.orsystem.TableModal.PTableModal;

public class Main extends JFrame implements ActionListener{
	//���������Panel
	private JPanel MainPanel;
	//ѡ�Panel
	private JTabbedPane tabP;
	//�����ѡ����Panel
	private JPanel JP_fir,JP_em,JP_cm,JP_omm,JP_prm,JP_zhm;
	//**********Ա��ҳ���ֵ���Ϣ*****/////////////////
	//����һ����񣬴��Ա����Ϣ
	private JTable eTable;
	//����һ�����modal
	private ETableModal eTableModal;
	
	//Ա����Ϣ������
	EmployeeService eservice;
	//�������Ա����List
	List<Employee> eList;
	//���Ա����Ϣ��JTextField
	JTextField jt2_1,jt2_2,jt2_3,jt2_4,jt2_5,jt2_6,jt2_7,jt2_8,jt2_9,jt2_10;
	//���JTextField�Ƿ���Ա༭
	private boolean flag=false;
	//Ա������ҳ��������ť
	private JButton btn_change,btn_refresh,btn_add,btn_delete;
	
	////////////*******�ͻ�ҳ���ֵ���Ϣ**************//////////
	//**********Ա��ҳ���ֵ���Ϣ*****/////////////////
	//����һ����񣬴��Ա����Ϣ
	private JTable cTable;
	//����һ�����modal
	private CTableModal cTableModal;
	//Ա����Ϣ������
	CustomerService cservice;
	//�������Ա����List
	List<Customer> cList;
	//��ſͻ���Ϣ��JTextField
	JTextField jtc_1,jtc_2,jtc_3,jtc_4,jtc_5;
	//���JTextField�Ƿ���Ա༭
	private boolean cflag=false;
	//�ͻ�����ҳ��������ť
	private JButton cbtn_change,cbtn_refresh,cbtn_add,cbtn_delete;
	////////////*******Ա��ҳ���ֵ���Ϣ**************//////////

	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
	new Main();
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public Main() throws IOException, ClassNotFoundException, SQLException {
		
		
		this.setSize(850, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		this.setResizable(false);
		
		//�½���������Panel
		MainPanel=new JPanel();
		//��ӵ�JFrame
		getContentPane().add(MainPanel);
		//���ò��ָ�ʽ
		MainPanel.setLayout(new BorderLayout(0, 0));
		
		//����һ��ѡ�
		tabP = new JTabbedPane(JTabbedPane.TOP);
		
		//�����ҳ����JPanel
		 JP_fir = new JPanel();
		 tabP.addTab("��ҳ",JP_fir);
		
////****************************Ա������ҳ���ֵĴ���***************************//////////////		 
		 //���Ա������ҳ����JPnel
		JPanel JP_em = new JPanel();
		tabP.addTab("Ա������",JP_em);
		
		//��Ա������ҳ���һ����JPanel
		JPanel JP_emp = new JPanel();
		JP_em.add(JP_emp);
		JP_emp.setLayout(new BorderLayout(0, 0));
		
///////////**************************/////
///////////**Ա������������*********/////
		JPanel JP_emp1 = new JPanel();
		JP_emp.add(JP_emp1, BorderLayout.PAGE_START);
		JP_emp1.setLayout(new BorderLayout(0, 0));
		
		//��������Ƕ�׵ı�������
		JPanel jP_emp1_1 = new JPanel();
		JP_emp1.add(jP_emp1_1,BorderLayout.NORTH);
		jP_emp1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_4 = new JLabel("\u5458\u5DE5\u4FE1\u606F\u680F");
		lblNewLabel_4.setFont(new Font("����",Font.BOLD+Font.ITALIC,25));
		jP_emp1_1.add(lblNewLabel_4);
		
		//��������Ƕ�׵��в�����
		JPanel JP_emp1_2 = new JPanel();
		JP_emp1.add(JP_emp1_2,BorderLayout.CENTER);
		JP_emp1_2.setLayout(new BoxLayout(JP_emp1_2, BoxLayout.X_AXIS));
		
		JLabel Lb_dep = new JLabel("\u90E8\u95E8");
		
		JP_emp1_2.add(Lb_dep);
		
		JComboBox comboBox = new JComboBox();
		JP_emp1_2.add(comboBox);
		
		JLabel Lb_sex = new JLabel("\u6027\u522B");
		JP_emp1_2.add(Lb_sex);
		
		JComboBox comboBox_1 = new JComboBox();
		JP_emp1_2.add(comboBox_1);
		
		JLabel Lb_hs = new JLabel("\u804C\u52A1");
		JP_emp1_2.add(Lb_hs);
		
		JComboBox comboBox_2 = new JComboBox();
		JP_emp1_2.add(comboBox_2);
		
		JLabel Lb_sa = new JLabel("\u85AA\u6C34");
		JP_emp1_2.add(Lb_sa);
		
		JComboBox comboBox_3 = new JComboBox();
		JP_emp1_2.add(comboBox_3);
		
		//��������Ƕ�׵��ϲ�����
		JPanel JP_emp1_3 = new JPanel();
		JP_emp1.add(JP_emp1_3, BorderLayout.SOUTH);
		
		//ȡ������Ա����Ϣ
		eservice=new EmployeeService();
		eList=eservice.getAllEmployee();
		
		//�������Modal
		eTableModal=new ETableModal(eList);
		//�������
		eTable=new JTable();
		//���ñ��Modal
		eTable.setModel(eTableModal);
		//���õ����еĿ��
		eTable.getColumnModel().getColumn(5).setPreferredWidth(90); 
	    //����ÿһ�еĸ߶�
		eTable.setRowHeight(22);
		//��eTable����һ������¼�����������
		 eTable.addMouseListener(new java.awt.event.MouseAdapter(){
      	 public void mouseClicked(MouseEvent ev) {//������굥��ʱ��Ӧ
      		 //�õ�ѡ�е����е�����ֵ
      		int r= eTable.getSelectedRow();
      		Employee e=new Employee();
      		e=eList.get(r);
      		display(e.getEmployeeNo(),e.getEmployeeName(),e.getSex(),String.valueOf(e.getBirthday()),e.getAddress(),e.getTelephone()
      				,String.valueOf(e.getHireday()),e.getDepartment(),e.getHeadship(),String.valueOf(e.getSalary()));
//   			int c=	 eTable.getSelectedColumn();
//   		    //�õ�ѡ�еĵ�Ԫ���ֵ������ж����ַ���
//   			Object value= eTable.getValueAt(r, c);
//			 String info=r+"��"+c+"�� ֵ : "+value.toString();
//			 javax.swing.JOptionPane.showMessageDialog(null,info);
      	 }
       });
		//��ӱ��ScrollPane��
		JScrollPane scrollPane = new JScrollPane(eTable);
		scrollPane.setPreferredSize(new Dimension(800, 200));
		JP_emp1_3.add(scrollPane);
		
///////////**************************/////
///////////**Ա�������в�����*********/////
		JPanel JP_emp2 = new JPanel();
		JP_emp.add(JP_emp2, BorderLayout.PAGE_END);
		
		JP_emp2.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_emp2_1 = new JPanel();
		JP_emp2.add(JP_emp2_1);
		JP_emp2_1.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_emp2_1_1 = new JPanel();
		JP_emp2_1.add(JP_emp2_1_1, BorderLayout.NORTH);
		JP_emp2_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("\u5458\u5DE5\u4E2A\u4EBA\u4FE1\u606F\u7BA1\u7406");
		//��������
		label.setFont(new Font("����",Font.BOLD+Font.ITALIC,25));
		JP_emp2_1_1.add(label);
		
		JPanel JP_emp2_1_2 = new JPanel(new GridLayout(5,4));
	
		JLabel jl2_1=new JLabel("Ա����",JLabel.CENTER);
		JLabel jl2_2=new JLabel("Ա����",JLabel.CENTER);
		JLabel jl2_3=new JLabel("�Ա�",JLabel.CENTER);
		JLabel jl2_4=new JLabel("����",JLabel.CENTER);
		JLabel jl2_5=new JLabel("��ַ",JLabel.CENTER);
		JLabel jl2_6=new JLabel("�绰",JLabel.CENTER);
		JLabel jl2_7=new JLabel("��Ӷ����",JLabel.CENTER);
		JLabel jl2_8=new JLabel("����",JLabel.CENTER);
		JLabel jl2_9=new JLabel("ְ��",JLabel.CENTER);
		JLabel jl2_10=new JLabel("нˮ",JLabel.CENTER);
		 jt2_1=new JTextField();
		jt2_1.setFont(new Font("����",Font.BOLD+Font.ITALIC,20));
		jt2_1.setEditable(false);
		
		jt2_2=new JTextField();
		jt2_2.setFont(new Font("����",Font.BOLD+Font.ITALIC,20));
		jt2_2.setEditable(false);
		 jt2_3=new JTextField();
		jt2_3.setFont(new Font("����",Font.BOLD+Font.ITALIC,20));
		jt2_3.setEditable(false);
		 jt2_4=new JTextField();
		jt2_4.setFont(new Font("����",Font.BOLD+Font.ITALIC,20));
		jt2_4.setEditable(false);
		jt2_5=new JTextField();
		jt2_5.setFont(new Font("����",Font.BOLD+Font.ITALIC,20));
		jt2_5.setEditable(false);
		 jt2_6=new JTextField();
		jt2_6.setFont(new Font("����",Font.BOLD+Font.ITALIC,20));
		jt2_6.setEditable(false);
		jt2_7=new JTextField();
		jt2_7.setFont(new Font("����",Font.BOLD+Font.ITALIC,20));
		jt2_7.setEditable(false);
		 jt2_8=new JTextField();
		jt2_8.setFont(new Font("����",Font.BOLD+Font.ITALIC,20));
		jt2_8.setEditable(false);
		 jt2_9=new JTextField();
		jt2_9.setFont(new Font("����",Font.BOLD+Font.ITALIC,20));
		jt2_9.setEditable(false);
		 jt2_10=new JTextField();
		jt2_10.setFont(new Font("����",Font.BOLD+Font.ITALIC,20));
		jt2_10.setEditable(false);
		JP_emp2_1_2.add(jl2_1);
		JP_emp2_1_2.add(jt2_1);
		JP_emp2_1_2.add(jl2_2);
		JP_emp2_1_2.add(jt2_2);
		JP_emp2_1_2.add(jl2_3);
		JP_emp2_1_2.add(jt2_3);
		JP_emp2_1_2.add(jl2_4);
		JP_emp2_1_2.add(jt2_4);
		JP_emp2_1_2.add(jl2_5);
		JP_emp2_1_2.add(jt2_5);
		JP_emp2_1_2.add(jl2_6);
		JP_emp2_1_2.add(jt2_6);
		JP_emp2_1_2.add(jl2_7);
		JP_emp2_1_2.add(jt2_7);
		JP_emp2_1_2.add(jl2_8);
		JP_emp2_1_2.add(jt2_8);
		JP_emp2_1_2.add(jl2_9);
		JP_emp2_1_2.add(jt2_9);
		JP_emp2_1_2.add(jl2_10);
		JP_emp2_1_2.add(jt2_10);
		
		
		
		JP_emp2_1.add(JP_emp2_1_2, BorderLayout.CENTER);
		
		JPanel JP_emp2_1_3 = new JPanel();
		JP_emp2_1.add(JP_emp2_1_3, BorderLayout.SOUTH);
		
		btn_change = new JButton("\u4FEE\u6539");
		//Ϊ��ť���Ӽ����¼�
		btn_change.addActionListener(this);
		
		JP_emp2_1_3.add(btn_change);
		
		 btn_add = new JButton("\u65B0\u589E\u5458\u5DE5");
		//Ϊ��Ӱ�ť���ü����¼�
		 btn_add.addActionListener(this);
		 JP_emp2_1_3.add(btn_add);
		
		 btn_refresh = new JButton("\u5237\u65B0");
		//Ϊ��Ӱ�ť���ü����¼�
		 btn_refresh.addActionListener(this);
		JP_emp2_1_3.add(btn_refresh);
		
		
		
		 btn_delete = new JButton("\u5220\u9664\u5458\u5DE5");
		 //Ϊɾ����ť���ü����¼�
		 btn_delete.addActionListener(this);
		JP_emp2_1_3.add(btn_delete);
		
		
////////////////******************************************//////////////////////////////////
/********************Ա������ҳ�Ľ�������***************************************************/		
		 
		
		
	////****************************�ͻ�����ҳ���ֵĴ���***************************//////////////		 
		 //��ſͻ�����ҳ����JPnel
		JP_cm = new JPanel();
		tabP.add("�˿͹���", JP_cm);
		
		//���ͻ�����ҳ���һ����JPanel
		JPanel JP_cmp = new JPanel();
		JP_cm.add(JP_cmp);
		JP_cmp.setLayout(new BorderLayout(0, 0));
		
///////////**************************/////
///////////**�ͻ�����������*********/////
		JPanel JP_cmp1 = new JPanel();
		JP_cmp.add(JP_cmp1, BorderLayout.PAGE_START);
		JP_cmp1.setLayout(new BorderLayout(0, 0));
		
		//��������Ƕ�׵ı�������
		JPanel jP_cmp1_1 = new JPanel();
		JP_cmp1.add(jP_cmp1_1,BorderLayout.NORTH);
		jP_cmp1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_5 = new JLabel("�ͻ���Ϣ��");
		lblNewLabel_5.setFont(new Font("����",Font.BOLD+Font.ITALIC,25));
		jP_cmp1_1.add(lblNewLabel_5);
		
		//��������Ƕ�׵��в�����
		
		
		//��������Ƕ�׵��ϲ�����
		JPanel JP_cmp1_3 = new JPanel();
		JP_cmp1.add(JP_cmp1_3, BorderLayout.SOUTH);
		
		//ȡ�����пͻ���Ϣ
		cservice=new CustomerService();
		cList=cservice.getAllCustomer();
		
		//�������Modal
		cTableModal=new CTableModal(cList);
		//�������
		cTable=new JTable();
		//���ñ��Modal
		cTable.setModel(cTableModal);
		//���õ����еĿ��
		cTable.getColumnModel().getColumn(2).setPreferredWidth(90); 
	    //����ÿһ�еĸ߶�
		cTable.setRowHeight(22);
		//��eTable����һ������¼�����������
		 cTable.addMouseListener(new java.awt.event.MouseAdapter(){
     	 public void mouseClicked(MouseEvent ev) {//������굥��ʱ��Ӧ
     		 //�õ�ѡ�е����е�����ֵ
     		int r= cTable.getSelectedRow();
     		Customer c=new Customer();
     		c=cList.get(r);
     		cDisplay(c.getCustomerNo(),c.getCustomerName(),c.getAddress(),c.getTelephone(),c.getZip());

     	 }
      });
		//��ӱ��ScrollPane��
		JScrollPane scrollPane1 = new JScrollPane(cTable);
		scrollPane1.setPreferredSize(new Dimension(800, 200));
		JP_cmp1_3.add(scrollPane1);
		
///////////**************************/////
///////////**�ͻ������в�����*********/////
		JPanel JP_cmp2 = new JPanel();
		JP_cmp.add(JP_cmp2, BorderLayout.PAGE_END);
		
		JP_cmp2.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_cmp2_1 = new JPanel();
		JP_cmp2.add(JP_cmp2_1);
		JP_cmp2_1.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_cmp2_1_1 = new JPanel();
		JP_cmp2_1.add(JP_cmp2_1_1, BorderLayout.NORTH);
		JP_cmp2_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel clabel = new JLabel("�ͻ�������Ϣ����");
		//��������
		clabel.setFont(new Font("����",Font.BOLD+Font.ITALIC,25));
		JP_cmp2_1_1.add(clabel);
		
		JPanel JP_cmp2_1_2 = new JPanel(new GridLayout(5,2));
	
		JLabel jlc_1=new JLabel("�ͻ���",JLabel.CENTER);
		JLabel jlc_2=new JLabel("�ͻ���",JLabel.CENTER);
		JLabel jlc_3=new JLabel("��ַ",JLabel.CENTER);
		JLabel jlc_4=new JLabel("�绰",JLabel.CENTER);
		JLabel jlc_5=new JLabel("�ʱ�",JLabel.CENTER);
		
		 jtc_1=new JTextField();
		jtc_1.setFont(new Font("����",Font.BOLD+Font.ITALIC,20));
		jtc_1.setEditable(false);
		
		jtc_2=new JTextField();
		jtc_2.setFont(new Font("����",Font.BOLD+Font.ITALIC,20));
		jtc_2.setEditable(false);
		 jtc_3=new JTextField();
		jtc_3.setFont(new Font("����",Font.BOLD+Font.ITALIC,20));
		jtc_3.setEditable(false);
		 jtc_4=new JTextField();
		jtc_4.setFont(new Font("����",Font.BOLD+Font.ITALIC,20));
		jtc_4.setEditable(false);
		jtc_5=new JTextField();
		jtc_5.setFont(new Font("����",Font.BOLD+Font.ITALIC,20));
		jtc_5.setEditable(false);
		
		JP_cmp2_1_2.add(jlc_1);
		JP_cmp2_1_2.add(jtc_1);
		JP_cmp2_1_2.add(jlc_2);
		JP_cmp2_1_2.add(jtc_2);
		JP_cmp2_1_2.add(jlc_3);
		JP_cmp2_1_2.add(jtc_3);
		JP_cmp2_1_2.add(jlc_4);
		JP_cmp2_1_2.add(jtc_4);
		JP_cmp2_1_2.add(jlc_5);
		JP_cmp2_1_2.add(jtc_5);
		
		
		
		
		JP_cmp2_1.add(JP_cmp2_1_2, BorderLayout.CENTER);
		
		JPanel JP_cmp2_1_3 = new JPanel();
		JP_cmp2_1.add(JP_cmp2_1_3, BorderLayout.SOUTH);
		
		cbtn_change = new JButton("\u4FEE\u6539");
		//Ϊ��ť���Ӽ����¼�
		cbtn_change.addActionListener(this);
		
		JP_cmp2_1_3.add(cbtn_change);
		
		 cbtn_add = new JButton("���ӿͻ�");
		//Ϊ��Ӱ�ť���ü����¼�
		 cbtn_add.addActionListener(this);
		 JP_cmp2_1_3.add(cbtn_add);
		
		 cbtn_refresh = new JButton("\u5237\u65B0");
		//Ϊ��Ӱ�ť���ü����¼�
		 cbtn_refresh.addActionListener(this);
		JP_cmp2_1_3.add(cbtn_refresh);
		
		
		
		 cbtn_delete = new JButton("ɾ���ͻ�");
		 //Ϊɾ����ť���ü����¼�
		 cbtn_delete.addActionListener(this);
		JP_cmp2_1_3.add(cbtn_delete);
		
		
////////////////******************************************//////////////////////////////////
/********************�˿͹���ҳ�Ľ�������***************************************************/			
		 JP_omm = new JPanel();
		tabP.add("��������",  JP_omm);
		
		 JP_prm = new JPanel();
		tabP.add("��Ʒ����", JP_prm);
		
		MainPanel.add(tabP);
		
		 JP_zhm = new JPanel();
		tabP.add("�˺Ź���",  JP_zhm);
	}
	///**************Ա��ҳ��������**********//////
	//ˢ��Ա�����ķ���
	public void reeTable() throws IOException, ClassNotFoundException, SQLException{
		eList=eservice.getAllEmployee();
		/**���±����Ϣ***/
		//�������Modal
		eTableModal=new ETableModal(eList);
		//���ñ��Modal
		eTable.setModel(eTableModal);
	}
	//����JTextField������ʾԱ����Ϣ�ķ���
	public void display(String employeeNo,String employeeName,String sex,String birthday,String address,
			String telephone,String hiredate,String department,String headship,String salary){
		jt2_1.setText(employeeNo);
		jt2_2.setText(employeeName);
		jt2_3.setText(sex);
		jt2_4.setText(birthday);
		jt2_5.setText(address);
		jt2_6.setText(telephone);
		jt2_7.setText(hiredate);
		jt2_8.setText(department);
		jt2_9.setText(headship);
		jt2_10.setText(salary);
		
	}
	//��ȡJTextField����Ա����Ϣ�ķ���
	public Employee getMsg(){
		Employee e=new Employee();
		e.setEmployeeNo(jt2_1.getText().toString());
		e.setEmployeeName(jt2_2.getText().toString());
		e.setSex(jt2_3.getText().toString());
		e.setBirthday(Date.valueOf(jt2_4.getText().toString()));
		e.setAddress(jt2_5.getText().toString());
		e.setTelephone(jt2_6.getText().toString());
		e.setHireday(Date.valueOf(jt2_7.getText().toString()));
		e.setDepartment(jt2_8.getText().toString());
		e.setHeadship(jt2_9.getText().toString());
		e.setSalary(Float.valueOf(jt2_10.getText().toString()));
		
		
		return e;
		
	}
	//����ʾԱ����Ϣ���ı�������ʾ�ɿɱ༭�򲻿ɱ༭��
	public void setEdited(){
		//����ԭ�����ɱ༭����ʾ�ɿɱ༭��,������ʾ�ɲ��ɱ༭��
		if(flag==false){
		
		jt2_5.setEditable(true);
		jt2_6.setEditable(true);
		jt2_7.setEditable(true);
		jt2_8.setEditable(true);
		jt2_9.setEditable(true);
		jt2_10.setEditable(true);
		flag=true;
		}
		else{
			
			jt2_5.setEditable(false);
			jt2_6.setEditable(false);
			jt2_7.setEditable(false);
			jt2_8.setEditable(false);
			jt2_9.setEditable(false);
			jt2_10.setEditable(false);
			flag=false;
		}
	}
	//*********Ա��ҳ������������***/////////////////////
	///**************�ͻ�ҳ��������**********//////
	//ˢ�¿ͻ����ķ���
	public void recTable() throws IOException, ClassNotFoundException, SQLException{
		cList=cservice.getAllCustomer();
		/**���±����Ϣ***/
		//�������Modal
		cTableModal=new CTableModal(cList);
		//���ñ��Modal
		cTable.setModel(cTableModal);
	}
	//����JTextField������ʾ�ͻ���Ϣ�ķ���
	public void cDisplay(String customerNo,String customerName,String address,String tel,String zip){
		jtc_1.setText(customerNo);
		jtc_2.setText(customerName);
		jtc_3.setText(address);
		jtc_4.setText(tel);
		jtc_5.setText(zip);
	
		
	}
	//��ȡJTextField����ͻ���Ϣ�ķ���
	public Customer getcMsg(){
		Customer c=new Customer();
	c.setCustomerNo(jtc_1.getText().toString());
	c.setCustomerName(jtc_2.getText().toString());
	c.setAddress(jtc_3.getText().toString());
	c.setTelephone(jtc_4.getText().toString());
	c.setZip(jtc_5.getText().toString());
		return c;
		
	}
	//����ʾ�ͻ���Ϣ���ı�������ʾ�ɿɱ༭�򲻿ɱ༭��
	public void setcEdited(){
		//����ԭ�����ɱ༭����ʾ�ɿɱ༭��,������ʾ�ɲ��ɱ༭��
		if(cflag==false){
		jtc_2.setEditable(true);
		jtc_3.setEditable(true);
		jtc_4.setEditable(true);
		jtc_5.setEditable(true);
	
		cflag=true;
		}
		else{
			jtc_2.setEditable(false);
			jtc_3.setEditable(false);
			jtc_4.setEditable(false);
			jtc_5.setEditable(false);
			cflag=false;
		}
	}
	////**�ͻ�ҳ������������****//////////////
	
	/////***********������������*****////////////
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//����û�����޸�
		if(arg0.getSource()==btn_change)
		{
			if(btn_change.getText().equals("�޸�")){
			setEdited();
			btn_change.setText("���");
		}
			else{
				setEdited();
				Employee e=new Employee();
				e=getMsg();
				try {
					eservice.update(e);
					//ˢ�±��
					reeTable();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				btn_change.setText("�޸�");
			}
			
			
		}
		else if(arg0.getSource()==btn_add){
			new EmployeeAdd();
		}
		else if(arg0.getSource()==btn_refresh){
			try {
				reeTable();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(arg0.getSource()==btn_delete){
			Employee e=new Employee();
			e=getMsg();
			eservice.deleteEmployeeById(e.getEmployeeNo());
			//***���±��**////
			try {
				reeTable();
				JOptionPane.showMessageDialog(this,"ɾ���ɹ�!!");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		else if(arg0.getSource()==cbtn_change){
			if(cbtn_change.getText().equals("�޸�")){
				setcEdited();
				cbtn_change.setText("���");
			}
				else{
					setcEdited();
					Customer c=new Customer();
					c=getcMsg();
					try {
						cservice.update(c);
						//ˢ�±��
						recTable();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					cbtn_change.setText("�޸�");
				}
				
		}
		else if(arg0.getSource()==cbtn_change){
			if(cbtn_change.getText().equals("�޸�")){
				setcEdited();
				cbtn_change.setText("���");
			}
				else{
					setcEdited();
					Customer c=new Customer();
					c=getcMsg();
					try {
						cservice.update(c);
						//ˢ�±��
						recTable();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					cbtn_change.setText("�޸�");
				}
				
		}
		
		else if(arg0.getSource()==cbtn_add){
			new CustomerAdd();
				
		}
		else if(arg0.getSource()==cbtn_refresh){
			try {
				recTable();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		else if(arg0.getSource()==cbtn_delete){
			Customer c=new Customer();
			c=getcMsg();
			cservice.deleteCustomerById(c.getCustomerNo());
			//***���±��**////
			try {
				recTable();
				JOptionPane.showMessageDialog(this,"ɾ���ɹ�!!");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
	}
	
	
	
}
