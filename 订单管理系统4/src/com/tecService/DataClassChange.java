package com.tecService;

public class DataClassChange {

	public DataClassChange() {
		super();
		// TODO Auto-generated constructor stub
	}
	//将字符串类型的数据装换成float的数据
	public static float SchangeToFloat(String s){
		return Float.valueOf(s);
	}
	//将字符串类型的数据装换成int的数据
	public static int SchangeToInt(String s){
		return Integer.valueOf(s);
	}
	//将字符串类型的数据装换成double的数据
	public static Double SchangeToDouble(String s){
		return Double.valueOf(s);
	}

}
