package com.veggies.jnc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Color;

public class Orderform extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Orderform frame = new Orderform();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * 
	 */
	@SuppressWarnings("null")
	public Orderform() throws SQLException  {
		connection obj= new connection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Your Order List");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(161, 0, 249, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Items");
		lblNewLabel_1.setBounds(41, 64, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantity");
		lblNewLabel_2.setBounds(171, 64, 73, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Amount");
		lblNewLabel_3.setBounds(320, 60, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(252, 293, 46, 14);
		contentPane.add(lblTotal);
		
		textField = new JTextField();
		textField.setBounds(324, 290, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				deliveryAddress objaddress = new deliveryAddress();
				
				objaddress.setVisible(true);			
							
			}
		});
		btnCheckout.setBounds(185, 359, 89, 23);
		contentPane.add(btnCheckout);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(345, 359, 89, 23);
		contentPane.add(btnCancel);
		
		table = new JTable();
		table.setBounds(41, 102, 369, 128);
		contentPane.add(table);
		
		ResultSet myresultset=null;
		Statement stmnt=null;
		PreparedStatement prepstmt;
		String query =null;
		Connection myDBconnection =null;
				
	try{
		//obj.connecttoDB();
		Class.forName("com.mysql.jdbc.Driver");
		   myDBconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/veggies","root","root");
			
		    System.out.println("Connected to DB");
		
			String sqlQuery=("SELECT * FROM veggies.purchasetable");

			 prepstmt = (PreparedStatement) myDBconnection.prepareStatement(sqlQuery);
						 		 
			 myresultset= prepstmt.executeQuery();
			 
			 //table.setModel(dataModel);
			 if(myresultset!=null){
			 table.setModel(DbUtils.resultSetToTableModel(myresultset));
			 }
			 								
			}catch(Exception exc){
				exc.printStackTrace();
										
			}
		
		
	}
}
