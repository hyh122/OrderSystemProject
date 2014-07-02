package com.orsystem.DataService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.orsystem.DataTable.Manager;
import com.orsystem.db.JDBCTools;



public class ManagerService {
	
	
	public ManagerService() {
		super();
		// TODO Auto-generated constructor stub
	}

	//添加系统管理员
	public void addManager(Object ... args){
		String sql="insert into manager values(?,?,?)";
		JDBCTools.update(sql, args);
	}
	
	//按id号删除系统管理员
	public void deleteManagerById(String T){
		String sql="delete from manager where managerid=?";
		JDBCTools.update(sql, T);
	}
	
	//按姓名删除系统管理员
	public void deleteManagerByName(String T){
		String sql="delete from manager where managerName=?";
		JDBCTools.update(sql, T);
	}
	
	//更新系统管理员信息
	public void updateManager(String sql, Object ... args){
		JDBCTools.update(sql, args);
	}
	
	//按Id查询系统管理员信息
	public Manager queryManagerById(String id) throws IOException, ClassNotFoundException, SQLException{
		Manager manager = null;
		Connection con=(Connection) JDBCTools.getConnection();
		String sql="select *from manager where managerid=?";
		PreparedStatement preparedstatement=con.prepareStatement(sql);
		preparedstatement.setString(1, id);
		
		ResultSet rs=(ResultSet) preparedstatement.executeQuery();
		while(rs.next()){
			manager=new Manager();
			manager.setManagerId(rs.getString(1));
			manager.setManagerName(rs.getString(2));
			manager.setPasswd(rs.getString(3));
		}
		
		return manager;
		
	}
	
	//按Id查询系统管理员信息,有该系统管理员则返回true，没有则返回false
	public boolean queryManagerById1(String id) throws IOException, ClassNotFoundException, SQLException{
		boolean k=false;
		
		Connection con=(Connection) JDBCTools.getConnection();
		String sql="select *from manager where managerid=?";
		PreparedStatement preparedstatement=con.prepareStatement(sql);
		preparedstatement.setString(1, id);
		
		ResultSet rs=(ResultSet) preparedstatement.executeQuery();
		while(rs.next()){
			k=true;
		}
		
		return k;
		
	}
	
	//按名字查询系统管理员信息
		public Manager queryManagerByName(String name) throws IOException, ClassNotFoundException, SQLException{
			Manager manager = null;
			Connection con=(Connection) JDBCTools.getConnection();
			String sql="select *from manager where managername=?";
			PreparedStatement preparedstatement=con.prepareStatement(sql);
			preparedstatement.setString(1, name);
			
			ResultSet rs=(ResultSet) preparedstatement.executeQuery();
			while(rs.next()){
				manager=new Manager();
				manager.setManagerId(rs.getString(1));
				manager.setManagerName(rs.getString(2));
				manager.setPasswd(rs.getString(3));
			}
			
			return manager;
			
		}
}
