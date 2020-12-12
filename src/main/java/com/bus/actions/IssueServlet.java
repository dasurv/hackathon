package com.bus.actions;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

@WebServlet("/issueServlet")
public class IssueServlet extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String fname=request.getParameter("firstname");
	String lname=request.getParameter("lastname");
	String gender=request.getParameter("gender");
	String dob=request.getParameter("DOB");
	String type=request.getParameter("type");
	String aadharnum=request.getParameter("Aadhar number");
	String add=request.getParameter("Address");
	String city=request.getParameter("city");
	String pay=request.getParameter("payment");
	String f1=request.getParameter("fileToUpload1");
	String f2=request.getParameter("fileToUpload2");
    
    if(UserDelegate.issue(fname,lname,gender,dob,type,aadharnum,add,city,pay,f1,f2)){  
        RequestDispatcher rd=request.getRequestDispatcher("registration success.html");  
        rd.forward(request,response);  
    }  
    else{  
        out.print("Sorry, Upload Failed. Try Again Later");  
        RequestDispatcher rd=request.getRequestDispatcher("register.html");  
        rd.include(request,response);  
    }  
          
    out.close();  
    }  
} 