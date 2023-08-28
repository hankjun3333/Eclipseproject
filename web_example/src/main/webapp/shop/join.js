function join(){
	var id = document.getElementById("id");
	var name = document.getElementById("name");
	var pw = document.getElementById("pw");
	var pw_ck = document.getElementById("pw_ck");
	//var tel_c = document.getElementById("tel_c");
	var tel = document.getElementById("tel");
	var mail = document.getElementById("mail");
	
	if(f.id.value==""){
		alert("아이디를 입력해주세요");
		f.id.focus();
	}
	else if(f.name.value==""){
		alert("이름을 입력해주세요");
		f.name.focus();
	}
	else if(f.pw.value == ""){
		alert("비밀번호를 입력해주세요");
		f.pw.focus();
	}
	else if(f.pw.value != f.pw_ck.value){
		alert("비밀번호가 일치하지 않습니다!");
		f.pw_ck.focus();
	}
	else if(f.tel.value == ""){
		alert("전화번호를 입력해주세요");
		f.tel.focus();
	}
	else if(f.mail.value == ""){
		alert("메일을 입력해주세요!");
		f.mail.focus();
	}
	else{
		if(f.tel.value.length <10){
			alert("올바른 휴대폰 번호를 입력해주세요!");
			f.tel.focus();
		}
		else if (isNaN(f.tel.value) == true){
			alert("숫자만 입력해주세요!!");
			f.tel.focus();
		}
		else if(f.mail.value.indexOf('@') == -1){
			alert("올바른 이메일 형식을 작성해주세요!");
			f.mail.focus();
		}
		else{
			f.submit();
		}
	}
}




