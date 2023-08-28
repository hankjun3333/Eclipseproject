
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





