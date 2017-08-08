package com.veggies.jnc;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RegistrationForm extends JFrame {

	//private JFrame Registrationform;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textEmail;
	private JTextField textUserName;
	private JTextField textMobileNumber;
	private JPasswordField txtPassword;
	private JPasswordField txtconfrmpwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationForm frame = new RegistrationForm();
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
	public RegistrationForm() {
		
		connection obj = new connection();
		
		setTitle("Registration Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewUserRegistration = new JLabel("New User Registration");
		lblNewUserRegistration.setBounds(125, 11, 214, 32);
		contentPane.add(lblNewUserRegistration);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(10, 57, 67, 14);
		contentPane.add(lblNewLabel);
		
		textFirstName = new JTextField();
		textFirstName.setBounds(107, 54, 86, 20);
		contentPane.add(textFirstName);
		textFirstName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setBounds(244, 54, 67, 14);
		contentPane.add(lblNewLabel_1);
		
		textLastName = new JTextField();
		textLastName.setBounds(370, 54, 86, 20);
		contentPane.add(textLastName);
		textLastName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("E-Mail");
		lblNewLabel_2.setBounds(10, 88, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textEmail = new JTextField();
		textEmail.setBounds(107, 85, 86, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(244, 88, 67, 14);
		contentPane.add(lblUserName);
		
		textUserName = new JTextField();
		textUserName.setBounds(370, 85, 86, 20);
		contentPane.add(textUserName);
		textUserName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBounds(10, 119, 67, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm Password");
		lblNewLabel_4.setBounds(240, 110, 120, 32);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mobile Number");
		lblNewLabel_5.setBounds(10, 144, 99, 32);
		contentPane.add(lblNewLabel_5);
		
		textMobileNumber = new JTextField();
		textMobileNumber.setBounds(107, 153, 86, 20);
		contentPane.add(textMobileNumber);
		textMobileNumber.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//************************************
				
				boolean registrationStatus;
				
				try {
					obj.connecttoDB();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String varFirstname=textFirstName.getText();
				String varLastName=textLastName.getText();
				String varEmail=textEmail.getText();
				String varUserName= textUserName.getText();
				@SuppressWarnings("deprecation")
				String varPassword= txtPassword.getText();
				@SuppressWarnings("deprecation")
				String varConfirmPassword= txtconfrmpwd.getText();
				int varMob= Integer.parseInt(textMobileNumber.getText());
				
			//	System.out.println("Mob number= "+varMob);
				
				registrationStatus=obj.newUserRegistration(varFirstname,varLastName,varEmail,varUserName,varPassword,varConfirmPassword,varMob);
				
				if(registrationStatus=true){
					JOptionPane.showMessageDialog(contentPane, "You are Succesfully Registered Dear   "+ varFirstname);
					
										
				}else{
								
					
					JOptionPane.showMessageDialog(contentPane, "Please retry   "+varFirstname);
					
				}
				
				//Registrationform.dispose();
				//HomePage objHomepage = new 	HomePage();
				
			}
		});
		btnSubmit.setBounds(20, 211, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.setBounds(222, 211, 89, 23);
		contentPane.add(btnNewButton_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(107, 116, 86, 20);
		contentPane.add(txtPassword);
		
		txtconfrmpwd = new JPasswordField();
		txtconfrmpwd.setBounds(370, 116, 86, 20);
		contentPane.add(txtconfrmpwd);
	}
}
