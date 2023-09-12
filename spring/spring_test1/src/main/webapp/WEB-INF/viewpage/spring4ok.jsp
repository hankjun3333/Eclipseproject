<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>이메일 확인</title>
</head>
<body>
고객명 : ${name}<br>
받은메일 : ${email}<br>
제목 : ${title}<br>
내용 : ${content}
</body>
<script>
var name = "${name}";
var email = "${email}";
var title = "${title}";
var content = "${content}";
console.log(name);
</script>
</html>
