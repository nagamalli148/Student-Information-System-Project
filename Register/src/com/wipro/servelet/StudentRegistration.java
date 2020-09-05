package com.wipro.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.DAO.StudentDAO;
import com.wipro.bean.StudentBean;

/**
 * Servlet implementation class StudentRegistration
 */
@WebServlet("/StudentRegistration")
public class StudentRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegistration() {
 
        // TODO Auto-generated constructor stub
    }	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String no=req.getParameter("no");
		//PrintWriter pw=res.getWriter();
		//pw.print(no);
		StudentBean st=new StudentBean(); 
		st.setRegno(Integer.parseInt(req.getParameter("no")));
		st.setName(req.getParameter("name"));
		st.setEmail(req.getParameter("mail"));
		
		StudentDAO sd=new StudentDAO();
		try {
			int validate=sd.StudentInsert(st);
			if(validate>0) {
				req.setAttribute("studentbean", st);
				RequestDispatcher rd=req.getRequestDispatcher("StudentDisplay");
				rd.forward(req, res);
			}
			else {
				RequestDispatcher rd=req.getRequestDispatcher("fail.html");
				rd.include(req, res);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
