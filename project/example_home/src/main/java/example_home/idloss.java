package example_home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class idloss extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public idloss() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		String nm = request.getParameter("usernm").intern();
		String em = request.getParameter("userem").intern();
		//System.out.printf("%s %s",nm,em);
		
		String members[][] = {
				{"장진호","배유미","염무원","김승균","김경민","장진호","김경민"},
				{"jang_ho@nate.com","bae_mi@nate.com",
					"number1@gmail.com","kim@nate.com",
					"min@nate.com","ho@naver.com","k_min@gmail.com"},
				{"jang_ho","bae_mi","number1","kim","min","ho","k_min"}
		};
		/*
		  응용문제5.
		  아이디 찾기 기능을 완성 해야 하는데요! 배열 데이터 값을 확인하여 이름과 이메일이 동일한 정보 일 경우
		  결과값을 출력하며,만약 이름과 이메일 정보 중 틀릴경우 error라는 메세지를 콘솔로 출력합니다.
		 */
		int w =0;
		int count = 1;
		String msg = "";
		int ea = members[0].length;
		while(w< ea) {
			if(nm==members[0][w] && em==members[1][w]) {
				count = 1;
				msg = members[2][w];
			}
			w++;
		}
		if(count==0) {
			msg = "error";
		}
		PrintWriter prw = response.getWriter();
		prw.write(msg);
	}

}




