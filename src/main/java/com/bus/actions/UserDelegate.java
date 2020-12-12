package com.bus.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;  
  
public class UserDelegate {  
	
	public static String jdbcURL = "jdbc:mysql://localhost:3306/buspassregistration";
	public static String dbUser = "root";
	public static String dbPassword = "Moonstar@123";
	public static Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
public static boolean validateLogin(String name,String pass){  
	boolean status=false;  

	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(jdbcURL, dbUser, dbPassword);  
      
		PreparedStatement ps=con.prepareStatement("select * from UserDetails where user_email=? and user_pswd=?");  
		ps.setString(1,name);  
		ps.setString(2,pass);  
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
          
	}catch(Exception e){
		System.out.println(e);
	}  
	
	return status;  
}

public static boolean signup(String user_name, String user_lastname, String email_id, String password) {
	boolean status=false;
	
	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(jdbcURL, dbUser, dbPassword);  
		
		String sql = "INSERT INTO UserDetails(user_firstname,user_lastname,user_email,user_pswd,registered_date,created_at,updated_at)"
				+ " VALUES ('"+user_name+"','"+user_lastname+"','"+email_id+"','"+password+"','"+timestamp+"','"+timestamp+"','"+timestamp+"')";
		Statement stmt = con.createStatement();
		System.out.println("sql"+sql);
		stmt.executeUpdate(sql);
		System.out.println("Database updated successfully ");
		//status = true;  
        
		PreparedStatement ps=con.prepareStatement("select user_id from UserDetails where user_email=? and user_pswd=?");  
		ps.setString(1,email_id);  
		ps.setString(2,password);  
		ResultSet rs=ps.executeQuery();  
		System.out.println("id:"+rs);
		status=rs.next();  
		
	}catch(Exception e){
		System.out.println(e);
	}
	return status;
}

public static boolean issue(String fname,String lname,String gender,String dob,String type,String aadharnum,String add,String city,String pay,String f1,String f2) {
	boolean status=false;
	
	FileInputStream fis=null;
	
	try{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection con=DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
	
	File image1= new File(f1);
	File image2= new File(f2);

	PreparedStatement pstmt = con.prepareStatement("insert into UserDetails(user_firstname,user_lastname ,gender,user_dob , pass_type,user_aadhar, user_address, user_place,paymentmode,user_idproof, user_ageproof,registered_date,applied_date,due_date,created_at,updated_at ) " 
	+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	
	pstmt.setString(1, fname);
	pstmt.setString(2, lname);
	pstmt.setString(3, gender);
	pstmt.setString(4, dob);
	pstmt.setString(5, type);
	pstmt.setString(6, aadharnum);
	pstmt.setString(7, add);
	pstmt.setString(8, city);
	pstmt.setString(9, pay);
	pstmt.setString(10, f1 );
	pstmt.setString(11, f2);
	pstmt.setTimestamp(12, timestamp);
	pstmt.setTimestamp(13, timestamp);
	pstmt.setTimestamp(14, timestamp);
	pstmt.setTimestamp(15, timestamp);
	pstmt.setTimestamp(16, timestamp);
	
	fis=new FileInputStream(image1);
	pstmt.setBinaryStream(3, (InputStream) fis, (int) (image1.length()));
	int count = pstmt.executeUpdate();
	if(count>0)
	{
	System.out.println("insert successfully");
	}
	else
	{
	System.out.println("not successfully");
	}

	fis=new FileInputStream(image2);
	pstmt.setBinaryStream(3, (InputStream) fis, (int) (image2.length()));
	int count1 = pstmt.executeUpdate();
	if(count1>0)
	{
		System.out.println("insert successfully");
	}
	else
	{
	System.out.println("not successfully");
	}

	}catch(Exception ex)
	{
		ex.printStackTrace();
		}
		

	return status;
}

public static boolean renew(String pNum) {  
	boolean status=false;  

	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(jdbcURL, dbUser, dbPassword);  
      
		PreparedStatement ps=con.prepareStatement("select * from UserDetails where user_id=?");  
		ps.setString(1,pNum);  
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
          
	}catch(Exception e){
		System.out.println(e);
	}  
	
	return status;  
}


}  
