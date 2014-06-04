package com.orsystem.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class EmployeeUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new EmployeeUI("E2005002");
	}

	/**
	 * Create the frame.
	 */
	public EmployeeUI(String employeeno) {
		this.setSize(511, 360);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		getContentPane().setLayout(null);
		
	}
}
