package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cal")
public class cal extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public cal() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a = request.getParameter("data1");
		String b = request.getParameter("data2");
		
		index in = new index();
		// 문자값을 문자 메소드로 전달 -> 최종 결과값을 문자로 받음.
		//String result = in.test(a,b);
		
		// 문자값을 숫자로 변환 후 -> Module로 값을 전달 후 결과값을 문자로 받는 형태
		int aa = Integer.parseInt(a);
		int bb = Integer.parseInt(b);
		String result = in.test2(aa, bb);	// 결과값
		
		request.setAttribute("total", result);	// Controller -> View 가상의 객체명으로 전달.
		
		String username = "홍길동";
		request.setAttribute("name", username);
		
		// RequestDispatcher : View 실제 파일을 로드하여 해당 Controller에서 보여지도록 하는 클래스
		RequestDispatcher rd = request.getRequestDispatcher("./index2.jsp");
		// 해당 결과값 및 데이터 값을 모두 View에 전달함.
		rd.forward(request, response);
	}
	
	
	
	
}
