package javatest;

import java.sql.Connection;

//외부 db정보 클래스를 로드하여 연결하기  외부 db정보 클래스가 exception이므로 try,catch!
public class db_test3 {

	public static void main(String[] args) {
		try {
			dbconfig db = new dbconfig();
			Connection con = db.info(); //Interface로 가져와야됨
			System.out.println(con.toString());
		}
		catch(Exception e) {
			System.out.println("db 접속 오류");
		}

	}

}
