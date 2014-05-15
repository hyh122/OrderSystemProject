package Service;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modal.Employee;
import modal.Manager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

import db_Tools.JDBCTools;

public class EmployeeService {

	public EmployeeService() {
		super();
		// TODO Auto-generated constructor stub
	}

	//���ϵͳ����Ա
	public void addEmployee(Object ... args){
		String sql="insert into Employee values(?,?,?,?,?,?,?,?,?,?)";
		JDBCTools.update(sql, args);
	}
	
	//��Ա����ɾ��Ա��
	public void deleteEmployeeById(String T){
		String sql="delete from employee where employeeno=?";
		JDBCTools.update(sql, T);
	}
	
	//������ɾ��Ա��
	public void deleteEmployeeByName(String T){
		String sql="delete from employee where employeeName=?";
		JDBCTools.update(sql, T);
	}
	
	//����Ա����Ϣ
	public void updateEmployee(String sql, Object ... args){
		JDBCTools.update(sql, args);
	}
	
	//��Ա���Ų�ѯԱ����Ϣ
	public Employee queryEmployeeById(String id) throws IOException, ClassNotFoundException, SQLException{
		Employee employee = null;
		Connection con=(Connection) JDBCTools.getConnection();
		String sql="select *from Employee where employeeno=?";
		PreparedStatement preparedstatement=con.prepareStatement(sql);
		preparedstatement.setString(1, id);
		
		ResultSet rs=(ResultSet) preparedstatement.executeQuery();
		while(rs.next()){
			employee=new Employee();
			employee.setEmployeeNo(rs.getString(1));
			employee.setEmployeeName(rs.getString(2));
			employee.setSex(rs.getString(3));
			employee.setBirthday(rs.getDate(4));
			employee.setAddress(rs.getString(5));
			employee.setTelephone(rs.getString(6));
			employee.setHireday(rs.getDate(7));
			employee.setDepartment(rs.getString(8));
			employee.setHeadship(rs.getString(9));
			employee.setSalary(rs.getFloat(10));
		}
		
		return employee;
		
	}
	
	//�����ֲ�ѯԱ����Ϣ
		public Employee queryEmployeeByName(String name) throws IOException, ClassNotFoundException, SQLException{
			Employee employee = null;
			Connection con=(Connection) JDBCTools.getConnection();
			String sql="select *from employee where employeename=?";
			PreparedStatement preparedstatement=con.prepareStatement(sql);
			preparedstatement.setString(1, name);
			
			ResultSet rs=(ResultSet) preparedstatement.executeQuery();
			while(rs.next()){
				employee=new Employee();
				employee.setEmployeeNo(rs.getString(1));
				employee.setEmployeeName(rs.getString(2));
				employee.setSex(rs.getString(3));
				employee.setBirthday(rs.getDate(4));
				employee.setAddress(rs.getString(5));
				employee.setTelephone(rs.getString(6));
				employee.setHireday(rs.getDate(7));
				employee.setDepartment(rs.getString(8));
				employee.setHeadship(rs.getString(9));
				employee.setSalary(rs.getFloat(10));
			}
			
			return employee;
			
		}
}
