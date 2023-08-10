package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Controller ( Servlet )
public class main extends HttpServlet {
	// 웹 통신에 사용하기 위한 암호화된 페이지 명시한 메모리 형태의 명령어
	private static final long serialVersionUID = 1L;
       
    public main() {
        super();
    }

    // doGet -> method GET 전송
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String a = request.getParameter("data");
//		System.out.println(a);
//	}
	/*
	 * HTTPServletRequest : Front에서 값을 넘겨 받는 통신 언어.
	 * HttpServletResponse : 결과값을 출력 또는 Front로 return 하는 통신 언어.
	 * getParameter : Front에 사용하는 name 명. (모든 데이터는 문자 or Boolean 형태로 구성)
	 * */
    
	// doPost -> method POST 전송
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a = request.getParameter("data");
		System.out.println(a);
	}
	

}
