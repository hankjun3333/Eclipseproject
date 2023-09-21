package sp1;
//Database 환경설정 

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconfig {
	
	public static Connection info() throws Exception{
		String db_drive = "com.mysql.jdbc.Driver";
		String db_url = "jdbc:mysql://umj7-022.cafe24.com/hankjun333";
		//String db_url = "jdbc:mysql://localhost/hankjun333";
		String db_user = "hankjun333";
		String db_pass = "Qkrqudwns12@";
		Class.forName(db_drive);
		Connection con = DriverManager.getConnection(db_url,db_user,db_pass);
		return con;
	}
}
