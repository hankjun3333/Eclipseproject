package web;
//db환경설정

import java.sql.Connection;
import java.sql.DriverManager;
//String db_drive = "com.mysql.cj.jdbc.Driver"; //db 버전이 8점대나 높은 버전일때는! 이렇게 쓰야함
public class dbconfig {

	public static Connection dbinfo() throws Exception{
		String db_drive = "com.mysql.jdbc.Driver";
		String db_url = "jdbc:mysql://localhost:3306/web";
		String db_user = "hong";
		String db_pass = "a123456"; 
		Class.forName(db_drive);
		Connection con = DriverManager.getConnection(db_url,db_user,db_pass);
		return con;
	}
}
