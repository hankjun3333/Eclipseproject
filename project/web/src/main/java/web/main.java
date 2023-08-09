package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Controller 파트 servlet으로 만듬

public class main extends HttpServlet {
	//웹 통신에 사용하기 위한 암호화된 페이지 명시를 한 메모리 형태의 명령어 건드릴필요는없음
	private static final long serialVersionUID = 1L;
       
	//클래스명 메소드명 동일은 클래스호출하자마자 바로 실행됨
    public main() {
        super();

    }
    //doGet = > method GET전송시
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a = request.getParameter("data");
		System.out.println(a);
	}*/
	
	// doPost => method POST전송시
	/*
	 * 
	 HttpServletRequest : Front에서 값을 넘겨받는 통신 언어임 
	 HttpServletResponse : 결과값을 출력 또는 Front로 return하는 통신 언어임
	 getParameter : Front에서 사용 하는 name명 입니다. (모든 데이터는 문자열 String 또는 Boolean 형태로 구성됨)
	 
	  */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a = request.getParameter("data");
		System.out.println(a);
	
	}

}
