<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
 String title = "jsp로 출력하기";
 int point = 5000;
 String name = "홍길동";
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=title%></title>
</head>
<body>
 	고객명 : <%=name%> <br>
 	<%@ include file = "/index2.jsp" %>
</body>
</html>