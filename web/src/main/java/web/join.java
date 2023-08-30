package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class join extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	dbconfig db = null;
	PreparedStatement ps = null;
    public join() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String sid = request.getParameter("sid").intern();
		String sname = request.getParameter("sname").intern();
		String spw = request.getParameter("spw").intern();
		String stel_c = request.getParameter("stel_c").intern();
		String stel = request.getParameter("stel").intern();
		String smail = request.getParameter("smail").intern();
		
		PrintWriter pw = response.getWriter(); //스크립트 출력할려고 사용!
		if(sid == "" || sname == "" || spw==""|| stel_c == "") {
			pw.write("<script>"
					+ "alert('올바른 정보가 전달되지 않았습니다.');"
					+ "history.go(-1);"
					+ "</script>");
		}
		else {
			//원래는 모듈에 쓰고 모듈걸 가져와야됨
			try {
				this.db = new dbconfig();
				Connection con = this.db.info();
				//System.out.println(con);
				/*람다식 형태의 코드로 작성 !!*/
				String sql = "insert into shop values("
						+"'0',?,?,password(?),?,?,?,'Y',now())"; //이런식으로 입력하는게 람다식 방식!
				this.ps=con.prepareStatement(sql);
				this.ps.setString(1, sid);
				this.ps.setString(2, sname);
				this.ps.setString(3, spw);
				this.ps.setString(4, stel_c);
				this.ps.setString(5, stel);
				this.ps.setString(6, smail);
				int call = this.ps.executeUpdate();
				String msg = "";
				
				if(call > 0) {
					msg = "정상적으로 가입이 완료 되었습니다.";
					this.ps.close();
					con.close();
				}
				else {
					msg = "가입이 원활하게 진행되지 않았습니다.";
				}
				pw.write("<script> alert('" +msg+ "'); location.href='./login.html';</script>");
				//Statement
				////callablestatement 가장 안정적!
				//callablestatement
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}

}
