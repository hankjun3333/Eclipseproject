package sp1;

import java.io.PrintWriter;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;

/*
 Thread를 잘쓰려면 -> 동기화 형태로 프로그램이 개발되어야 한다!
 web programmer 로 일할땐 thread 안씀 -> block/lock 이 되버림
 
  APP programmer 로 일할땐 thread 가능하단 것이군 
  
  
 */

public class login_etc extends Thread{
	Connection con = null;
	PreparedStatement ps = null;
	String a_id =""; //web일땐 mname
	String b_email =""; //web일땐 mpass
	String c_nick ="";
	String d_part ="";
	int oksign = 0;
	PrintWriter pw = null;
	//여기가 setter 부분
	public login_etc(String a , String b , String c, String part) {
		this.d_part = part;
		if(part.equals("web")) {
			this.a_id = a;
			this.b_email = b;
		}
		else {
			this.a_id = a;
			this.b_email = b;			
			this.c_nick = c;
			
		}
		this.start(); //Thread 시작! - 스레드로 db저장시킴
	}

	protected int result() {
		System.out.println("return 메소드 :" +this.oksign);
		return this.oksign;
	}
	@Override
	public void run() {//data저장!
		try {
			String pw = this.b_email;
			/*MessageDigest : 해당 문자열을 암호화 형태로 구성하는 클래스!*/
			//md5,sha-1 , sha-224 , sha-128 ,rmdud,sha-384 , sha-512
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(pw.getBytes()); //해당 암호화 bit로 변경작업
			byte[] se = md.digest(); //바이트로 저장!
			StringBuilder sb = new StringBuilder();
			for(byte s : se) {
				sb.append(String.format("%02x", s)); 
				//"%02x"2자리 문자로 전환
				//%01x 1자리 문자로 변환 : 1자리 출력 1,2,3,4
			}
			//insert 시 패스워드 저장은 sb 객체를 저장시킴
			
			
			this.con = new dbconfig().info();
			String sql = "insert into login values('0',?,?,?,?,?,?,now())";
			this.ps = this.con.prepareStatement(sql);
			this.ps.setString(1, this.d_part);
			this.ps.setString(2, this.a_id);
			this.ps.setString(3, this.a_id);
			this.ps.setString(4, sb.toString());
			this.ps.setString(5, this.b_email);
			this.ps.setString(6, this.c_nick);
			this.oksign = this.ps.executeUpdate();
			System.out.println("thread값 :" +this.oksign);
			
			/**/
			
			//직접 코드를 작성해보시길 바랍니다.
			
			this.ps.close();
			this.con.close();
		}
		catch(Exception e) {
			System.out.println("db오류 발생!");
			//System.out.println(e);
		}
	}
	
	
}
