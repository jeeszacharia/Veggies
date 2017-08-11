package com.veggies.jnc;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

public class Orderform extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
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
		@SuppressWarnings("unused")
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
		lblTotal.setBounds(252, 325, 46, 14);
		contentPane.add(lblTotal);
		
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
		table.setBounds(41, 102, 440, 212);
		contentPane.add(table);
		
		JLabel lblTotal1 = new JLabel("");
		lblTotal1.setBounds(320, 325, 65, 14);
		contentPane.add(lblTotal1);
		ResultSet myresultset,myresultset1=null;
		Statement stmnt=null;
		PreparedStatement prepstmt,prepstmt1;
		String query =null;
		Connection myDBconnection =null;
				
	try{
		//obj.connecttoDB();
		Class.forName("com.mysql.jdbc.Driver");
		   myDBconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/veggies","root","root");
			
		    System.out.println("Connected to DB");
		
			String sqlQuery=("SELECT PurchasedItemName,Quantity,TotalAmount  FROM veggies.purchasetable");
			prepstmt = (PreparedStatement) myDBconnection.prepareStatement(sqlQuery);
			myresultset= prepstmt.executeQuery();
			
			if(myresultset!=null){
				 table.setModel(DbUtils.resultSetToTableModel(myresultset));
				 			 
				 }
				 								
				}catch(Exception exc){
					exc.printStackTrace();
											
				}
			
			
			String sqlQuery1=("SELECT SUM(TotalAmount) FROM veggies.purchasetable");

			 
			 prepstmt1 = (PreparedStatement) myDBconnection.prepareStatement(sqlQuery1);
						 		 
			 
			 myresultset1=prepstmt1.executeQuery();
			 	 
			 //System.out.println("total amount"+myresultset1);
			 
			 //table.setModel(dataModel);
			 
	try{
		 myresultset1.next();
			 
			 String sum =myresultset1.getString(1);
			 System.out.println(sum);
						 
			 lblTotal1.setText(sum);
			 
			 			 
		 
	 }catch(Exception e){
		 System.out.println(e);
		 	 
	 }
		
		
	}
}
