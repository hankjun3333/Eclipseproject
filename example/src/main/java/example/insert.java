package example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class insert extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
    public insert() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//겟파라미터 form에서 같은네임일때 겟파라미터로 받으면안됨 첫번째 값만 받아오게됨
		//String user = request.getParameter(getServletName());// getParameterNames() 빨간불이 뜸 ---
		//Enumeration<String> user = request.getParameterNames(); 이렇게 안써도됨 이게맞긴하나
		//같은내용일땐 1차 배열로 받고 출력할땐 배열로 다 떄려버리자
		//즉 name값이 1개 이상 동일한 사항일 경우 getParameterValues 로 받아서 배열로 만들어 처리한다!!!!!!!!!!!!!!
		request.setCharacterEncoding("utf-8");
		
		String user[] = request.getParameterValues("user");
		ArrayList<String> arr = new ArrayList<String>();
		int w= 0;
		while(w<user.length) {
			if(user[w]!="") {
				arr.add(user[w]);
			}
			w++;
		};
		System.out.println(arr);
			
	}

}
