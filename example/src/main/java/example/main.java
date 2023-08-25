package example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;


public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public main() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter prw = response.getWriter();
		String id = request.getParameter("userid").intern();
		String pw = request.getParameter("userpw").intern();
		//System.out.printf("%s %s",id,pw);
		
		
		String list[] = {"hong","kim","park","apink"};
		String passwd[] = {"a1234","b1234","c1234","apink"};
		
		/*
		 응용문제 1번 
		 해당 2개의 배열을 이용하여 다음과 같은 결과값으로 출력 되도록 하시오.
		 예시)
		 hong
		 a1234
		 kim
		 b1234 이런식으로
		 park
		 c1234 
		 */
		
		/*
		 * String memberlist[][]= { {"hong","kim","park","apink"},
		 * {"a1234","b1234","c1234","apink"} };
		 * 
		 * int i, k ; for(k=0; k<memberlist[0].length; k++) { for(i=0;
		 * i<memberlist.length; i++) { //System.out.println(memberlist[i][k]); //이걸 IO
		 * 라고 함 자바스크립트 외에도 사용한다. 지금은 스크립트 용만씀 } }
		 * response.setContentType("text/html; charset=utf-8"); PrintWriter pw =
		 * response.getWriter(); pw.write("<script>alert('가입되지 않는 사용자 입니다');</script>");
		 */
		
		/*
		 * 응용문제 2번 아이디 및 패스워드가 동일 할 경우 로그인 되셨습니다. 메세지 출력 
		 * 단, 아이디가 없을 경우 가입되지 않은 사용자 메세지
		 * 출력 패스워드가 틀릴경우 해당 패스워드를 확인하세요 메세지 출력
		 */
		
		  String msg ="";
		  int w =0; 
		  int count = 0; //아이디 유/무
		  while(w<list.length) {
			  if(id == list[w]) { //아이디가 배열값에 있을 경우
				  if(pw == passwd[w]) { // 패스워드가 동일할때
					  count = 1; //아이디가 있을경우 1로 변경
					  msg = "<script>alert('로그인 되셨습니다.');</script>";
					  break;
				  }
				  else {
					  msg = "<script>alert('비밀번호가 틀립니다.'); history.go(-1);</script>";
					  break;
				  } 
			  }
			  w++;
			  if(count==0){ //아이디 없을때
				  //history.go(-1); 이건 가입되지 않는 alert창 나오면 1페이지 전단계 페이지로 가는 스크립트 언어임
				  //history.go(-2); 이건 전전단계
				  msg = "<script>alert('가입되지 않은 사용자입니다.'); history.go(-1);</script>";
			  }

		  }
		  prw.write(msg);
		  	  
	}
	
}
