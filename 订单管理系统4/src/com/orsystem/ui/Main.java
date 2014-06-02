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
	//主界面的主Panel
	private JPanel MainPanel;
	//选项卡Panel
	private JTabbedPane tabP;
	//存放在选项卡里的Panel
	private JPanel JP_fir,JP_em,JP_cm,JP_omm,JP_prm,JP_zhm;
	//**********员工页部分的信息*****/////////////////
	//建立一个表格，存放员工信息
	private JTable eTable;
	//建立一个表格modal
	private ETableModal eTableModal;
	
	//员工信息服务类
	EmployeeService eservice;
	//存放所有员工的List
	List<Employee> eList;
	//存放员工信息的JTextField
	JTextField jt2_1,jt2_2,jt2_3,jt2_4,jt2_5,jt2_6,jt2_7,jt2_8,jt2_9,jt2_10;
	//标记JTextField是否可以编辑
	private boolean flag=false;
	//员工管理页的三个按钮
	private JButton btn_change,btn_refresh,btn_add,btn_delete;
	
	////////////*******客户页部分的信息**************//////////
	//**********员工页部分的信息*****/////////////////
	//建立一个表格，存放员工信息
	private JTable cTable;
	//建立一个表格modal
	private CTableModal cTableModal;
	//员工信息服务类
	CustomerService cservice;
	//存放所有员工的List
	List<Customer> cList;
	//存放客户信息的JTextField
	JTextField jtc_1,jtc_2,jtc_3,jtc_4,jtc_5;
	//标记JTextField是否可以编辑
	private boolean cflag=false;
	//客户管理页的三个按钮
	private JButton cbtn_change,cbtn_refresh,cbtn_add,cbtn_delete;
	////////////*******员工页部分的信息**************//////////

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
		
		//新建主界面主Panel
		MainPanel=new JPanel();
		//添加到JFrame
		getContentPane().add(MainPanel);
		//设置布局格式
		MainPanel.setLayout(new BorderLayout(0, 0));
		
		//定义一个选项卡
		tabP = new JTabbedPane(JTabbedPane.TOP);
		
		//存放首页的主JPanel
		 JP_fir = new JPanel();
		 tabP.addTab("首页",JP_fir);
		
////****************************员工管理页部分的代码***************************//////////////		 
		 //存放员工管理页的主JPnel
		JPanel JP_em = new JPanel();
		tabP.addTab("员工管理",JP_em);
		
		//往员工管理页添加一个主JPanel
		JPanel JP_emp = new JPanel();
		JP_em.add(JP_emp);
		JP_emp.setLayout(new BorderLayout(0, 0));
		
///////////**************************/////
///////////**员工管理北部布局*********/////
		JPanel JP_emp1 = new JPanel();
		JP_emp.add(JP_emp1, BorderLayout.PAGE_START);
		JP_emp1.setLayout(new BorderLayout(0, 0));
		
		//北部布局嵌套的北部布局
		JPanel jP_emp1_1 = new JPanel();
		JP_emp1.add(jP_emp1_1,BorderLayout.NORTH);
		jP_emp1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_4 = new JLabel("\u5458\u5DE5\u4FE1\u606F\u680F");
		lblNewLabel_4.setFont(new Font("宋体",Font.BOLD+Font.ITALIC,25));
		jP_emp1_1.add(lblNewLabel_4);
		
		//北部布局嵌套的中部布局
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
		
		//北部布局嵌套的南部布局
		JPanel JP_emp1_3 = new JPanel();
		JP_emp1.add(JP_emp1_3, BorderLayout.SOUTH);
		
		//取出所有员工信息
		eservice=new EmployeeService();
		eList=eservice.getAllEmployee();
		
		//创建表格Modal
		eTableModal=new ETableModal(eList);
		//创建表格
		eTable=new JTable();
		//设置表格Modal
		eTable.setModel(eTableModal);
		//设置第六列的宽度
		eTable.getColumnModel().getColumn(5).setPreferredWidth(90); 
	    //设置每一列的高度
		eTable.setRowHeight(22);
		//给eTable加上一个鼠标事件监听器对象
		 eTable.addMouseListener(new java.awt.event.MouseAdapter(){
      	 public void mouseClicked(MouseEvent ev) {//仅当鼠标单击时响应
      		 //得到选中的行列的索引值
      		int r= eTable.getSelectedRow();
      		Employee e=new Employee();
      		e=eList.get(r);
      		display(e.getEmployeeNo(),e.getEmployeeName(),e.getSex(),String.valueOf(e.getBirthday()),e.getAddress(),e.getTelephone()
      				,String.valueOf(e.getHireday()),e.getDepartment(),e.getHeadship(),String.valueOf(e.getSalary()));
//   			int c=	 eTable.getSelectedColumn();
//   		    //得到选中的单元格的值，表格中都是字符串
//   			Object value= eTable.getValueAt(r, c);
//			 String info=r+"行"+c+"列 值 : "+value.toString();
//			 javax.swing.JOptionPane.showMessageDialog(null,info);
      	 }
       });
		//添加表格到ScrollPane上
		JScrollPane scrollPane = new JScrollPane(eTable);
		scrollPane.setPreferredSize(new Dimension(800, 200));
		JP_emp1_3.add(scrollPane);
		
