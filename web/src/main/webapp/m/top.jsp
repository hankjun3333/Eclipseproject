<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String user_id ="";
	String user_name = "";
	try{
	user_id = session.getAttribute("perid").toString();
	user_name = session.getAttribute("pernm").toString();		
	}
	catch(Exception e){
	}
%>
<script>
function gopage(){
	location.href='./login.jsp';
}
</script>
<div>
<% if(user_id == ""|| user_id == null){ %>
<span onclick="gopage()">로그인</span>
<% } else { %>
<span><%=user_name%> 님 환영합니다. <a href="./mlogout.jsp">로그아웃</a></span>
<% } %>
</div>