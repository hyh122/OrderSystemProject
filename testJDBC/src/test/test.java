package test;

import java.io.IOException;
import java.sql.SQLException;

import modal.Manager;
import Service.ManagerService;
import db_Tools.JDBCTools;

public class test {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
//		String sql="delete from employee where employeeno='E2008005'";
//		JDBCTools.update(sql);
		testManager();
		
		
	}
	//测试系统管理员
	public static void testManager() throws IOException, ClassNotFoundException, SQLException{
		ManagerService managerservice=new ManagerService();
		//测试添加系统管理员方法
		//managerservice.addManager("S0002","张三","111111");
		
		//测试按id号删除系统管理员
		//managerservice.deleteManagerById("S0001");
		//测试按姓名删除系统管理员
		//managerservice.deleteManagerByName("张三");
		
		//测试更新系统管理员信息
//		String sql="update manager set managerName=?" +"where managerId='S0002'";
//		managerservice.updateManager(sql, "李四");
		
		
		//测试按照用户id查找用户信息
//		Manager manager=new Manager();
//		manager=managerservice.queryManagerById("S0002");
//		System.out.println(manager);
		
		//测试按照用户姓名来查找用户信息
		Manager manager=new Manager();
		manager=managerservice.queryManagerByName("李四");
		System.out.println(manager);
	}
}
