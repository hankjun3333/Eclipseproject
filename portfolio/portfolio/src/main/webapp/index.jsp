<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�˻� �� �����</title>
</head>
<body>
<form id="f" method="post" action="./search.do">
�˻��� �Է� : <input type="text" name="search"><br>
<input type="button" value="�˻�" id="search">
</form>
</body>
<script>
document.querySelector("#search").addEventListener("click",function(){
	f.submit();
});
</script>
</html>