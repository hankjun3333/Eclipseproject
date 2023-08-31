<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
</html>
<% 
	session.invalidate();
%>
<script>
window.onload = function(){
	alert("정상적으로 로그아웃 되었습니다.");
	location.href='./index2.jsp';
}
</script>