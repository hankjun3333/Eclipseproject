package passloss;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class loss extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public loss() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String nm = request.getParameter("usernm").intern();
		String id = request.getParameter("userid").intern();
		String em = request.getParameter("userem").intern();
		//System.out.printf("%s %s %s",nm,id,em);
		
		String members[][] = {
				{"장진호","배유미","염무원","김승균","김경민","장진호","김경민"},
				{"jang_ho@nate.com","bae_mi@nate.com",
					"number1@gmail.com","kim@nate.com",
					"min@nate.com","ho@naver.com","k_min@gmail.com"},
				{"jang_ho","bae_mi","number1","kim","min","ho","k_min"}
		};
		
		int w =0;
		int ea = members[0].length;
		int count=0;
		String msg = "";
		while(w<ea) {
			if(nm==members[0][w]) {
				if(id==members[2][w]) {
					if(em==members[1][w]) {
						count=1;
						
						msg= "a123456입니다";
					}
				}
			}
			w++;
		}
		if(count==0) {
			msg= "<script>alert('해당 정보를 확인하지 못하였습니다.'); history.go(-1);</script>";
		}
		PrintWriter prw = response.getWriter();
		prw.write(msg);
		System.out.printf("%s\n",msg);
	}

}
