<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Session을 이용한 로그인 방식!</title>
</head>
<script>
function login(){
	if(f.uid.value==""){
		alert("아이디를 입력하세요");
		f.uid.focus();
		return false;
	}
	else if(f.upass.value==""){
		alert("패스워드를 입력하세요");
		f.upass.focus();
		return false;
	}
	else{
		return;
	}
}
</script>
<body>
<form onsubmit="return login()" id="f" method="post" action="./userok.do">
아이디 : <input type="text" name="uid"><br>
패스워드 : <input type="password" name="upass"> <br>
<input type="submit" value="로그인">
</form>


</body>
</html>