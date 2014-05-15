package test;

import java.io.IOException;
import java.sql.SQLException;

import modal.Employee;
import modal.Manager;
import Service.EmployeeService;
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
	//	testManager();
		testEmployee();
		
		
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
	
	//测试员工类
		public static void testEmployee() throws IOException, ClassNotFoundException, SQLException{
			EmployeeService employeeservice=new EmployeeService();
			//测试添加员工方法
			//employeeservice.addEmployee("E2008005","张三","男","1990-12-08","厦门","13877654231","2008-08-12","办公室","职员","4500");
			
			//测试按员工号删除员工
			//employeeservice.deleteEmployeeById("E2008005");
			
			//测试按姓名删除员工
			//employeeservice.deleteEmployeeByName("李虹冰");
			
			//测试更新员工信息
			//String sql="update employee set address=?" +"where employeeno='E2008003'";
			//employeeservice.updateEmployee(sql, "厦门市");
			
			
			//测试按照员工号查找员工信息
//			Employee employee=new Employee();
//			employee=employeeservice.queryEmployeeById("E2008003");
//			System.out.println(employee);
//			
			//测试按照员工名来查找员工信息
			Employee employee=new Employee();
			employee=employeeservice.queryEmployeeByName("张小东");
			System.out.println(employee);
		}
}
