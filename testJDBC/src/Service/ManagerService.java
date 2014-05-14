package Service;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

import modal.Manager;
import db_Tools.JDBCTools;

public class ManagerService {
	
	
	public ManagerService() {
		super();
		// TODO Auto-generated constructor stub
	}

	//���ϵͳ����Ա
	public void addManager(Object ... args){
		String sql="insert into manager values(?,?,?)";
		JDBCTools.update(sql, args);
	}
	
	//��id��ɾ��ϵͳ����Ա
	public void deleteManagerById(String T){
		String sql="delete from manager where managerid=?";
		JDBCTools.update(sql, T);
	}
	
	//������ɾ��ϵͳ����Ա
	public void deleteManagerByName(String T){
		String sql="delete from manager where managerName=?";
		JDBCTools.update(sql, T);
	}
	
	//����ϵͳ����Ա��Ϣ
	public void updateManager(String sql, Object ... args){
		JDBCTools.update(sql, args);
	}
	
	//��Id��ѯϵͳ����Ա��Ϣ
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
	
	//�����ֲ�ѯϵͳ����Ա��Ϣ
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
