<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<title>페이지 2번 접근형태-sessionStorage + get파라미터</title>
</head>
<body>
<input type="button" value="클릭" onclick="abc()">
</body>
<script>
var today = "";
var data = "";
	
	today = Date.now();
	data = sessionStorage.setItem("time",today);
	console.log(today);
	
	/*이상태에서 기존 index2.jsp만 닫히게만하면됨*/
	//window.open 팝업창 띄우는 것
	function abc(){
		window.open("./index3.jsp?days= "+ today,"","");
		location.href="./login.html";
	}
</script>
</html>