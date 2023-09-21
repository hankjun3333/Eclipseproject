<%@page import="java.text.DecimalFormat"%>
<%@page import="java.io.UncheckedIOException"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
@SuppressWarnings("unchecked")
ArrayList<ArrayList<String>> pl =(ArrayList<ArrayList<String>>)request.getAttribute("product_data");
//out.print(pl);
int listea = (int)request.getAttribute("listea");
//out.print(listea);
DecimalFormat df = new DecimalFormat("###,###"); //금액 자동 콤마! 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>등록된 상품 갯수 : <%=listea%> 개</p>
	<table border="1" width="1000" align="center">
		<thead>
			<tr align="center">
				<td width="5%">번호</td>
				<td width="15%">상품코드</td>
				<td width="40%">상품명</td>
				<td width="15%">상품가격</td>
				<td width="25%">수정삭제</td>
			</tr>
		</thead>
		<tbody>
		<%
			int w = 0;
			do{
		%>
		<tr align="center">
		<td><%=listea-w%></td>
		<td><%=pl.get(w).get(1)%></td>
		<td align="left"><%=pl.get(w).get(2)%></td>
		<td><%=df.format(Integer.parseInt(pl.get(w).get(3)))%> 원</td>
		<td align="center">
		<input type="button" value="수정" onclick="modify_pd('<%=pl.get(w).get(0)%>')">
		<input type="button" value="삭제" onclick="delete_pd('<%=pl.get(w).get(0)%>')">
		</td>	 
		</tr>
		<%
			w++;
			} while(w<pl.size()); 
		%>		
		</tbody>
	</table>
</body>
<script>
function delete_pd(idx) {
	if(confirm("해당 데이터를 정말 삭제하시겠습니까? 절대 복구안됨")){
		location.href="./product_delete.do?idx=" + idx;		
	}
}
function modify_pd(idx) {
	location.href="./product_modify.do?idx=" + idx;
	
	
}
</script>
</html>