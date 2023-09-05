<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String shopping_id = "";
	String shopping_name = "";
	try{
	shopping_id = session.getAttribute("userid").toString();
	shopping_name = session.getAttribute("username").toString();
	}
	catch(NullPointerException e){
		
	}
	finally{
		//out.print("<script>alert('올바른 접근이 아닙니다'); location.href='./login.jsp'</script>");
		/*그 페이지 그냥 유지하고 싶을때*/
		
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지(Session 체크)</title>
</head>
<script>
function logout(){
	location.href='./logout.jsp';
}
</script>
<body>
아이디 : <%=shopping_id %><br>
고객명 : <%=shopping_name %><br>
<input type="button" value="로그아웃" onclick="logout()">
</body>
</html>