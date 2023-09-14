<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>db저장 화면</title>
</head>
<body>
<form onsubmit="return insert()" id="f" method="post" action="./sphome_insertok.do">
<input type="hidden" name="midx" value="">
아이디 : <input type="text" name="mid"><br>
이메일 : <input type="text" name="memail"><br>
전화번호 : <input type="text" name="mtel"><br>
나이: <input type="text" name="mage"><br>
<br>
<input type="submit" value="데이터 입력!">
</form>
</body>
<script>
function insert(){
	if(f.mid.value==""){
		alert("아이디를 입력바람");
		return false;
	}
	else if(f.memail.value==""){
		alert("이메일 입력바람");
		return false;
	}
	else if(f.memail.value.indexOf('@') == -1){
		alert("올바른 이메일 입력바람");
		return false;
	}
	else if(f.mtel.value==""){
		alert("전화번호 입력바람");
		return false;
	}
	else{
		return;
	}
}
</script>
</html>