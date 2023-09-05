package m_pension;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class join_ok extends HttpServlet {
	PrintWriter pw = null;
	dbconfig db  = null;
	PreparedStatement ps = null;
	private static final long serialVersionUID = 1L;

    public join_ok() {
        super();
       
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String pid = request.getParameter("pid").intern();
		String pname = request.getParameter("pname").intern();
		String ppass = request.getParameter("ppass").intern();
		String pemail = request.getParameter("pemail").intern();
		String ptel = request.getParameter("ptel").intern();
		
		pw = response.getWriter();
		if(pid == ""|| pname==""||ppass==""||pemail==""||ptel=="") {
			pw.write("<script>alert('정보가 입력안됬어요');history.go(-1);</script>");
		}
		else {
			try {
				this.db = new dbconfig();
				Connection con= db.info();
				System.out.println(con);
				String msg = "";
				String sql = "insert into member_penson values("
						+ "'0',?,?,?,?,?,now())";
				this.ps=con.prepareStatement(sql);
				this.ps.setString(1, pid);
				this.ps.setString(2, pname);
				this.ps.setString(3, ppass);
				this.ps.setString(4, pemail);
				this.ps.setString(5, ptel);
				int call = this.ps.executeUpdate();
				if(call>0) {
					msg = "정상적으로 가입이 완료되었습니다.";
					pw.write("<script>alert('"+ msg +"');location.href='./index.jsp';</script>");
				}
				else {
					msg = "db 저장오류";
					pw.write("<script>alert('"+ msg +"');history.go(-1);</script>");
				}
				this.ps.close();
				con.close();
				pw.close();
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	
	
	}

}
