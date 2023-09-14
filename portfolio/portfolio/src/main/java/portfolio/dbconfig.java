package portfolio;

import java.sql.Connection;
import java.sql.DriverManager;


public class dbconfig {

	public static Connection info() throws Exception{
		String db_drive = "com.mysql.jdbc.Driver";
		String db_url = "jdbc:mysql://umj7-022.cafe24.com/hankjun333"; //이건까페외부 db가져오는거임
		//String db_url = "jdbc:mysql://localhost/hankjun333"; //배포할떈 이걸로 해야됨!
		String db_user = "hankjun333";
		String db_pass = "";
		Class.forName(db_drive);
		Connection con = DriverManager.getConnection(db_url,db_user,db_pass);
		return con;
	}
}
