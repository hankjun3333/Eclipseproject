<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	/*
	trimDirectiveWhitespaces=false (out.print적용시 공백 적용)
	trimDirectiveWhitespaces=true -> JSP문법이 공백없이 결과값만 적용
	*/

	/* response.addHeader : CORS(도메인 다른경우 , 외부서버에서 접속을 할때 보안상 접속을 자동차단)
		- 접속허가 해주는 클래스
	*/
	response.addHeader("Access-Control-Allow-Origin", "*");
	response.addHeader("Access-Control-Allow-Credentails", "true");
	
	// intern() : 문자열을 연산기호로 조건문에 사용할 수 있도록 하는 클래스.
	String userId = request.getParameter("mid").intern();	
	String msg = "";
	// Database : select 로 row 확인작업.
	
	if(userId == "admin"){
		msg = "no";
	}else if(userId == ""){
		msg="error";
	}
	else{
		msg = "yes";
	}
	out.print(msg);		// ajax로 요청한 사항을 Front-end 에게 return 결과 값. 
%>