package web;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class dbconfig {
	
	public static Connection info() throws Exception{
		String db_drive = "com.mysql.jdbc.Driver";
		String db_url = "jdbc:mysql://localhost:3306/web_example";
		String db_user = "hong";
		String db_pw = "a123456";
		Class.forName(db_drive);
		Connection con = DriverManager.getConnection(db_url,db_user,db_pw);
		return null;
	}
}
