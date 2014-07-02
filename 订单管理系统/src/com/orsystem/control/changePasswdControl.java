package com.orsystem.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.orsystem.db.JDBCTools;

public class changePasswdControl {

	public changePasswdControl() {
		super();
		// TODO Auto-generated constructor stub
	}
	//根据账号名判断密码是否正确
	public boolean checkPasswd(String acountType,String acount,String passwd){
		boolean flag=false;
		String sql=null;
		try {
			Connection con=(Connection) JDBCTools.getConnection();
			if(acountType.equals("Customer")){
			sql="select Passwd from cacount where customerno=?";
			}
			else if(acountType.equals("Employee")){
			sql="select Passwd from eacount where employeeno=?";
			}
			else if(acountType.equals("manager")){
			sql="select Passwd from manager where managerid=?";
			}
			PreparedStatement preparedstatement;
			preparedstatement = con.prepareStatement(sql);
			preparedstatement.setString(1,acount);
			
			ResultSet rs=(ResultSet) preparedstatement.executeQuery();
			while(rs.next()){
				if(passwd.equals(rs.getString(1))){
					flag=true;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	//修改密码
	public void changePasswd(String acountType,String acount,String passwd){
		
		String sql=null;
		try {
			Connection con=(Connection) JDBCTools.getConnection();
			if(acountType.equals("Customer")){
			sql="update cacount set Passwd=? where customerno=?";
			}
			else if(acountType.equals("Employee")){
			sql="update eacount set Passwd=? where employeeno=?";
			}
			else if(acountType.equals("manager")){
			sql="update manager set Passwd=? where managerid=?";
			}
			PreparedStatement preparedstatement;
			preparedstatement = con.prepareStatement(sql);
			preparedstatement.setString(1,passwd);
			preparedstatement.setString(2,acount);
			
			preparedstatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
