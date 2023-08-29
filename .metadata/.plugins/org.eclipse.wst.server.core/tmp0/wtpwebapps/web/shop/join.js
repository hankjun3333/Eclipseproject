
//백엔드도 많이씀! 중요하다 매우
/* storage : 웹 브라우저의 작은 메모리를 활용하여 특정 정보를 기억시켜놓는 공간 옛날엔 쿠키썼음
단점은 브라우저 종류가 다를 경우는 storage값이 유 / 무로 나누어 집니다.
window.localStorage.setItem("별명",값) : storage에 저장
window.localStorage.getItem : storage에 있는 별명 명칭을 값을 가져올 때 사용!   



, session*/
var storage = window.localStorage.getItem("userid");
f.uid.value = storage;

/*회원가입*/
function join(){
	var id = document.getElementById("id");
	var name = document.getElementById("name");
	var pw = document.getElementById("pw");
	var pw_ck = document.getElementById("pw_ck");
	var tel_c = document.getElementById("tel_c");
	var tel = document.getElementById("tel");
	var mail = document.getElementById("mail");
	
	if(f.id.value==""){
		alert("아이디를 입력해주세요");
	}
	else if(f.name.value==""){
		alert("이름을 입력해주세요");
	}
	else if(f.pw.value==""){
		alert("비밀번호를 입력해주세요");
	}
	else if(f.pw.value!=f.pw_ck.value){
		alert("비밀번호 안맞는데?");
	}
	else if(f.tel.value==""){
		alert("전화번호를 입력해주세요");
	}
	else if(f.mail.value==""){
		alert("메일을 입력해주세요");
	}
	else{ //else 에서 if문으로 한번더 버그 처리를 해준다!!! 중요!!
		if(f.tel.value.length<10){
			alert("올바른 휴대폰 번호를 입력하세요!");
		}
		//not a number true일때 무조건 문자가 하나 들어간거임 false 이면 숫자 다들어감
		//(자바=Interger.ParseInt랑 같음)
		else if(isNaN(f.tel.value) == true){ 
			alert("정상적인 휴대폰 번호를 입력하세요!");
		}
		//-1은 @란 문자를 입력안했단 소리,!!
		// 문자 열 중 @ 란 단어가 포함되어 있는지 없는지 판단함 자바도 똑같이 있음
		else if(f.mail.value.indexOf("@") == -1){ 
			alert("올바른 이메일 형식으로 입력해주세요");
		}
		else{
			f.submit();
		}
	}
}
function abc(){
	var uid = document.getElementById("uid");
	var upw = document.getElementById("upw");
	if(f.uid.value==""){
		alert("아이디를 입력해주세요");
		f.uid.focus();
		return false;
	}
	else if(f.upw.value==""){
		alert("패스워드를 입력해주세요");
		f.upw.focus();
		return false;
	}
	else{
		return ;
	}
}
/*아이디 저장 기능*/ 
function id_save(){
	var uid = document.getElementById("uid");
	var ck = document.getElementById("saveid");
	if(f.uid.value==""){
		alert("아이디를 입력하셔야만 해당 기능을 사용할 수 있습니다!.");
		ck.checked = false;
	}
	else{
		if(ck.checked == true){
		window.localStorage.setItem("userid",f.uid.value);
		}
		else{
			window.localStorage.setItem("userid","");
		}
	}
}





