<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--컨트롤러가 LinkedList이면 LinkedList로 여기서 받아야 함! -->
   <!-- 컨트롤러에서 Attribute 사용시 자료형에 맞는 구조를 생성하여 getAttribute로 로드해아함 --> 
<%
//일반 JSP로 받는 형태! ArrayList니까 캐스팅 해줘야됨
ArrayList<String> al =(ArrayList<String>)request.getAttribute("person_list");
//out.print(al);

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring 3일차 - Controller에서 view 배열값 출력! (jsp)</title>
</head>
<body>
<p>고객명 리스트</p>
<%
int w = 0;
while(w<al.size()){
	out.print("<li>"+al.get(w)+"</li>");
	w++;
}
%>
<ul>

</ul>
</body>
</html>