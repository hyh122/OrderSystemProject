package com.orsystem.control;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class dis_Date {
	//����
	private Calendar ca;
	//��
	private Date currentDay;
	//�ַ���������
	private String ScurrentDay;
	public String get_curDate(){
		
		//�õ�һ�����ڵ�ʵ��
		ca=Calendar.getInstance();
		//����ʱ��Ϊ��ǰ����
		ca.setTime(new Date());
		//��ȡ��ǰ����
		currentDay=ca.getTime();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		//����ǰ����ת���ַ�����ʽ
		ScurrentDay=sf.format(currentDay);
		return ScurrentDay;
		
	}
	//�����ڸ�ʽתΪ"yyyyMMdd"���ַ�����ʽ
	public String get_curDate2(){
		
		//�õ�һ�����ڵ�ʵ��
		ca=Calendar.getInstance();
		//����ʱ��Ϊ��ǰ����
		ca.setTime(new Date());
		//��ȡ��ǰ����
		currentDay=ca.getTime();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		//����ǰ����ת���ַ�����ʽ
		ScurrentDay=sf.format(currentDay);
		return ScurrentDay;
		
	}
}
