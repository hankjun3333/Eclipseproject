package javatest;

import java.sql.Connection;
import java.sql.DriverManager;

//java 17번에 활용할 db정보 인터페이스 + 각종 문법들! 

public interface setdb {
	//String user = ""; //interface는 필드에 변수 선언시 상수화 되어버림!
	public void dbconnect(String user, String passwd,String db) throws Exception; 
	public void select(String table,String dataid) throws Exception;
	/*
	public void delete(int idx);
	public void update(String dataid, int idx);
	public void insert(String[] a);
	*/
	
	
	//exception을 try catch로 받기위한 임시 메소드 선언 -
	public static Connection info(String user, String passwd,String db) throws Exception{ //db통신이니까 static 선언
		String db_driver = "com.mysql.jdbc.Driver";
		String db_url = "jdbc:mysql://localhost:3306/"+db; //url 주소나 db_driver도 다 변수로 바꿀수도 있겠지
		String db_user = user;
		String db_pass = passwd;
		Class.forName(db_driver);
		Connection con = DriverManager.getConnection(db_url,db_user,db_pass);
		return con;
	}
}
