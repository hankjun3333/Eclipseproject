<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<ArrayList<String>> mb = (ArrayList<ArrayList<String>>) request.getAttribute("member");
out.print(mb);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<thead>
<tr>
	<td>번호</td>
	<td>아이디</td>
	<td>이메일</td>
	<td>시간</td>
	<td>나이</td>
</tr>
</thead>
<tbody>
<tr>
<td></td>
</tr>
</tbody>
</table>
</body>
</html>