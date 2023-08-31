package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*실서버 말고 테스트 용으로만 @WebServlet("/userok.do") 이렇게씀*/
@WebServlet("/login/userok.do")
public class userok extends HttpServlet {
	PrintWriter pw = null;
	HttpSession session = null;
	private static final long serialVersionUID = 1L;
       
   
    public userok() {
        super();
       
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//uid , upass
		String id = request.getParameter("uid").intern();
		String pw = request.getParameter("upass").intern();
		this.pw = response.getWriter();
		if(id=="" || pw == "") {
			this.pw.write("<script>alert('정상적입 접근 방식이 아닙니다.')"
					+ "history.go(-1);"
					+ "</script>");
		}
		else {
			if(id=="hong" && pw =="a1234") {
				this.session = request.getSession();
				this.session.setAttribute("userid", id);
				this.session.setAttribute("username", "홍길동"); //세션에 저장!
				
				this.pw.write("<script>"
						+ "alert('로그인 되셨습니다');"
						+ "location.href='./main.jsp';"
						+ "</script>");
			}
			else {
				this.pw.write("<script>"
						+ "alert('회원정보가 확인되지 않습니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}
		}
		this.pw.close();
		
		
	}

}









