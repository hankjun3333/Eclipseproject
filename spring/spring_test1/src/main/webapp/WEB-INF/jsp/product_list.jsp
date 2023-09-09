<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<ArrayList<String>> al =(ArrayList<ArrayList<String>>)request.getAttribute("product_data");
out.print(al);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>상품코드</td>
				<td>상품명</td>
				<td>상품가격</td>
				<td>수정삭제</td>
			</tr>
		</thead>
	</table>
</body>
</html>