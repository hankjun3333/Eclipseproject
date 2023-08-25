package example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class idloss extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public idloss() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//java , servlet, spring 모두 한글 형태가 출력이 안됨(웹상태에서) --정상적인 상황
		//web을 쓰려면 두가지 단어는 무조건 따라가야함====
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String usernm = request.getParameter("usernm").intern();
		String useremail = request.getParameter("useremail").intern();
		//System.out.println(usernm + useremail);
		
		/*
		  응용문제5.
		  아이디 찾기 기능을 완성 해야 하는데요! 배열 데이터 값을 확인하여 이름과 이메일이 동일한 정보 일 경우
		  결과값을 출력하며,만약 이름과 이메일 정보 중 틀릴경우 error라는 메세지를 콘솔로 출력합니다.
		 */
		String members[][] = {
				{"장진호","배유미","염무원","김승균","김경민","장진호","김경민"},
				{"jang_ho@nate.com","bae_mi@nate.com",
					"number1@gmail.com","kim@nate.com",
					"min@nate.com","ho@naver.com","k_min@gmail.com"},
				{"jang_ho","bae_mi","number1","kim","min","ho","k_min"}
		};
		int ea = members[0].length; //7
		int w =0;
		int count = 0; //데이터 확인 후 동일 한 결과일 경우 1로 없을경우는 0으로
		String msg ="";
		while(w<ea) {
			if(usernm == members[0][w]) {
				//System.out.println(members[0][w]); // 장진호 2명 동일 이름 2명
				if(useremail == members[1][w]) { //이름, 이메일까지 같을때 count = 1 해줌
					count =1; //이름과 이메일이 동일 할 경우 카운팅 값을 변화시킴
					msg = members[2][w]; //해당 아이디 데이터를 문자열 변수에 삽입
					break;
				}

				
			}
			else { //이름을 찾았는데 없는 경우
				count = 0;
			}
			w++;
		}
		if(count==0) { //해당 배열에 조건이 아무 것도 매칭이 되지 않을 경우 사용
			msg = "error";
		}
		//System.out.println(msg);
		PrintWriter pw = response.getWriter();
		pw.write(msg);
	}

}












