package com.orsystem.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.orsystem.control.changePasswdControl;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changePasswdUI extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField tv_oldPasswd;
	private JTextField tv_newPasswd;
	private JTextField tv_confirm;
	private JButton btn_ensure;
	private changePasswdControl control;
	private String acountType,acount;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//new changePasswdUI();
	}

	/**
	 * Create the frame.
	 */
	public changePasswdUI(String acountType,String acount) {
		control=new changePasswdControl();
		this.acountType=acountType;
		this.acount=acount;
		getContentPane().setBackground(new Color(204, 255, 255));
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 18));
		
		
		
		
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 255, 255));
		panel.setBounds(30, 89, 235, 128);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u539F\u6709\u5BC6\u7801");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		panel.add(lblNewLabel);
		
		tv_oldPasswd = new JTextField();
		tv_oldPasswd.setBackground(new Color(204, 255, 255));
		panel.add(tv_oldPasswd);
		tv_oldPasswd.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u65B0\u7684\u5BC6\u7801");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		panel.add(lblNewLabel_1);
		
		tv_newPasswd = new JTextField();
		tv_newPasswd.setBackground(new Color(204, 255, 255));
		panel.add(tv_newPasswd);
		tv_newPasswd.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		panel.add(lblNewLabel_2);
		
		tv_confirm = new JTextField();
		tv_confirm.setBackground(new Color(204, 255, 255));
		panel.add(tv_confirm);
		tv_confirm.setColumns(10);
		
		 btn_ensure = new JButton("\u786E\u5B9A");
		 btn_ensure.addActionListener(this);
		
		btn_ensure.setForeground(new Color(0, 0, 0));
		btn_ensure.setBackground(Color.GREEN);
		btn_ensure.setFont(new Font("宋体", Font.PLAIN, 18));
		btn_ensure.setBounds(96, 244, 93, 33);
		getContentPane().add(btn_ensure);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(38, 20, 215, 40);
		getContentPane().add(panel_1);
		
		JLabel label = new JLabel("\u4FEE\u6539\u5BC6\u7801\u754C\u9762", SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBackground(Color.YELLOW);
		panel_1.add(label);
		

		
		this.setSize(294, 341);
		this.setVisible(true);
		this.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn_ensure){
			if(tv_oldPasswd.getText().toString().equals("")){
				JOptionPane.showMessageDialog(this, "请先填写旧密码");
			}
			else 
			{
				if(control.checkPasswd(acountType, acount, tv_oldPasswd.getText())){
					
					if(tv_newPasswd.getText().toString().equals("")){
						JOptionPane.showMessageDialog(this, "新密码不能为空");
					}
					else 
					{
						if(tv_newPasswd.getText().toString().equals("")){
						JOptionPane.showMessageDialog(this, "请填写确认密码");
						}
						else 
						{
					if(tv_newPasswd.getText().toString().length()==6){
						if(tv_newPasswd.getText().toString().equals(tv_confirm.getText().toString())){
							control.changePasswd(acountType, acount, tv_newPasswd.getText().toString());
							JOptionPane.showMessageDialog(this, "密码更改成功");
							this.dispose();
						}else{
							JOptionPane.showMessageDialog(this, "确认密码与新密码不一致");
						}
					}else{
						JOptionPane.showMessageDialog(this, "密码只能为六位数");
					}
					}
					}
				}
			   else{
					JOptionPane.showMessageDialog(this, "您输入的旧密码不对,请重新输入");
				}
			
				
			}
		}
				
		
	}
}