///////////**************************/////
///////////**员工管理中部布局*********/////
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
		//设置字体
		label.setFont(new Font("宋体",Font.BOLD+Font.ITALIC,25));
		JP_emp2_1_1.add(label);
		
		JPanel JP_emp2_1_2 = new JPanel(new GridLayout(5,4));
	
		JLabel jl2_1=new JLabel("员工号",JLabel.CENTER);
		JLabel jl2_2=new JLabel("员工名",JLabel.CENTER);
		JLabel jl2_3=new JLabel("性别",JLabel.CENTER);
		JLabel jl2_4=new JLabel("生日",JLabel.CENTER);
		JLabel jl2_5=new JLabel("地址",JLabel.CENTER);
		JLabel jl2_6=new JLabel("电话",JLabel.CENTER);
		JLabel jl2_7=new JLabel("雇佣日期",JLabel.CENTER);
		JLabel jl2_8=new JLabel("部门",JLabel.CENTER);
		JLabel jl2_9=new JLabel("职务",JLabel.CENTER);
		JLabel jl2_10=new JLabel("薪水",JLabel.CENTER);
		 jt2_1=new JTextField();
		jt2_1.setFont(new Font("黑体",Font.BOLD+Font.ITALIC,20));
		jt2_1.setEditable(false);
		
		jt2_2=new JTextField();
		jt2_2.setFont(new Font("黑体",Font.BOLD+Font.ITALIC,20));
		jt2_2.setEditable(false);
		 jt2_3=new JTextField();
		jt2_3.setFont(new Font("黑体",Font.BOLD+Font.ITALIC,20));
		jt2_3.setEditable(false);
		 jt2_4=new JTextField();
		jt2_4.setFont(new Font("宋体",Font.BOLD+Font.ITALIC,20));
		jt2_4.setEditable(false);
		jt2_5=new JTextField();
		jt2_5.setFont(new Font("黑体",Font.BOLD+Font.ITALIC,20));
		jt2_5.setEditable(false);
		 jt2_6=new JTextField();
		jt2_6.setFont(new Font("黑体",Font.BOLD+Font.ITALIC,20));
		jt2_6.setEditable(false);
		jt2_7=new JTextField();
		jt2_7.setFont(new Font("黑体",Font.BOLD+Font.ITALIC,20));
		jt2_7.setEditable(false);
		 jt2_8=new JTextField();
		jt2_8.setFont(new Font("黑体",Font.BOLD+Font.ITALIC,20));
		jt2_8.setEditable(false);
		 jt2_9=new JTextField();
		jt2_9.setFont(new Font("黑体",Font.BOLD+Font.ITALIC,20));
		jt2_9.setEditable(false);
		 jt2_10=new JTextField();
		jt2_10.setFont(new Font("黑体",Font.BOLD+Font.ITALIC,20));
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
		//为按钮增加监听事件
		btn_change.addActionListener(this);
		
		JP_emp2_1_3.add(btn_change);
		
		 btn_add = new JButton("\u65B0\u589E\u5458\u5DE5");
		//为添加按钮设置监听事件
		 btn_add.addActionListener(this);
		 JP_emp2_1_3.add(btn_add);
		
		 btn_refresh = new JButton("\u5237\u65B0");
		//为添加按钮设置监听事件
		 btn_refresh.addActionListener(this);
		JP_emp2_1_3.add(btn_refresh);
		
		
		
		 btn_delete = new JButton("\u5220\u9664\u5458\u5DE5");
		 //为删除按钮设置监听事件
		 btn_delete.addActionListener(this);
		JP_emp2_1_3.add(btn_delete);
		
		
