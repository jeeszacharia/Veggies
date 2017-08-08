package com.veggies.jnc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Paymentform extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paymentform frame = new Paymentform();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Paymentform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPayment.setBounds(147, 0, 139, 40);
		contentPane.add(lblPayment);
		
		JLabel lblNewLabel = new JLabel("Card No");
		lblNewLabel.setBounds(54, 65, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Expiry Date");
		lblNewLabel_1.setBounds(54, 95, 67, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name on Card");
		lblNewLabel_2.setBounds(54, 138, 90, 21);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(152, 62, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 95, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(152, 138, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ReportForm objreportform = new ReportForm();
				objreportform.setVisible(true);
				
							}
		});
		btnNewButton.setBounds(54, 215, 89, 23);
		contentPane.add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Cash on Delivery");
		rdbtnNewRadioButton.setBounds(147, 177, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(240, 215, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
