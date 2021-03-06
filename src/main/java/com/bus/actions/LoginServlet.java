package com.bus.actions;

import java.io.IOException;  
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("emailid");  
    String p=request.getParameter("pswrd");  
          
    if(UserDelegate.validateLogin(n, p)){  
        RequestDispatcher rd=request.getRequestDispatcher("myaccount.html");  
        rd.forward(request,response);  
       
    }  
    else{  
        out.print("Sorry username or password error");  
        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
        rd.include(request,response);  
    }  
          
    out.close();  
    }  
} 