////////////////******************************************//////////////////////////////////
/********************员工管理页的结束界限***************************************************/		
		 
		
		
	////****************************客户管理页部分的代码***************************//////////////		 
		 //存放客户管理页的主JPnel
		JP_cm = new JPanel();
		tabP.add("顾客管理", JP_cm);
		
		//往客户管理页添加一个主JPanel
		JPanel JP_cmp = new JPanel();
		JP_cm.add(JP_cmp);
		JP_cmp.setLayout(new BorderLayout(0, 0));
		
///////////**************************/////
///////////**客户管理北部布局*********/////
		JPanel JP_cmp1 = new JPanel();
		JP_cmp.add(JP_cmp1, BorderLayout.PAGE_START);
		JP_cmp1.setLayout(new BorderLayout(0, 0));
		
		//北部布局嵌套的北部布局
		JPanel jP_cmp1_1 = new JPanel();
		JP_cmp1.add(jP_cmp1_1,BorderLayout.NORTH);
		jP_cmp1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_5 = new JLabel("客户信息栏");
		lblNewLabel_5.setFont(new Font("宋体",Font.BOLD+Font.ITALIC,25));
		jP_cmp1_1.add(lblNewLabel_5);
		
		//北部布局嵌套的中部布局
		
		
		//北部布局嵌套的南部布局
		JPanel JP_cmp1_3 = new JPanel();
		JP_cmp1.add(JP_cmp1_3, BorderLayout.SOUTH);
		
		//取出所有客户信息
		cservice=new CustomerService();
		cList=cservice.getAllCustomer();
		
		//创建表格Modal
		cTableModal=new CTableModal(cList);
		//创建表格
		cTable=new JTable();
		//设置表格Modal
		cTable.setModel(cTableModal);
		//设置第六列的宽度
		cTable.getColumnModel().getColumn(2).setPreferredWidth(90); 
	    //设置每一列的高度
		cTable.setRowHeight(22);
		//给eTable加上一个鼠标事件监听器对象
		 cTable.addMouseListener(new java.awt.event.MouseAdapter(){
     	 public void mouseClicked(MouseEvent ev) {//仅当鼠标单击时响应
     		 //得到选中的行列的索引值
     		int r= cTable.getSelectedRow();
     		Customer c=new Customer();
     		c=cList.get(r);
     		cDisplay(c.getCustomerNo(),c.getCustomerName(),c.getAddress(),c.getTelephone(),c.getZip());

     	 }
      });
		//添加表格到ScrollPane上
		JScrollPane scrollPane1 = new JScrollPane(cTable);
		scrollPane1.setPreferredSize(new Dimension(800, 200));
		JP_cmp1_3.add(scrollPane1);
		
///////////**************************/////
///////////**客户管理中部布局*********/////
		JPanel JP_cmp2 = new JPanel();
		JP_cmp.add(JP_cmp2, BorderLayout.PAGE_END);
		
		JP_cmp2.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_cmp2_1 = new JPanel();
		JP_cmp2.add(JP_cmp2_1);
		JP_cmp2_1.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_cmp2_1_1 = new JPanel();
		JP_cmp2_1.add(JP_cmp2_1_1, BorderLayout.NORTH);
		JP_cmp2_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel clabel = new JLabel("客户个人信息管理");
		//设置字体
		clabel.setFont(new Font("宋体",Font.BOLD+Font.ITALIC,25));
		JP_cmp2_1_1.add(clabel);
		
		JPanel JP_cmp2_1_2 = new JPanel(new GridLayout(5,2));
	
		JLabel jlc_1=new JLabel("客户号",JLabel.CENTER);
		JLabel jlc_2=new JLabel("客户名",JLabel.CENTER);
		JLabel jlc_3=new JLabel("地址",JLabel.CENTER);
		JLabel jlc_4=new JLabel("电话",JLabel.CENTER);
		JLabel jlc_5=new JLabel("邮编",JLabel.CENTER);
		
		 jtc_1=new JTextField();
		jtc_1.setFont(new Font("黑体",Font.BOLD+Font.ITALIC,20));
		jtc_1.setEditable(false);
		
		jtc_2=new JTextField();
		jtc_2.setFont(new Font("黑体",Font.BOLD+Font.ITALIC,20));
		jtc_2.setEditable(false);
		 jtc_3=new JTextField();
		jtc_3.setFont(new Font("黑体",Font.BOLD+Font.ITALIC,20));
		jtc_3.setEditable(false);
		 jtc_4=new JTextField();
		jtc_4.setFont(new Font("宋体",Font.BOLD+Font.ITALIC,20));
		jtc_4.setEditable(false);
		jtc_5=new JTextField();
		jtc_5.setFont(new Font("黑体",Font.BOLD+Font.ITALIC,20));
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
		//为按钮增加监听事件
		cbtn_change.addActionListener(this);
		
		JP_cmp2_1_3.add(cbtn_change);
		
		 cbtn_add = new JButton("增加客户");
		//为添加按钮设置监听事件
		 cbtn_add.addActionListener(this);
		 JP_cmp2_1_3.add(cbtn_add);
		
		 cbtn_refresh = new JButton("\u5237\u65B0");
		//为添加按钮设置监听事件
		 cbtn_refresh.addActionListener(this);
		JP_cmp2_1_3.add(cbtn_refresh);
		
		
		
		 cbtn_delete = new JButton("删除客户");
		 //为删除按钮设置监听事件
		 cbtn_delete.addActionListener(this);
		JP_cmp2_1_3.add(cbtn_delete);
		
		
