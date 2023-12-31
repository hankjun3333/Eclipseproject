<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카카오 로그인 api 적용!</title><!-- min 버전은 커스텀을 못함! -->
<script src="https://t1.kakaocdn.net/kakao_js_sdk/v1/kakao.js"></script>
</head>
<body>
<form id="f" method="post" action="./kakao_loginok.do">
<input type="hidden" name="part" value="web">
<input type="hidden" name="kakao_id" value="">
<input type="hidden" name="kakao_email" value="">
<input type="hidden" name="kakao_nick" value="">
아이디 : <input type="text" name="mname"><br>
패스워드 : <input type="password" name="mpass"><br>
<input type="submit" value="로그인">
</form>
<br><br>
<div id="kakao_login" style=" cursor:pointer; width: 400px; height:70px; background-color: orange;">
<span style="width:50px; display:inline-block;">
<img src="./img/talk.png" style="width:100%;">
</span>
<span>카카오 로그인</span>
</div>
</body>
<script>
document.querySelector("#kakao_login").addEventListener("click",function(){
	Kakao.Auth.login({
		success: function(response){
			Kakao.API.request({
				url : '/v2/user/me',
				success : function(response){
					
					let id = response["id"];
					let email = response["kakao_account"]["email"];
					let nickname = response["properties"]["nickname"];
					console.log(id + email + nickname);
					
					f.part.value = 'kakao';
					f.kakao_id.value= id;
					f.kakao_email.value=email;
					f.kakao_nick.value=nickname;
					f.submit();
				},
				fail:function(error){
					console.log("카카오 API 접속 오류");
				}
			});
		},
		fail:function(error){
			console.log("카카오 key 접속 오류");
		}
	});
});
Kakao.init('3a549e3f1524e17449ff136ff8555b12');
</script>
</html>