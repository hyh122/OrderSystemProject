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
}
