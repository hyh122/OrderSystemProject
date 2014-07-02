package com.orsystem.control;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class dis_Date {
	//日历
	private Calendar ca;
	//天
	private Date currentDay;
	//字符串的日期
	private String ScurrentDay;
	public String get_curDate(){
		
		//得到一个日期的实例
		ca=Calendar.getInstance();
		//设置时间为当前日期
		ca.setTime(new Date());
		//获取当前日期
		currentDay=ca.getTime();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		//将当前日期转成字符串格式
		ScurrentDay=sf.format(currentDay);
		return ScurrentDay;
		
	}
	//将日期格式转为"yyyyMMdd"的字符串格式
	public String get_curDate2(){
		
		//得到一个日期的实例
		ca=Calendar.getInstance();
		//设置时间为当前日期
		ca.setTime(new Date());
		//获取当前日期
		currentDay=ca.getTime();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		//将当前日期转成字符串格式
		ScurrentDay=sf.format(currentDay);
		return ScurrentDay;
		
	}
}
