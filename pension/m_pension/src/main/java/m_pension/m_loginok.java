package m_pension;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class m_loginok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PrintWriter pw = null;
	Connection con = null;
	PreparedStatement ps = null;
	HttpSession session = null;
	dbconfig db = null;
    public m_loginok() {
        super();
     
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String pid = request.getParameter("pid").intern();
		String ppass = request.getParameter("ppass").intern();
		//System.out.println("post 호출됨");
		this.pw =response.getWriter();		
		
		
		try {
			this.db = new dbconfig();
			Connection con = db.info();
			String sql = "select * from member_penson where pid=? and ppass=?";
			this.ps = con.prepareStatement(sql);
			ps.setString(1, pid);
			ps.setString(2, ppass);
			System.out.println(con);
			ResultSet result = this.ps.executeQuery();
			String user_id = null;
			String user_pw = null;
			while(result.next()) {
				user_id = result.getString("pid").intern();
				user_pw = result.getString("ppass").intern();
			}
			con.close();
			ps.close();
			if(pid == user_id && ppass== user_pw) {
				this.session = request.getSession();
				this.session.setAttribute("userid2", user_id);
				this.session.setAttribute("user_pw", user_pw);
				pw.write("<script>alert('해당사용자 오케이');location.href='./index.jsp';</script>");
			}
			else {
				pw.write("<script>alert('로그인 틀림');history.go(-1);</script>");
			}

		}
		catch(Exception e) {
			pw.write("<script>alert('정보 미확인');location.href='./index.jsp';</script>");
		}		
	}

}