////////////////******************************************//////////////////////////////////
/********************顾客管理页的结束界限***************************************************/			
		 JP_omm = new JPanel();
		tabP.add("订单管理",  JP_omm);
		
		 JP_prm = new JPanel();
		tabP.add("产品管理", JP_prm);
		
		MainPanel.add(tabP);
		
		 JP_zhm = new JPanel();
		tabP.add("账号管理",  JP_zhm);
	}
	///**************员工页方法部分**********//////
	//刷新员工表格的方法
	public void reeTable() throws IOException, ClassNotFoundException, SQLException{
		eList=eservice.getAllEmployee();
		/**更新表格信息***/
		//创建表格Modal
		eTableModal=new ETableModal(eList);
		//设置表格Modal
		eTable.setModel(eTableModal);
	}
	//设置JTextField里面显示员工信息的方法
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
	//获取JTextField里面员工信息的方法
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
	//将显示员工信息的文本区域显示成可编辑或不可编辑的
	public void setEdited(){
		//假如原来不可编辑则显示成可编辑的,否则显示成不可编辑的
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
	//*********员工页方法结束界限***/////////////////////
	///**************客户页方法部分**********//////
	//刷新客户表格的方法
	public void recTable() throws IOException, ClassNotFoundException, SQLException{
		cList=cservice.getAllCustomer();
		/**更新表格信息***/
		//创建表格Modal
		cTableModal=new CTableModal(cList);
		//设置表格Modal
		cTable.setModel(cTableModal);
	}
	//设置JTextField里面显示客户信息的方法
	public void cDisplay(String customerNo,String customerName,String address,String tel,String zip){
		jtc_1.setText(customerNo);
		jtc_2.setText(customerName);
		jtc_3.setText(address);
		jtc_4.setText(tel);
		jtc_5.setText(zip);
	
		
	}
	//获取JTextField里面客户信息的方法
	public Customer getcMsg(){
		Customer c=new Customer();
	c.setCustomerNo(jtc_1.getText().toString());
	c.setCustomerName(jtc_2.getText().toString());
	c.setAddress(jtc_3.getText().toString());
	c.setTelephone(jtc_4.getText().toString());
	c.setZip(jtc_5.getText().toString());
		return c;
		
	}
	//将显示客户信息的文本区域显示成可编辑或不可编辑的
	public void setcEdited(){
		//假如原来不可编辑则显示成可编辑的,否则显示成不可编辑的
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
	////**客户页方法结束界限****//////////////
	
	/////***********公共方法部分*****////////////
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//如果用户点击修改
		if(arg0.getSource()==btn_change)
		{
			if(btn_change.getText().equals("修改")){
			setEdited();
			btn_change.setText("完成");
		}
			else{
				setEdited();
				Employee e=new Employee();
				e=getMsg();
				try {
					eservice.update(e);
					//刷新表格
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
				
				btn_change.setText("修改");
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
			//***更新表格**////
			try {
				reeTable();
				JOptionPane.showMessageDialog(this,"删除成功!!");
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
			if(cbtn_change.getText().equals("修改")){
				setcEdited();
				cbtn_change.setText("完成");
			}
				else{
					setcEdited();
					Customer c=new Customer();
					c=getcMsg();
					try {
						cservice.update(c);
						//刷新表格
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
					
					cbtn_change.setText("修改");
				}
				
		}
		else if(arg0.getSource()==cbtn_change){
			if(cbtn_change.getText().equals("修改")){
				setcEdited();
				cbtn_change.setText("完成");
			}
				else{
					setcEdited();
					Customer c=new Customer();
					c=getcMsg();
					try {
						cservice.update(c);
						//刷新表格
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
					
					cbtn_change.setText("修改");
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
			//***更新表格**////
			try {
				recTable();
				JOptionPane.showMessageDialog(this,"删除成功!!");
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
