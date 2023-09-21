<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList <ArrayList<String>> mbdata = (ArrayList <ArrayList<String>>) request.getAttribute("member");
//out.print(mbdata);
String part = String.valueOf(request.getAttribute("part"));
//out.print(part);
String s = "";
if(part != null && part.equals("tel")){
	s = "selected";
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp view 화면</title>
</head>
<body>
<table border="1" width="1000">
<thead>
<tr align="center">
	<th width="10%">번호</th>
	<th width="20%">아이디</th>
	<th width="30%">이메일</th>
	<th width="20%">전화번호</th>
	<th width="10%">나이</th>
	<th width="10%">수정/삭제</th>
</tr>
</thead>
<tbody>
<% if(mbdata.size()==0 ||mbdata.get(0).get(1) == null){  %>
<tr align="center">
<td colspan="6">검색한 정보없음</td>
</tr>
<%	
} else {
	
int w= 0;
	do{
%>
<tr align="center">
<td><%=mbdata.get(w).get(0) %></td>
<td><%=mbdata.get(w).get(1) %></td>
<td><%=mbdata.get(w).get(2) %></td>
<td><%=mbdata.get(w).get(3) %></td>
<td><%=mbdata.get(w).get(4) %></td>
<td>
<input type="button" value="수정" onclick="mb_modify('<%=mbdata.get(w).get(0)%>')">
<input type="button" value="삭제" onclick="mb_delete('<%=mbdata.get(w).get(0)%>')"> 
</td>
<%
	w++;
	} while(w<mbdata.size());
}
%>
</tr>
</tbody>
</table><br>
<form id="f" method="get" action="/sphome.do" onsubmit="return abc()">
<select name="part">
<option value="id" selected>아이디</option>
<option value="tel" <%=s%>>전화번호</option>
</select>
<input type="text" name="search">
<input type="submit" value="검색" >
<input type="button" value="전체 목록" onclick="all_data()">
</form>

<form id="insert" action="./sphome_insert.do" method="get">
	<input type="button" value="정보 저장!" onclick="insert_data()">
</form>
</body>
<script>
function abc(){
	f.search.value = f.search.value.replaceAll(" ","");
	if(f.search.value==""){
		alert("내용 입력바람");
		return false;
	}
	else{
		return true;
	}
}
function all_data() {
	location.href="./sphome.do";
}
function mb_delete(idx){
	if(confirm('정말삭제할거임? 이거복구안됨')){
		location.href="./sphome_delete.do?idx=" + idx;	
	}
}
function mb_modify(idx){
	location.href="./sphome_modify.do?idx="+idx;
}
function insert_data(){
	insert.submit();
}
</script>
</html>