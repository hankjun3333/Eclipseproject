<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//배열 값이 null 일 경우 jsp 에서 해당 HTML 코드를 비활성화 시키는 방법!
	List<ArrayList<String>> member_data = (List<ArrayList<String>>) request.getAttribute("member_data");
	int many = member_data.size();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 리스트 페이지</title>
</head>
<body>
<p>회원가입 고객 리스트 가입자 수 : <%=many%> 명</p>
<table border="1" width="1000">
<thead>
<tr>
<th width="5%">번호</th>
<th width="20%">아이디</th>
<th width="30%">이메일</th>
<th width="20%">연락처</th>
<th width="5%">나이</th>
<th width="20%">가입일자</th>

</tr>
</thead>
<tbody>
<!-- database 내용이 출력되는 파트! -->
<!-- 배열 값 중 첫번째 아이디 값을 확인하여 값이 없을경우에 대한 조건 -->
<%if(member_data.get(0).get(1) == "null"){ %>

<%
}
	int w = 0;
	do{	
%>
<tr align="center">
<td colspan="6">검색한 내용을 찾을 수 없습니다.</td>
<td><%=many-w %></td>
<td><%=member_data.get(w).get(1)%></td>
<td><%=member_data.get(w).get(2)%></td>
<td><%=member_data.get(w).get(3)%></td>
<td><%=member_data.get(w).get(4)%></td>

<td><%=member_data.get(w).get(5).substring(0,10)%></td>

</tr>
<%
	w++;
	}while(w<many);
%>
</tbody>
</table>
<br><br>
<form id="f" action="./spring6ok.do" method="get" onsubmit="return id_search()">
검색 : <input type="text" name="search">
<input type="submit" value="검색">
</form>
</body>

<script>
//검색 한 단어를 입력값에 유지시키는 스크립트 코드
var wd = window.location.search();
var sh = wd.split("?search");
f.search.value = sh[1];
/*
 trim() => 글자 앞 뒤 공백만 삭제
 replace() => 첫번째 관련 단어만 변경
 replaceAll() = > 모든 단어만 확인하여 변경
 
 */

var word = "홍길  동님 환  영합 니다.  "; 
//var word2 = word.trim(); //글자 앞 또는 뒤 모든 공백 제거용
//var word3 = word.replace(" ","");
var word2 = word.replaceAll(" ",""); //게임할떄 욕하면 바뀌는것
console.log(word2);
function id_search(){
/*입력에 따른 공백을 제거 후 조건문으로 재 확인!*/	
	f.search.value= f.search.value.replaceAll(" ","");
	if(f.search.value==""){
		alert("검색할 단어를 입력하세요우잉");
		return false;
	}
	else{
		
	}
}
</script>
</html>