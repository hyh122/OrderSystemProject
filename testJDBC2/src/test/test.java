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
	//����ϵͳ����Ա
	public static void testManager() throws IOException, ClassNotFoundException, SQLException{
		ManagerService managerservice=new ManagerService();
		//�������ϵͳ����Ա����
		//managerservice.addManager("S0002","����","111111");
		
		//���԰�id��ɾ��ϵͳ����Ա
		//managerservice.deleteManagerById("S0001");
		//���԰�����ɾ��ϵͳ����Ա
		//managerservice.deleteManagerByName("����");
		
		//���Ը���ϵͳ����Ա��Ϣ
//		String sql="update manager set managerName=?" +"where managerId='S0002'";
//		managerservice.updateManager(sql, "����");
		
		
		//���԰����û�id�����û���Ϣ
//		Manager manager=new Manager();
//		manager=managerservice.queryManagerById("S0002");
//		System.out.println(manager);
		
		//���԰����û������������û���Ϣ
		Manager manager=new Manager();
		manager=managerservice.queryManagerByName("����");
		System.out.println(manager);
	}
	
	//����Ա����
		public static void testEmployee() throws IOException, ClassNotFoundException, SQLException{
			EmployeeService employeeservice=new EmployeeService();
			//�������Ա������
			//employeeservice.addEmployee("E2008005","����","��","1990-12-08","����","13877654231","2008-08-12","�칫��","ְԱ","4500");
			
			//���԰�Ա����ɾ��Ա��
			//employeeservice.deleteEmployeeById("E2008005");
			
			//���԰�����ɾ��Ա��
			//employeeservice.deleteEmployeeByName("����");
			
			//���Ը���Ա����Ϣ
			//String sql="update employee set address=?" +"where employeeno='E2008003'";
			//employeeservice.updateEmployee(sql, "������");
			
			
			//���԰���Ա���Ų���Ա����Ϣ
//			Employee employee=new Employee();
//			employee=employeeservice.queryEmployeeById("E2008003");
//			System.out.println(employee);
//			
			//���԰���Ա����������Ա����Ϣ
			Employee employee=new Employee();
			employee=employeeservice.queryEmployeeByName("��С��");
			System.out.println(employee);
		}
}
