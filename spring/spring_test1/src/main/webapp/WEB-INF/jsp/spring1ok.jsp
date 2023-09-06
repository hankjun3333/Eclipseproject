<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spring1.html 에 대한 결과값을 출력 (view)</title>
</head>
<script>
	var data1 = "${code}";
	var data2 = "${name}";
	console.log(data1);
	console.log(data2);
	if(data1==""||data2==""){
		alert("올바른 접근 방식 아닙니다.");
		history.go(-1);
	}
</script>
<body>
상품코드 : ${code} <br>
상품 명 : ${name}
</body>
</html>