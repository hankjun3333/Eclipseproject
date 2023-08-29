//alert("test");
var title = document.getElementById("title");
var user = document.getElementById("user");
var pw = document.getElementById("pw");
var text = document.getElementById("text");
function write1(){
	if(f.title.value==""){
		alert("제목을 입력해주세요!");
		f.title.focus();
	}
	else if(f.user.value==""){
		alert("작성자 이름을 입력해주세요!");
		f.user.focus();
	}
	else if(f.pw.value==""){
		alert("비밀번호를 입력해주세요");
		f.pw.focus();
	}
	else if(f.text.value==""){
		alert("내용을 입력해주세요");
		f.text.focus();
	}
	else{
		f.submit();
	}
}