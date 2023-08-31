<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	//기본이 오브젝트 이기때문에 문자열로 바꿔줘야 됨!
	//변환 방식은 (String) , toString(), String.valueOf() 셋중 암거나
	String url = String.valueOf(request.getAttribute("dbfile")); 
%>
<script>
	altert("정상적으로 첨부파일 저장되었습니다.");
</script>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시물 확인</title>
</head>
<body>
<a href = "<%=url%>">[첨부파일]
</body>
</html>