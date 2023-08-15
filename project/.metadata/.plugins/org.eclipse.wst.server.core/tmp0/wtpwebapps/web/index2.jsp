<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과값 출력 View 파트</title>
</head>
<body>

<!-- 
request.getAttribute : Controller 에서 가상 객체명을 받아서 출력하는 메소드입니다.
실제 파일은 감춰짐 (보안상)
 -->
결과값 : <%=request.getAttribute("total") %> <br>

고객명 : <%=request.getAttribute("name") %>
<br><br><br>
<div id="box"></div>

</body>
<script>
//Controller 데이터 값을 자바 스크립트 변수로 받은 후 HTML에 직접 출력하는 형태
var total = "<%=request.getAttribute("total")%>";
document.getElementById("box").innerHTML = "최종데이터" + total;
</script>
</html>