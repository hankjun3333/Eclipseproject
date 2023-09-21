<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품리뷰 간편등록 페이지</title>
</head>
<body>
<form id="f" method="post" action="./data_insert.do">
고객명 : <input type="text" name="rname"><br>
비밀번호 : <input type="password" name="rpass"><br>
리뷰 내용 : <textarea cols="200" rows="4" name="rtext"></textarea><br>
<input type="submit" value="간편리뷰 등록">
</form>
</body>
<script>
document.querySelector("#f").addEventListener("submit",function(s){
	s.preventDefault();
	if(f.rpass.value==""){
		alert("패스워드 입력하세요");
	}
	else{
		f.submit();
	}
	
});
</script>
</html>