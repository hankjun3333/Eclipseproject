package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 응용문제1.
 모바일 login.jsp 에서 넘어온 아이디, 패스워드를 이용하여
 session을 통하여 정상적으로 로그인이 되도록 하며,
 로그인이 완료 되었을 경우! index2.jsp로 이동되도록 합니다.
 
  아이디 / 패스워드 (Free)
  단, session은 아이디와 이름 만 생성 합니다.
  session명은 다음과 같습니다.
  아이디 : perid
  이름 :  pernm
  아이디와 패스워드가 하나라도 미 일치시 "회원 정보를 다시 확인하세요 출력"
 */

@WebServlet("/m/mlogin.do")
public class mlogin extends HttpServlet {
	PrintWriter pw = null;
	HttpSession session = null;
	private static final long serialVersionUID = 1L;
       

    public mlogin() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("mid").intern();
		String pw = request.getParameter("mpass").intern();
		this.pw = response.getWriter();

			if(id=="hong" && pw =="a1234") {
				this.session = request.getSession();
				this.session.setAttribute("perid", id);
				this.session.setAttribute("pernm", "홍길동"); //여기에 패스워드 저장은 안됨! - 이름으로해야댐
				this.pw.write("<script>"
						+ "alert('로그인 되셨습니다');"
						+ "location.href='./index2.jsp';"
						+ "</script>");				
			}
			else {
				this.pw.write("<script>"
						+ "alert('회원정보를 다시 확인해주세요.');"
						+ "history.go(-1);"
						+ "</script>");
			}			
		
		this.pw.close();
	}

}
