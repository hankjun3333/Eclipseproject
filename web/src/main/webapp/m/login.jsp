<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width-device-width" initial-scale="1.0">
<title>모바일 로그인 페이지</title>
<script>
function login(){
/* 	if(f.mid.value==""){ //이거 안쓰고 아이디 : <input type="text" name="mid" required="required"><br> 이거쓰면댐
		alert("아이디를 입력해주세요");
	} */
}
</script>
</head>
<body>

<header> <!-- 메뉴 or 로그인 기능! -->
<%@ include file = "./top.jsp" %>
</header>
<form name="f" method="post" action="./mlogin.do">
<section> <!--  서브페이지, 배너 등등 주요 내용들포함 -->
<p>Member-Login</p>
아이디 : <input type="text" name="mid" required="required"><br>
패스워드 : <input type="password" name="mpass" required="required"><br> <!-- 필수로 입력되야 작동하는 값! - 자바스크립트안써도됨 P,M둘다 -->
<button type="submit">로그인</button>
</section>
</form>
<footer> <!-- copyright -->
<%@ include file = "./copywrite.jsp" %>
</footer>

</body>
<script>
var id ="<%=user_id %>"; //jsp코드에 쌍따옴표 붙여줘야 읽어줌 이건 자바스크립트 코드가 아니므로
var nm = "<%=user_name %>";
console.log(id);
console.log(nm);
if(id != ""){
	location.href='./index2.jsp';
}
</script>
</html>




