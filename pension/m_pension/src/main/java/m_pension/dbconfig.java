package m_pension;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconfig {
	
	public static Connection info() throws Exception{
		
		String db_drive = "com.mysql.jdbc.Driver";
		String db_url = "jdbc:mysql://192.168.110.222:3306/pensonlife";
		String db_user = "penson";
		String db_pass = "pensonlife";
		Class.forName(db_drive);
		Connection con = DriverManager.getConnection(db_url,db_user,db_pass);
		return con;
	}
}
