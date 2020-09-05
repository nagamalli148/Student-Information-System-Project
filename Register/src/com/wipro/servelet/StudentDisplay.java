package com.wipro.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.bean.StudentBean;

/**
 * Servlet implementation class StudentDisplay
 */
@WebServlet("/StudentDisplay")
public class StudentDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDisplay() {
  
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  PrintWriter pw=res.getWriter();
		StudentBean sb=(StudentBean) req.getAttribute("studentbean");
	  
	   try {
	    pw.print("<h1> Welcome to Student Information </h1>");
	    pw.print("Name of the Student:"+sb.getName()+"<br>");
	    pw.print("Email of the Student:"+sb.getEmail()+"<br>");
	}
finally {
	pw.close();
}
}
}
