package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class login2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public login2() {
        super();
      
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		/*원래 응답 받아 처리하는 것은 외부로 빼서 관리해야 됨!*/
		//원래는 컨트롤러에 넣는것이 아니다!
		dbconfig db = new dbconfig();
		PreparedStatement ps = null;
		try { //dbconfig에 exception 걸려있으므로! try catch
			
			Connection con = db.dbinfo();
			
			/* 사용자가 입력한 패스워드를 sql 문법으로 변경하는 작업*/
			String password  = "select password('"+upw+"') as pwd"; //암호화 확인작업!
			//String password  = "select * from shop"; //암호화 확인작업!
			ps =con.prepareStatement(password);
			//excute() : = > boolean(0), int(x) , String(x) , 
			//excuteUpdate() : 애는 무조건 into 0 아님 1이기 떄문! //insert,update,delete,alter,create)
			//executeQuery() : select 전용 -> ResultSet result = ps.executeQuery(); (전용배열)
			ResultSet result = ps.executeQuery(); //ResultSet : select 된 값을 배열화 시켜주는 것!
			String user_pw = null;
			while(result.next()) { // result.next() => true, false 두가지가 나옴 boolean형태
				user_pw = result.getString("pwd"); // getString 안에 = 필드(컬럼)명!
			}
			con.close();
			/* 본격적인 사용자 아이디와 패스워드를 database 에서 가져오는 코드임! */
			Connection con2 = db.dbinfo();
			String sql = "select * from shop where sid=?"; //데이터 한개!
			ps = con2.prepareStatement(sql);
			ps.setString(1, uid);
			ResultSet result2 = ps.executeQuery();
			String sql_id = ""; //db에 저장된 사용자 아이디
			String sql_pw = ""; //db에 저장이 된 사용자 패스워드
			String sql_use = ""; //로그인 가능한지 Y/N으로 구분!
			while(result2.next()) { //database 에서 문자형 변수로 변환작업하는코드
				sql_id = result2.getString("sid");
				sql_pw = result2.getString("spw");
				sql_use = result2.getString("suse").intern(); //로그인허용유무
			}
			con2.close();
			ps.close();
			PrintWriter pw = response.getWriter();
			if(sql_id.intern() == "") { //sql 문법 실행시 해당 정보가 없을경우!
				pw.write("<script>alert('해당 사용자 정보를 확인하지 못하였습니다.'); "
						+ "history.go(-1);</script>");
			}
			else { //id가 확인이 되고 pw를 검토할때 사용!
				if(sql_pw.intern() == user_pw.intern()) {
					if(sql_use =="y") {
						
						pw.write("<script>alert('로그인 하셨습니다');</script>");
					}
					else {
						pw.write("<script>alert('관리자 권한으로 로그인하실 수 없습니다'); history.go(-1);</script>");
					}
				}
				else {
					pw.write("<script>alert('패스워드가 틀립니다.'); history.go(-1)</script>");
				}
			}
			pw.close();
			con2.close();
			ps.close();
		}
		catch(Exception e) {
			System.out.println("db접속 오류 발생");
			
			
		}

	}
}