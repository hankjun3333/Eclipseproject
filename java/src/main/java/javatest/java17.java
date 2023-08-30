package javatest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/*interface 활용2*/
public class java17 {

	public static void main(String[] args) {
		try {
			box7 bx = new box7();
			//new 인스턴스 활용이 필요함 
			/*
			 new box7().dbconnect("hong", "a123456", "web");
			 new box7().select("hong", "a123456", "web"); 
			 이렇게 인스턴스 생성 없이 바로 실행시켜버리면
			 dbconnect, select 메소드가 별도로 적용이 됨
			 그래서 객체를 만들어서 실행을 시켜야함! - 이런 기본 중요함! 
			 */
			bx.dbconnect("hong", "a123456", "web");	
			bx.select("board","hongid");
		}
		catch(Exception e) {
			System.out.println("db정보가 올바르지 않습니다.");
		}
	}

}
//오버라이드 필수조건이 안되어버림 interface 내부에 (exception 쓰면)
//인터페이스는 객체 생성시 Connection con = setdb.info(); new를쓰지않음,
//클래스는 Connection con = new setdb.info();
//인터페이스에 exception 처리를 했을땐 별도 메소드를 오버라이딩 받아서 거기 안에
class box7 implements setdb {
	

	//인터페이스 해당 필드에 사용되는 변수는 finaml 형태로 상수화 되어버리는 상황입니다.
	Connection con = null;
	PreparedStatement ps = null;
	String user = "";
	@Override
	public void dbconnect(String user, String passwd, String db) throws Exception{
		this.user = user;
		//System.out.println(user);
		this.con= setdb.info(user,passwd,db);
		System.out.println(con);
	}
	@Override
	public void select(String table, String dataid) {
		try {
			//System.out.println(con);
			String sql = "select * from "+table+" where bid=?";
			this.ps = this.con.prepareStatement(sql);
			//this.ps.setString(1, table);
			this.ps.setString(1, dataid);
			ResultSet rs = this.ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("btitle"));
				System.out.println(rs.getString("buser"));
				System.out.println(rs.getString("bpw"));
			}
			this.ps.close();
			this.con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	

	
}