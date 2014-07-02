package com.orsystem.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;
import com.orsystem.DataTable.Customer;
import com.orsystem.db.JDBCTools;
import com.orsystem.ui.CustomerUI;
import com.orsystem.ui.EmployeeUI;
import com.orsystem.ui.Main;

public class LoginControl {
	
	
	public LoginControl() {
		
		// TODO Auto-generated constructor stub
	}

	//第一个参数为身份类型，比如员工，顾客，系统管理员等
	//第二个参数为传入的账号，第三个为传入的密码
	public  void Login(String PersonType,String acount,String passwd) throws IOException, ClassNotFoundException, SQLException{
		//标记是否存在所输入的账户
		int flag=0;
		int flag2=0;
		String sql=null;
		Connection con=(Connection) JDBCTools.getConnection();
		if(PersonType.equals("employee"))
		{
		sql="select *from eacount";
		flag2=1;
		}
		else if(PersonType.equals("customer"))
		{
			sql="select *from cacount";
			flag2=2;
		}
		else if(PersonType.equals("manager"))
		{
			sql="select *from manager";
			flag2=3;
		}
		Statement statement=(Statement) con.createStatement();
		
		
		ResultSet rs=(ResultSet) statement.executeQuery(sql);
		while(rs.next()){
		
			if (rs.getString(1).equals(acount)){
				flag=1;
				
				if(rs.getString("Passwd").equals(passwd)){
					if(flag2==1){
						new EmployeeUI(acount);
					}
					else if(flag2==2){
						new CustomerUI(acount);
					}
					else if(flag2==3){
						new Main(acount);
					}
					
					break;
				}
				else{
					JOptionPane.showMessageDialog(null, "密码错误，请从新输入!!");
					break;
				}
			}
			
		}
		if(flag==0){
			JOptionPane.showMessageDialog(null,"该账号不存在!!");
		}
		
	}
}
