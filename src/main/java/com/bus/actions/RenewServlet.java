package com.bus.actions;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

@WebServlet("/renewServlet")
public class RenewServlet extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String pNum=request.getParameter("Pass number");
	   
    if(UserDelegate.renew(pNum)){  
        RequestDispatcher rd=request.getRequestDispatcher("renewal success.html");  
        rd.forward(request,response);  
    }  
    else{  
        out.print("Sorry, Upload Failed. Try Again Later");  
        RequestDispatcher rd=request.getRequestDispatcher("Renewal.html");  
        rd.include(request,response);  
    }  
          
    out.close();  
    }  
} 