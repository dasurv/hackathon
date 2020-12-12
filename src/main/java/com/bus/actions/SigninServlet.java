package com.bus.actions;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signinServlet")
public class SigninServlet extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("firstname");  
    String l=request.getParameter("surname");  
    String e=request.getParameter("email");  
    String p=request.getParameter("password");
    
    if(UserDelegate.signup(n,l,e,p)){  
        RequestDispatcher rd=request.getRequestDispatcher("sucessmsg.html");  
        rd.forward(request,response);  
    }  
    else{  
        out.print("Sorry, Registration Failed. Try Again Later");  
        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
        rd.include(request,response);  
    }  
          
    out.close();  
    }  


} 