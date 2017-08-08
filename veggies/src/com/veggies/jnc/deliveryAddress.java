package com.veggies.jnc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class deliveryAddress extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deliveryAddress frame = new deliveryAddress();
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
	public deliveryAddress() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delivery Address");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(150, 0, 161, 66);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Flat No");
		lblNewLabel_1.setBounds(39, 72, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblStreetName = new JLabel("Street Name");
		lblStreetName.setBounds(39, 107, 62, 20);
		contentPane.add(lblStreetName);
		
		JLabel lblSuburb = new JLabel("Suburb");
		lblSuburb.setBounds(39, 143, 46, 14);
		contentPane.add(lblSuburb);
		
		JLabel lblZipCode = new JLabel("Zip Code");
		lblZipCode.setBounds(39, 180, 46, 14);
		contentPane.add(lblZipCode);
		
		textField = new JTextField();
		textField.setBounds(111, 69, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(111, 104, 86, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(111, 140, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(111, 177, 86, 20);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.setVisible(false);
				Paymentform objpayment = new Paymentform();
				objpayment.setVisible(true);
				
				
			}
		});
		btnNewButton.setBounds(39, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.setBounds(239, 227, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
