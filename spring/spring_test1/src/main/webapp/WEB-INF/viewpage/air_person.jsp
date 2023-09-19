<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<ArrayList<String>> list = (ArrayList<ArrayList<String>>)request.getAttribute("al_list");
//out.print(list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비행기 예매 페이지</title>
</head>
<body>
<form id="f" method="post" action="air_personok.do" enctype="application/x-www-form-urlencoded">
<input type="hidden" name="acode" value="">
<input type="hidden" name="a_corp" value="">
<p>비행기 예매</p>
<input type="text" name="pid" placeholder="아이디를 입력하세요"><br>
<input type="text" name="pname" placeholder="고객명을 입력하세요"><br>
<input type="text" name="passport" placeholder="여권 명을 입력하세요"><br>
<input type="text" name="ptel" placeholder="고객 연락처 ('-' 미입력)" maxlength="11"><br>
<select name="a_corp" id="aircorp" onchange="data2(this.value)">
<option value="">항공사를 선택하세요</option><br>
<%
int w = 0;
while(w<list.size()){
	
%>
<option value="<%=list.get(w).get(0)%>|<%=list.get(w).get(1)%>|<%=list.get(w).get(2)%>"><%=list.get(w).get(1)%></option>
<%
w++;
}
%>

</select>
<input type="text" name="pcount" placeholder="인원수를 입력하세요" onkeyup="person(this.value)"><br>
<p>총 항공료</p><br>
<input type="text" name="totalprice" value="0" readonly><br>
<input type="button" value="예매완료" id="btn">
</form>
</body>
<script>
var ori_money;
function data2(z){
	console.log(z[0]);
	var a = z.split("|");
	//console.log(a[1]);
	f.acode.value= a[0]; //비행기코드
	f.a_corp.value= a[1]; //항공사명
	f.totalprice.value = a[2]; //총 금액
	ori_money = a[2]; //1인기준금액
	f.pcount.value = 1; //해당 항공사 변경시 인원 초기화
}
function person(p){
	var sum = Number(p) * Number(ori_money);
	f.totalprice.value = sum;
}
document.querySelector("#btn").addEventListener("click",function(){
	if(f.pid.value==""){
		alert("아이디 입력바람");
	}
	else if(f.pname.value==""){
		alert("고객명 입력바람");
	}
	else if(f.passport.value==""){
		alert("여권번호 입력바람");
	}
	else {
		if(confirm("예약을 확정하시겠습니까?")){
			f.submit();
		}
	}
});
</script>
</html>
