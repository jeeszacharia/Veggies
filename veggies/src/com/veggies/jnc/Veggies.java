package com.veggies.jnc;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

//*********LOGIN PAGE **********************//

public class Veggies{

	private JFrame frame;
	private JTextField textuserID;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
				
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Veggies window = new Veggies();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Veggies() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		connection obj = new connection();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 643, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Id");
		lblNewLabel.setBounds(29, 64, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(29, 102, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				//************JZ Starts*****************************
				try {
					obj.connecttoDB();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				        }
				
				String loginpageuserID= textuserID.getText();
				String loginpagePassword= passwordField.getText();
				boolean loginResult;
				
				loginResult=obj.checkLogin(loginpageuserID, loginpagePassword);
				
				System.out.println("Login verified and result is ==" +loginResult);
				
				if(loginResult==true ){
				
				frame.dispose();
			HomePage objHomepage = null;
			try {
				objHomepage = new HomePage();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			objHomepage.setVisible(true);	
				}else{
					JOptionPane.showMessageDialog(frame, "Invalid user id or password.");
					
					}
			}
		});
		btnSubmit.setBounds(29, 146, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		textuserID = new JTextField();
		textuserID.setBounds(97, 61, 86, 20);
		frame.getContentPane().add(textuserID);
		textuserID.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(97, 99, 86, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("New User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// ***********JZ Starts *********************
				
				frame.dispose();
				RegistrationForm objRegistrationForm = new 	RegistrationForm();
				
				objRegistrationForm.setVisible(true);
				
				// ***********JZ Ends *********************
				}
		});
		btnNewButton.setBounds(159, 146, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
