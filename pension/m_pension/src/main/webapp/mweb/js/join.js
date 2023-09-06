function join1(){
    var uid = document.getElementById("id").value;
    var uname = document.getElementById("name").value;
    var upw = document.getElementById("pw").value;
    var upw_ck = document.getElementById("pw_ck").value;
    var uemail = document.getElementById("email").value;
    var utel = document.getElementById("tel").value;
    var code = document.getElementById("code").value;
    var code_ck = document.getElementById("code_ck").value;
    if (uid === "") {
        alert("아이디를 입력하세요");
    } else if (uid.length < 6 || uid.length > 16) {
        alert("아이디를 6~16자로 입력하세요");
    } else if (uname === "") {
        alert("이름을 입력하세요");
    } else if (upw === "") {
        alert("비밀번호를 입력하세요");
    } else if (upw.length < 6 || upw.length > 12) {
        alert("비밀번호를 6~12자로 입력하세요");
    } else if (upw_ck !== upw) {
        alert("비밀번호가 일치하지 않습니다");
    } else if (uemail === "") {
        alert("이메일을 입력하세요");
    } else if (uemail.indexOf('@') === -1) {
        alert("올바른 이메일 형식을 입력하세요");
    } else if (utel === "") {
        alert("전화번호를 입력하세요");
    } else if (utel.length < 10 || utel.length > 11) {
        alert("전화번호를 10~11자로 입력하세요");
    } else if (code_ck !== code) {
        alert("보안코드가 일치하지 않습니다");
    } else {
        document.getElementById("ff").submit();
    }


}
window.onload = function(){
	//var uri = decodeURI(window.location.search);
	//console.log(uri);
	
	var sc ="";
	var sc2 = "";
	var codenum = document.getElementById("code");
	//console.log(sc);
	var w=0;
	while(w<=5){
		sc = Math.ceil(Math.random()*6);
		sc2 += sc ;
		w++;
	}
	//console.log(sc2);
	codenum.value = sc2;
}
var fdata = sessionStorage.getItem("time");

window.onload = function(){
	var url = decodeURI(window.location.search);
	var param = url.split("?days=");
	if(param[1] == null || param[1]!=fdata){
		alert("올바른접근이 아닙니다.");
		location.href='./join_step.jsp';
	}
}



