package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class cal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public cal() {
        super();    
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String a =request.getParameter("data1");
		String b =request.getParameter("data2");
		
		index in = new index();
		//문자값을 문자메소드로 전달 -> 최종 결과값을 문자로 받음 --Module에서 변환 및 계산
		//String result = in.test(a,b);
		
		
		//문자값을 숫자로 변환 후 - > Module로 값을 전달 후(계산등) 결과값을 문자로 받는 형태 --controller에서 변환
		String result = in.test2(Integer.parseInt(a),Integer.parseInt(b)); //결과값
		
		//Controller 에서 View로 가상의 객체명으로 전달 setAttribute 가상 객체 이름 total생성
		request.setAttribute("total", result); 
		
		String username = "홍길동";
		request.setAttribute("name", username);
		//RequestDispatcher : View 실제 파일을 로드하여 해당 Controller에서 보여지도록 하는 클래스이다.
		RequestDispatcher rd = request.getRequestDispatcher("./index2.jsp");
		//forward는 해당 결과값 및 데이터 값을 모두 View에 전달해줌
		rd.forward(request, response);
		//System.out.println(result);

	}

}
