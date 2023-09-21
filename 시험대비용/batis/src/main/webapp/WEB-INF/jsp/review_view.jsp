<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="batis.datavo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
ArrayList<String> one= (ArrayList<String>) request.getAttribute("one");
out.print(one);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품리뷰 수정 페이지</title>
</head>
<body>
<form id="f" method="post" action="./data_modify.do">
<input type="hidden" name="ridx" value="${one.get(0)}">
고객명 : <input type="text" name="rname" value="${one.get(1)}"><br>
비밀번호 : <input type="password" name="rpass"><br>
리뷰 내용 : <textarea cols="200" rows="4" name="rtext">${one.get(3)}</textarea><br>
<input type="submit" value="리뷰수정">
</form>
</body>
<script>
const ori_pw = "${one.get(2)}";
document.querySelector("#f").addEventListener("submit",function(s){
	s.preventDefault();
	if(f.rpass.value==""){
		alert("패스워드 입력하세요");
	}
	else {
		if(f.rpass.value==ori_pw){
			location.href="./review_list.do";
		}
		else{
			alert("패스워드 올바르지 않음");
		}
		
	}
		
	
	
	
});
</script>
</html>