<%@page import="com.sun.xml.internal.bind.CycleRecoverable.Context"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert an Image into MySQL Database</title>
    </head>
    <body>
         <%
Connection conn=null;
PreparedStatement pstmt = null;
ResultSet rs=null;
String url="jdbc:mysql://localhost:3306/buspassregistration";
FileInputStream fis=null;
String fname=request.getParameter("firstname");
String lname=request.getParameter("lastname");
String email=request.getParameter("gender");
String dob=request.getParameter("DOB");
String type=request.getParameter("type");
String aadharnum=request.getParameter("Aadhar number");
String add=request.getParameter("Address");
String city=request.getParameter("city");
String pay=request.getParameter("payment");
String f1=request.getParameter("fileToUpload1");
String f2=request.getParameter("fileToUpload2");

//out.print("First Name :"+fname+"myloc="+myloc);
try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
conn=DriverManager.getConnection(url, "root", "Moonstar@123");
File image1= new File(f1);
File image2= new File(f2);

pstmt = conn.prepareStatement("insert into UserDetails(user_id,user_firstname,user_lastname ,gender,user_dob , pass_type,user_aadhar, user_address, user_place,paymentmode,user_idproof, user_ageproof,registered_date,applied_date,due_date,created_at,updated_at ) " 
+ "values(?,?,?,?)");
pstmt.setString(1, fname);
pstmt.setString(2, lname);
pstmt.setString(4, email);

fis=new FileInputStream(image1);
pstmt.setBinaryStream(3, (InputStream) fis, (int) (image1.length()));
int count = pstmt.executeUpdate();
if(count>0)
{
out.println("insert successfully");
}
else
{
out.println("not successfully");
}

fis=new FileInputStream(image2);
pstmt.setBinaryStream(3, (InputStream) fis, (int) (image2.length()));
int count1 = pstmt.executeUpdate();
if(count1>0)
{
out.println("insert successfully");
}
else
{
out.println("not successfully");
}

}
catch(Exception ex)
{
ex.printStackTrace();
}
finally{
try{
if(rs!=null){
rs.close();
rs= null;
}
if(pstmt !=null)
{
pstmt.close();
pstmt=null;
}
if(conn!=null)
{
conn.close();
conn=null;
}
}
catch(Exception e)
{
e.printStackTrace();
}
}
%>
    </body>
</html>