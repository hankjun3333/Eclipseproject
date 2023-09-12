<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<app:set var="delete" value="${person_delete}"></app:set>
<p> 고객명 리스트 </p>
<!-- *:set var 변수명을 생성해서 함수를 이용해 값을 받는 형태
      :forEach 배열을 반복시킬때 사용 (varStatus: 순차번호, 배열의 첫번째값, 배열의 마지막값, 갯수에 사용) 
      st.index+1 순번 st.count-1 역순
      :for 일반 반복문
      :if 조건문을 생성 조건형태는 test 이름으로 생성
 -->
<app:set var="person_ea" value="${fn:length(person_list)}"></app:set>
<p>가입자 수: ${ea}</p>
<p>탈퇴인원 : ${delete}</p>
<ul>
<app:forEach var="username" items="${person_list}" varStatus="st">
<app:if test="${username!='전여친1'}">
<li>번호: ${person_ea} 이름: ${username}</li>
</app:if>
<app:set var="person_ea" value="${person_ea-1}"></app:set>
</app:forEach>
</ul>

<!-- for문 (begin, end, step) -->
<app:forEach var="w" begin="1" end="5" step="1">
${w}
</app:forEach>

</body>
</html>