<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width-device-width" initial-scale="1.0">
<title>모바일 웹페이지</title>
</head>
<body>

<header> <!-- 메뉴 or 로그인 기능! -->
<%@ include file = "./top.jsp" %>
</header>

<section> <!--  서브페이지, 배너 등등 주요 내용들포함 -->
<%@ include file = "./reserve.jsp" %>
</section>

<footer> <!-- copyright -->
<%@ include file = "./copywrite.jsp" %>
</footer>

</body>
</html>