package com.tecService;

public class DataClassChange {

	public DataClassChange() {
		super();
		// TODO Auto-generated constructor stub
	}
	//���ַ������͵�����װ����float������
	public static float SchangeToFloat(String s){
		return Float.valueOf(s);
	}
	//���ַ������͵�����װ����int������
	public static int SchangeToInt(String s){
		return Integer.valueOf(s);
	}
	//���ַ������͵�����װ����double������
	public static Double SchangeToDouble(String s){
		return Double.valueOf(s);
	}

}
