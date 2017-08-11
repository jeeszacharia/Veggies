package com.veggies.jnc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.SynchronousQueue;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class HomePage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtqntyPotato;
	private JTextField txtqntyTomato;
	private JTextField txtqntyCarrot;
	private JTextField txtqntyOnion;
	private JTextField txtqntyLettuce;
	private JTextField txtqntyApple;
	private JTextField txtqntyKiwi;
	private JTextField txtqntyMandarin;
	private JTextField txtqntyBanana;
	private JTextField txtqntyPear;
	//public JFrame frame;
	
	//HomePage frame = new HomePage();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	 */
	public HomePage() throws SQLException {
		
		connection obj = new connection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 465);
		contentPane = new JPanel();
		contentPane.setToolTipText("Fruits");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JLabel lblNewLabel = new JLabel("Veggies@DoorStep");
		lblNewLabel.setForeground(new Color(154, 205, 50));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setBounds(184, 0, 333, 54);
		contentPane.add(lblNewLabel);
		
		JCheckBox chckbxPotato = new JCheckBox("Potato");
		chckbxPotato.setBounds(36, 122, 72, 23);
		contentPane.add(chckbxPotato);
		
		JLabel lblNewLabel_1 = new JLabel("Vegetables");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1.setBounds(85, 59, 128, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fruits");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setForeground(new Color(255, 160, 122));
		lblNewLabel_2.setBounds(347, 59, 46, 23);
		contentPane.add(lblNewLabel_2);
		
		JCheckBox chckbxTomato = new JCheckBox("Tomato");
		chckbxTomato.setBounds(36, 157, 97, 23);
		contentPane.add(chckbxTomato);
		
		JCheckBox chckbxCarrot = new JCheckBox("Carrot");
		chckbxCarrot.setBounds(36, 195, 61, 23);
		contentPane.add(chckbxCarrot);
		
		JCheckBox chckbxOnion = new JCheckBox("Onion");
		chckbxOnion.setBounds(36, 231, 72, 23);
		contentPane.add(chckbxOnion);
		
		JCheckBox chckbxLettuce = new JCheckBox("Lettuce");
		chckbxLettuce.setBounds(36, 268, 97, 23);
		contentPane.add(chckbxLettuce);
		
		JCheckBox chckbxKiwi = new JCheckBox("Kiwi");
		chckbxKiwi.setBounds(387, 157, 61, 23);
		contentPane.add(chckbxKiwi);
		
		JCheckBox chckbxApple = new JCheckBox("Apple");
		chckbxApple.setBounds(387, 122, 61, 23);
		contentPane.add(chckbxApple);
		
		JCheckBox chckbxMandarin = new JCheckBox("Mandarin");
		chckbxMandarin.setBounds(387, 195, 80, 23);
		contentPane.add(chckbxMandarin);
		
		JCheckBox chckbxPear = new JCheckBox("Pear");
		chckbxPear.setBounds(387, 268, 54, 23);
		contentPane.add(chckbxPear);
		
		JCheckBox chckbxBanana = new JCheckBox("Banana");
		chckbxBanana.setBounds(387, 231, 80, 23);
		contentPane.add(chckbxBanana);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
		//******************JZ Starts ********************
				ResultSet myresultset=null;
				PreparedStatement prepstmt;
				Connection myDBconnection =null;
				
				try{
					
					
				Class.forName("com.mysql.jdbc.Driver");
				   myDBconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/veggies","root","root");
					
				    System.out.println("Connected to DB");
				    
				    String sqlQuery=("SELECT * FROM veggies.productlist");

					 prepstmt = (PreparedStatement) myDBconnection.prepareStatement(sqlQuery);
					 					 		 
					 myresultset= prepstmt.executeQuery();
															 
					 
				}catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					 
				double Itemprice =0;		
				double amount=0;
				try {
					obj.connecttoDB();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
                    if(chckbxPear.isSelected()){
                    	System.out.println("");
                                    	
                    	                    	                                      										
					String pearSelected=chckbxPear.getText();
					
					double qnty=Double.parseDouble(txtqntyPear.getText());
					
					try {
						while(myresultset.next()){
							if(myresultset.getString("Itemname").equals("Pear")){
								
								  Itemprice = myresultset.getDouble("Price");
								  amount = qnty*Itemprice;
								  
								  
								}
						 }
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//double Amount=6.5;
					
					obj.insetTopurchase(pearSelected, qnty,amount);
				      }
                    
                    if(chckbxPotato.isSelected()){
							
    					String potatoSelected=chckbxPotato.getText();
    					    					
    					double qnty=Double.parseDouble(txtqntyPotato.getText());
    					
    					try {
    						while(myresultset.next()){
    							if(myresultset.getString("Itemname").equals("Potato")){
    								
    								  Itemprice = myresultset.getDouble("Price");
    								  amount = qnty*Itemprice;
    								  
    								  
    								}
    						 }
    						
    					} catch (SQLException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}
    					//double Amount=6.5;
    					
    					obj.insetTopurchase(potatoSelected, qnty,amount);
    				      }
			
                        
    				 System.out.println("");
                    if(chckbxTomato.isSelected()){
						
    					String tomatoSelected=chckbxTomato.getText();
    					double qnty=Double.parseDouble(txtqntyTomato.getText());
    					
    					try {
    						while(myresultset.next()){
    							if(myresultset.getString("Itemname").equals("Tomato")){
    								
    								  Itemprice = myresultset.getDouble("Price");
    								  amount = qnty*Itemprice;
    								  
    								  
    								}
    						 }
    						
    					} catch (SQLException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}
    					
    					
    					obj.insetTopurchase(tomatoSelected, qnty,amount);
    				      }
                        
                    
                        if(chckbxCarrot.isSelected()){
						
    					String carrotSelected=chckbxCarrot.getText();
       					double qnty=Double.parseDouble(txtqntyCarrot.getText());
    					
    					try {
    						while(myresultset.next()){
    							if(myresultset.getString("Itemname").equals("Carrot")){
    								
    								  Itemprice = myresultset.getDouble("Price");
    								  amount = qnty*Itemprice;
    								  
    								  
    								}
    						 }
    						
    					} catch (SQLException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}
    					
    					
    					obj.insetTopurchase(carrotSelected, qnty,amount);
    				      }
    					
    				    
                        if(chckbxOnion.isSelected()){
    						
        					String onionSelected=chckbxOnion.getText();
        					double qnty=Double.parseDouble(txtqntyOnion.getText());
        					
        					try {
        						while(myresultset.next()){
        							if(myresultset.getString("Itemname").equals("Onion")){
        								
        								  Itemprice = myresultset.getDouble("Price");
        								  amount = qnty*Itemprice;
        								  
        								  
        								}
        						 }
        						
        					} catch (SQLException e1) {
        						// TODO Auto-generated catch block
        						e1.printStackTrace();
        					}
        					
        					
        					obj.insetTopurchase(onionSelected, qnty,amount);
        				      }
        					
        				    
                           if(chckbxLettuce.isSelected()){
    						
        					String lettuceSelected=chckbxLettuce.getText();
                           double qnty=Double.parseDouble(txtqntyLettuce.getText());
        					
        					try {
        						while(myresultset.next()){
        							if(myresultset.getString("Itemname").equals("Lettuce")){
        								
        								  Itemprice = myresultset.getDouble("Price");
        								  amount = qnty*Itemprice;
        								  
        								  
        								}
        						 }
        						
        					} catch (SQLException e1) {
        						// TODO Auto-generated catch block
        						e1.printStackTrace();
        					}
        					
        					
        					obj.insetTopurchase(lettuceSelected, qnty,amount);
        				      }
        					
        				    
                           if(chckbxKiwi.isSelected()){
       						
           					String kiwiSelected=chckbxKiwi.getText();
                                double qnty=Double.parseDouble(txtqntyKiwi.getText());
        					
        					try {
        						while(myresultset.next()){
        							if(myresultset.getString("Itemname").equals("Kiwi")){
        								
        								  Itemprice = myresultset.getDouble("Price");
        								  amount = qnty*Itemprice;
        								  
        								  
        								}
        						 }
        						
        					} catch (SQLException e1) {
        						// TODO Auto-generated catch block
        						e1.printStackTrace();
        					}
        					
        					
        					obj.insetTopurchase(kiwiSelected, qnty,amount);
           					
           				    }
                           if(chckbxApple.isSelected()){
          						
              					String appleSelected=chckbxApple.getText();
              					 double qnty=Double.parseDouble(txtqntyApple.getText());
             					
             					try {
             						while(myresultset.next()){
             							if(myresultset.getString("Itemname").equals("Apple")){
             								
             								  Itemprice = myresultset.getDouble("Price");
             								  amount = qnty*Itemprice;
             								  
             								  
             								}
             						 }
             						
             					} catch (SQLException e1) {
             						// TODO Auto-generated catch block
             						e1.printStackTrace();
             					}
             					
             					
             					obj.insetTopurchase(appleSelected, qnty,amount);
              					
              				    }
                           if(chckbxMandarin.isSelected()){
         						
             					String mandarinSelected=chckbxMandarin.getText();
                                 double qnty=Double.parseDouble(txtqntyMandarin.getText());
             					
             					try {
             						while(myresultset.next()){
             							if(myresultset.getString("Itemname").equals("Mandarin")){
             								
             								  Itemprice = myresultset.getDouble("Price");
             								  amount = qnty*Itemprice;
             								  
             								  
             								}
             						 }
             						
             					} catch (SQLException e1) {
             						// TODO Auto-generated catch block
             						e1.printStackTrace();
             					}
             					
             					
             					obj.insetTopurchase(mandarinSelected, qnty,amount);
             					
             				    }
                           if(chckbxBanana.isSelected()){
        						
            					String bananaSelected=chckbxBanana.getText();
                               double qnty=Double.parseDouble(txtqntyBanana.getText());
             					
             					try {
             						while(myresultset.next()){
             							if(myresultset.getString("Itemname").equals("Banana")){
             								
             								  Itemprice = myresultset.getDouble("Price");
             								  amount = qnty*Itemprice;
             								  
             								  
             								}
             						 }
             						
             					} catch (SQLException e1) {
             						// TODO Auto-generated catch block
             						e1.printStackTrace();
             					}
             					
             					
             					obj.insetTopurchase(bananaSelected, qnty,amount);
            					
            				    }
                                   			
														
                         Orderform objorderform = null;
						try {
							objorderform = new Orderform();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				         objorderform.setVisible(true);				
			
		}
			
		});
		
		//**************JZ Ends************************
		
		btnContinue.setBounds(63, 343, 89, 23);
		contentPane.add(btnContinue);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(415, 343, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblPotato = new JLabel("");
		lblPotato.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPotato.setBounds(132, 122, 68, 23);
		contentPane.add(lblPotato);
				
		JLabel lbltomato = new JLabel("");
		lbltomato.setBounds(139, 166, 70, 14);
		contentPane.add(lbltomato);
		
		JLabel lblCarrot = new JLabel("");
		lblCarrot.setBounds(132, 204, 68, 14);
		contentPane.add(lblCarrot);
		
		JLabel lblApple = new JLabel("");
		lblApple.setBounds(457, 122, 54, 18);
		contentPane.add(lblApple);
		
		JLabel lblKiwi = new JLabel("");
		lblKiwi.setBounds(457, 157, 54, 18);
		contentPane.add(lblKiwi);
		
		JLabel lblMandarin = new JLabel("");
		lblMandarin.setBounds(473, 195, 54, 14);
		contentPane.add(lblMandarin);
		
		JLabel lblBanana = new JLabel("");
		lblBanana.setBounds(473, 231, 54, 14);
		contentPane.add(lblBanana);
		
		JLabel lblPear = new JLabel("");
		lblPear.setBounds(479, 268, 54, 14);
		contentPane.add(lblPear);
		
		JLabel lblOnion = new JLabel("");
		lblOnion.setBounds(132, 235, 68, 14);
		contentPane.add(lblOnion);
		
		JLabel lblLettuce = new JLabel("");
		lblLettuce.setBounds(139, 272, 61, 14);
		contentPane.add(lblLettuce);

		
		JButton btnNewButton = new JButton("DisplayPrice");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//String[] itemarray = new String[]{"Apple","Carrot","Banana","Mango","Potato","Tomato"};
				
				ResultSet myresultset=null;
				PreparedStatement prepstmt;
				Connection myDBconnection =null;
								
				try {
					double Itemprice = 0;
					
					Class.forName("com.mysql.jdbc.Driver");
				   myDBconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/veggies","root","root");
					
				    System.out.println("Connected to DB");
				    
				    String sqlQuery=("SELECT * FROM veggies.productlist");

					 prepstmt = (PreparedStatement) myDBconnection.prepareStatement(sqlQuery);
					 					 		 
					 myresultset= prepstmt.executeQuery();
															 
					 while(myresultset.next()){
																												 
						if(myresultset.getString("Itemname").equals("Potato")){
							
						Itemprice=myresultset.getDouble("Price");
						lblPotato.setText(String.valueOf(Itemprice));
																	 				 				 				 			 
					 }
						if(myresultset.getString("Itemname").equals("Carrot")){
							
							Itemprice=myresultset.getDouble("Price");
	                        lblCarrot.setText(String.valueOf(Itemprice));
	                        
	                  												 				 				 				 			 
						 }
						
                           if(myresultset.getString("Itemname").equals("Tomato")){
							
                        	  Itemprice=myresultset.getDouble("Price");
	                        lbltomato.setText(String.valueOf(Itemprice));
	                        
						     
                           }
                           
                           if(myresultset.getString("Itemname").equals("Onion")){
   							
                         	  Itemprice=myresultset.getDouble("Price");
                         	 lblOnion.setText(String.valueOf(Itemprice));
 	                        
 						     
                            }
                           if(myresultset.getString("Itemname").equals("Lettuce")){
      							
                          	  Itemprice=myresultset.getDouble("Price");
                          	lblLettuce.setText(String.valueOf(Itemprice));
  	                       
  						     
                             }
                           
                          // if(myresultset.getString("Itemname").equals("Lettuce")){
     							
                           	 // Itemprice=myresultset.getDouble("Price");
                           	//lblLettuce.setText(String.valueOf(Itemprice));
   	                        
   						     
                             // }
                           
                           if(myresultset.getString("Itemname").equals("Apple")){
    							
                            	  Itemprice=myresultset.getDouble("Price");
                            	  lblApple.setText(String.valueOf(Itemprice));
    	                        
    						     
                               }
                           

                           if(myresultset.getString("Itemname").equals("Kiwi")){
    							
                            	  Itemprice=myresultset.getDouble("Price");
                            	  lblKiwi.setText(String.valueOf(Itemprice));
    	                        
    						     
                               }

                           if(myresultset.getString("Itemname").equals("Mandarin")){
    							
                            	  Itemprice=myresultset.getDouble("Price");
                            	  lblMandarin.setText(String.valueOf(Itemprice));
    	                        
    						     
                               }

                           if(myresultset.getString("Itemname").equals("Banana")){
    							
                            	  Itemprice=myresultset.getDouble("Price");
                            	  lblBanana.setText(String.valueOf(Itemprice));
    	                        //
    						     
                               }
                           if(myresultset.getString("Itemname").equals("Pear")){
   							
                         	  Itemprice=myresultset.getDouble("Price");
                         	 lblPear.setText(String.valueOf(Itemprice));
 	                         						     
                            }
                            
				 }
					 				    
				    			    
				} catch (ClassNotFoundException ex) {
				    throw new IllegalStateException("Cannot find the driver in the classpath!", ex);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
											
				
				
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton.setBounds(202, 343, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Price /KG $");
		lblNewLabel_3.setBounds(119, 101, 70, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Qunatity");
		lblNewLabel_4.setBounds(206, 101, 61, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Items");
		lblNewLabel_5.setBounds(36, 101, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		txtqntyPotato = new JTextField();
		txtqntyPotato.setBounds(216, 123, 35, 20);
		contentPane.add(txtqntyPotato);
		txtqntyPotato.setColumns(10);
		
		txtqntyTomato = new JTextField();
		txtqntyTomato.setColumns(10);
		txtqntyTomato.setBounds(217, 158, 35, 20);
		contentPane.add(txtqntyTomato);
		
		txtqntyCarrot = new JTextField();
		txtqntyCarrot.setColumns(10);
		txtqntyCarrot.setBounds(217, 196, 35, 20);
		contentPane.add(txtqntyCarrot);
		
		txtqntyOnion = new JTextField();
		txtqntyOnion.setColumns(10);
		txtqntyOnion.setBounds(216, 232, 35, 20);
		contentPane.add(txtqntyOnion);
		
		txtqntyLettuce = new JTextField();
		txtqntyLettuce.setColumns(10);
		txtqntyLettuce.setBounds(217, 269, 35, 20);
		contentPane.add(txtqntyLettuce);
		
		txtqntyApple = new JTextField();
		txtqntyApple.setColumns(10);
		txtqntyApple.setBounds(582, 123, 35, 20);
		contentPane.add(txtqntyApple);
		
		txtqntyKiwi = new JTextField();
		txtqntyKiwi.setColumns(10);
		txtqntyKiwi.setBounds(582, 158, 35, 20);
		contentPane.add(txtqntyKiwi);
		
		txtqntyMandarin = new JTextField();
		txtqntyMandarin.setColumns(10);
		txtqntyMandarin.setBounds(582, 196, 35, 20);
		contentPane.add(txtqntyMandarin);
		
		txtqntyBanana = new JTextField();
		txtqntyBanana.setColumns(10);
		txtqntyBanana.setBounds(582, 232, 35, 20);
		contentPane.add(txtqntyBanana);
		
		txtqntyPear = new JTextField();
		txtqntyPear.setColumns(10);
		txtqntyPear.setBounds(582, 269, 35, 20);
		contentPane.add(txtqntyPear);
		
		JLabel label = new JLabel("Items");
		label.setBounds(384, 93, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Price /KG $");
		label_1.setBounds(467, 93, 70, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Qunatity");
		label_2.setBounds(556, 93, 61, 14);
		contentPane.add(label_2);
				
		
	}
}




