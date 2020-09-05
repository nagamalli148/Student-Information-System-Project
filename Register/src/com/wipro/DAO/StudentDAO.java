package com.wipro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wipro.bean.StudentBean;
import com.wipro.util.DBUtil;

public class StudentDAO {
public int StudentInsert(StudentBean sb) throws ClassNotFoundException, SQLException {
	Connection con=DBUtil.getConnection();
	String sql="Insert into student_reg values(?,?,?)";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1, sb.getRegno());
	ps.setString(2, sb.getName());
	ps.setString(3, sb.getEmail());
  int i=ps.executeUpdate();
  return i;
}
}
