package com.veggies.jnc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.PreparedStatement;

class connection{
	
		
	//String connectionurl= "jdbc:mysql://localhost:3306/veggies";
	 //String userid="root";
	//String pwd="root";
	
		ResultSet myresultset=null;
		Statement stmnt=null;
		PreparedStatement prepstmt;
		String query =null;
		Connection myDBconnection =null;
		
	void connecttoDB() throws SQLException{
		
					
			try {
			    Class.forName("com.mysql.jdbc.Driver");
			   myDBconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/veggies","root","root");
				
			   // myDBconnection = DriverManager.getConnection("connectionurl","userid","pwd");
			    System.out.println("Connected to DB");
			    			    
			} catch (ClassNotFoundException e) {
			    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
			}
		
		}
	
	boolean checkLogin(String username,String pwd){
		
		String urname=username;
		//System.out.println("UserName received from login page" + urname);
		String passwrd=pwd;
		//System.out.println("Password received from login page" + passwrd);
		boolean loginSuccess=true;
				
		try{
			

			//System.out.println("Database connected");

			stmnt = myDBconnection.createStatement();
			myresultset = stmnt.executeQuery("SELECT * FROM veggies.userregistration");
			
			while(myresultset.next()){
										
				if(myresultset.getString("UserName").equals(urname) && myresultset.getString("Password").equals(passwrd)){
					
					loginSuccess=true;
					break;
					
					}else{
						
						loginSuccess=false;
					}
				//myDBconnection.close();
							
				}
				
			}
			catch(Exception exc){
				exc.printStackTrace();
				
			}
				
		return loginSuccess;	
	}
	
	 boolean newUserRegistration(String Firstname,String LastName,String mailid,String usrname,String pwd,String confrimpwd,int phone ){
		
		
		boolean status=true;
		String frname=Firstname;
		String lstname=LastName;
		String maiidd=mailid;
		String usrnm =usrname;
		String passwd=pwd;
		String conpwd=confrimpwd;
		int Mob=phone;
		
				
		try{
			
			String sqlQuery=("INSERT INTO veggies.userregistration (FirstName,LastName,EMailID,UserName,Password,ConfirmPassword,Phone) VALUES(?,?,?,?,?,?,?)");

			 prepstmt = (PreparedStatement) myDBconnection.prepareStatement(sqlQuery);
			 
			 prepstmt.setString(1, frname);
			 prepstmt.setString(2, lstname);
			 prepstmt.setString(3, maiidd);
			 prepstmt.setString(4, usrnm);
			 prepstmt.setString(5, passwd);
			 prepstmt.setString(6, conpwd);
			 prepstmt.setLong(7, Mob);
			 		 
			 prepstmt.execute();
							
			status=true;
									
			}catch(Exception exc){
				exc.printStackTrace();
				
				status=false;
				
			}
	return status;
					
	}
	 
	 void insetTopurchase(String itemname,Double qnty,Double amnt){
		 
		 String varitemname=itemname;
		 Double varquantity=qnty;
		 Double varamount=amnt;
		 //String varusrname=usrname;
		 try{
				
				String sqlQuery=("INSERT INTO veggies.purchasetable (PurchasedItemName,Quantity,TotalAmount) VALUES(?,?,?)");
				//String sqlQuery=("INSERT INTO veggies.purchasetable (PurchasedItemName,Quantity) VALUES(?,?)");

				 prepstmt = (PreparedStatement) myDBconnection.prepareStatement(sqlQuery);
				 
				 prepstmt.setString(1, varitemname);
				 prepstmt.setDouble(2,varquantity);
				 prepstmt.setDouble(3, varamount);
				 //prepstmt.setString(4, varusrname);
						 		 
				 prepstmt.execute();
												
			}catch(Exception exc){
				exc.printStackTrace();
				
			}
		
	 }
 
}


public class StudyDBconnection {

	public static void main(String[] args) throws SQLException {
		
		// TODO Auto-generated method stub
		
		//connection obj = new connection();
		//obj.connecttoDB();
		//obj.getRecords("SELECT * FROM veggies.userregistration");

	}

}
