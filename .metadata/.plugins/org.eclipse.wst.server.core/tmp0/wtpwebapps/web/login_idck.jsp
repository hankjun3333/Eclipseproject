<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%> 
    
<%
	/* trimDirectiveWhitespaces 기본값은 false(out.print적용시 공백 적용)
		trimDirectiveWhitespaces 기본값은 true로 하게되면 JSP문법이 공백없이 결과값만 적용
		
	*/
	/* response.addHeader : CORS(도메인 다른경우, 외부 서버에서 접속을 할때 보안상 접속을 자동 차단하는 것) */
	/* 이걸 풀기 위해서 접속을 허가해주는 자바 클래스임 */
	response.addHeader("Access-Control-Allow-Origin","*");
	response.addHeader("Access-Control-Allow-Credentials", "true");
	
	//intern() : 문자열을 연산기호로 조건문에 사용할 수 있도록 하는 클래스
	String userid = request.getParameter("mid").intern(); //equals랑 같은것임 변수랑 문자열 비교해줌
	String msg = "";
	
	//Database : select 로 row 확인작업필요
	
	if(userid=="admin"){
		msg = "no";
	}
	else if(userid==""){
		msg="error";
	}
	else{
		msg = "yes";
	}
	out.print(msg); //프론트한테 ajax로 요청한 사항을 FRONT-end 에게 return 결과값
 %>