function login1(){
var userid = document.getElementById("userid");
var userpw = document.getElementById("userpw");
	if(f.userid.value==""){
		alert("유저 아이디를 입력해주세요");
		return false;
	} 
	else if(f.userpw.value==""){
		alert("유저 비밀번호를 입력해주세요");
		return false;
	}
	else{
		return true;
	}
}
function id_save(){
	var saveid = document.getElementById("saveid");
	var userid = document.getElementById("userid"); 
	if(f.userid.value==""){
		alert("아이디를 입력하셔야만 이 기능 사용가능");
		saveid.checked = false;
	}
	else{
		if(saveid.checked==true){
			window.localStorage.setItem("userid",f.userid.value);
		}
		else{
			window.localStorage.setItem("userid","");
		}
	}	
	
}