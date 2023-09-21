<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="f" method="post" action="./loginok.do">	
아이디 : <input type="text" name="rid"><br>
비밀번호 : <input type="password" name="rpass"><br>
<input type="button" value="로그인" onclick="login()">
</form>

</body>
<script>
	function login(){
		if(f.rid.value==""){
			alert("아이디 입력바람");
		}
		else if(f.rid.value!="hong"){
			alert("아이디가 맞지 않음");
		}
		else if(f.rpass.value==""){
			alert("비번입력바람");
		}
		else if(f.rpass.value!="a1234"){
			alert("비번이 틀림");
		}
		else {
			f.submit();
		}
	}
	
</script>
</html>