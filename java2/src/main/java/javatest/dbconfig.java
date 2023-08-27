package javatest;

import java.sql.*;
//database 기본 정보 클래스!
public class dbconfig{
	public static Connection info() throws Exception{
		String db_drive = "com.mysql.jdbc.Driver";
		String db_url = "jdbc:mysql://localhost:3306/client";
		String db_user = "pbj";
		String db_pass = "a1234"; 
		Class.forName(db_drive);
		Connection con = DriverManager.getConnection(db_url,db_user,db_pass);
		return con;
	}
}
