<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--표현식 쓰려면! jsp 엔진을 장착 -->
<%@ taglib prefix="app" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring 3일차 - Controller에서 view 배열값 출력!(표현식)</title>
</head>
<body>
<!-- 
:set : var변수명을 생성하여 함수를 이용하여 값을 받는 형태!
:forEach : 배열을 반복시킬때 사용
:if : 조건문을 생성! 조건형태는 test 이름으로 조건을 만듬!

 -->
<app:set var="delete" value="${person_delete}"></app:set>
 <!--표현식 쓰려면! 위에 jsp 엔진을 장착 app태그 -- 위에 프리픽스랑 이름같게설정!!-->
	<p>고객명 리스트</p>
	
	<!-- :set은 var변수명을 생성하여 함수를 이용하여 값을 받는 형태! -->
<app:set var="ea" value="${fn:length(person_list)}"></app:set>
	<p>가입자 수 : ${ea}</p>
	<p>탈퇴 인원 수 : ${delete}</p>
	
	<ul>
	<!-- forEach => items를 이용해서 사용 --> <!-- varStatus는 순차번호,배열,첫번째값,갯수 부분 -->
<app:set var="person_ea" value="${ea}"></app:set>	
	<app:forEach var="username" items="${person_list}" varStatus="st">
<app:if test="${username!='강감찬'}">
	<li>번호 : ${person_ea} 이름 : ${username}</li>
</app:if>
<!-- 역순 페이지 -->
<app:set var="person_ea" value="${person_ea-1}"></app:set>
	</app:forEach>
	</ul>
	
<!-- 이름은 forEach 이지만 for문임 이게  begin,end,step -->	
<app:forEach var="w" begin="1" end="5" step="1">
${w}
</app:forEach>

</body>
</html>