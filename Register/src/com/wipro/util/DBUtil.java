package com.wipro.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static final String classfor="oracle.jdbc.driver.OracleDriver";
	public static final String jdb="jdbc:oracle:thin:@localhost:1521:XE";
	public static final String username="system";
	public static final String password="lakshmich";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
	Class.forName(classfor);
    Connection con=DriverManager.getConnection(jdb,username,password);	
    return con;
}
}
