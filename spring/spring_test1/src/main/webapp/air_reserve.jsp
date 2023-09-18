<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//long time = System.currentTimeMillis();
	//SimpleDateFormat today = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	//String check = today.format(time);
	//out.print(check);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>항공 리스트 등록 페이지 - JS + ES</title>
</head>
<body>
<p>항공 리스트</p>
<form id="f" method="post" action="./air_reserveok.do" enctype="application/x-www-form-urlencoded">
<input type="text" name="acode" placeholder="비행기 코드 넘버(10~14자리)" maxlength="14"><br>
<select name="a_corp">
<option value="ANA항공">ANA항공</option>
<option value="오케이항공">오케이항공</option>
<option value="인디고항공">인디고항공</option>
<option value="중화항공">중화항공</option>
<option value="에어아시아">에어아시아</option>
<option value="대한항공">대한항공</option>
<option value="아시아나항공">아시아나항공</option>
<option value="제주항공">제주항공</option>
</select> <br>
<select name="a_contry">
<option value="한국">한국</option>
<option value="일본">일본</option>
<option value="중국">중국</option>
<option value="베트남">베트남</option>
<option value="말레이시아">말레이시아</option>
<option value="크로아티아">크로아티아</option>
<option value="이집트">이집트</option>
<option value="터키">터키</option>
</select><br>
<input type="datetime-local" name="a_sdate"><br>
<input type="text" name="a_avail" placeholder="예약 가능 인원수 입력하세요"><br>
<input type="text" name="amoney" placeholder="1인 기준 항공료" onkeyup="air_abc(event)" maxlength="100"><br>
예매 시작 시간 : <input type="datetime-local" name="start_day"><br>
예매 종료 시간 : <input type="datetime-local" name="end_day"><br>
<input type="button" value="여행항공 정보 입력완료" id="btn">
</form>
</body>
<script>
/*
onkeypress : keydown 되었을때 값을 가져옴 //한템포 느림 (특수키 안먹음)
onkeydown :	keydown 되었을때 값을 가져옴 //한템포 느림 (특수키 먹음)
onkeyup : 키값을 누른후 똇을때 누른 그 값을 가져옴 (특수키 먹음)
*/

window.onload = function(){
	var bw = navigator.userAgent.toUpperCase();
	if(bw.indexOf("FIREFOX") >=0){
		alert("해당 브라우저로는 접속 불가능");
	}
}



function air_abc(event){
	console.log(event.key);
	if(event.key >= 0 || event.key <= 9 ){
		return;
	}
	else {
		alert("숫자 값만 입력하세요!");
		f.amoney.value = "";
	}
}

var today = new Date();
var year = today.getFullYear().toString().padStart(2,'0'); //연
var month = String(today.getMonth()+1).padStart(2, '0'); //월
var day = today.getDate().toString().padStart(2,'0'); //일 을 가져옴
var hour = today.getHours().toString().padStart(2,'0');
var min = today.getMinutes().toString().padStart(2,'0');
var datetime = year + month + day + hour + min ;
console.log(datetime);

//var datetime = today.getFullYear() + today.getMonth()+1 + today.getDate() + today.getMinutes() + today.getSeconds();
//console.log(datetime);
//console.log(times);

document.querySelector("#btn").addEventListener("click",function(){
	/*
		/내용/g : 정규 표현식 방법으로 데이터 값을 체크또는 치환,삭제하는 것임
		g는 global을 뜻하지만  group 이라고 생각하면 됨!
	*/
	var kk = f.a_sdate.value.replaceAll(/-|T|:/g,"");
	console.log(kk);
	var s = f.start_day.value.replaceAll(/-|T|:/g,"");
	var e = f.end_day.value.replaceAll(/-|T|:/g,"");
	//console.log(s);
	
	if(f.acode.value==""){
		alert("비행기 코드넘버 입력해주세요 10~14자리");
	}
	else if(f.a_sdate.value==""){
		alert("출발 일자를 선택하세요"); //시간 검토하는 것이 필요함! 날짜를 가져오는 것
	}
	else if(kk <= datetime){
		alert("출발일자 시간이 정확하지 않습니다.");
	}
	
	/*replac로 조정을 좀 해야 됨*/
	else if(Number(s) >= Number(e)){
		alert("예매 시간이 잘못 셋팅되었습니다.");
		f.start_day.value = "";
		f.end_day.value = "";
	}
	else{
		f.submit();
	}
});

</script>
</html>