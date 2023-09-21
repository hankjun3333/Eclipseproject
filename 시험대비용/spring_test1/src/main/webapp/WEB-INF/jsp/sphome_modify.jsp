<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<String> arr = (ArrayList<String>) request.getAttribute("list");
//out.print(arr);

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 내용 출력 및 수정 페이지!</title>
</head>
<body>
<form id="f" method="post" action="./sphome_modifyok.do">
<input type="hidden" name="midx" value="<%=arr.get(0)%>">
아이디 : <input type="text" name="mid" value="<%=arr.get(1)%>"><br>
이메일 : <input type="text" name="memail" value="<%=arr.get(2)%>"><br>
전화번호 : <input type="text" name="mtel" value="<%=arr.get(3)%>"><br>
나이: <input type="text" name="mage" value="<%=arr.get(4)%>"><br>
<br>
<input type="button" value="수정완료" onclick="modifyok()">
</form>
</body>
<script> 
function modifyok(){
	f.submit();
}
</script>
</html>