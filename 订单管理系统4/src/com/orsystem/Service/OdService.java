package com.orsystem.Service;

import com.orsystem.db.JDBCTools;

public class OdService {
	public OdService() {
		super();
		// TODO Auto-generated constructor stub
	}

	//���һ��������ϸ,ע����Ϊ������ϸ�������orderno��productno�ֱ��������
	//����orderno��productnoֻ�������е�orderno��productno
	public void addod(Object ... args){
		String sql="insert into orderdetail values(?,?,?,?)";
		JDBCTools.update(sql, args);
	}
	
	//��������ɾ��������ϸ
	public void deleteodById(String T){
		String sql="delete from orderdetail where orderno=?";
		JDBCTools.update(sql, T);
	}
	

	
	//���¶�����ϸ��Ϣ��ע����Ϊ������ϸ�������orderno��productno�ֱ��������
	//����orderno��productnoֻ�������е�orderno��productno
	public void updateod(String sql, Object ... args){
		JDBCTools.update(sql, args);
	}

}
