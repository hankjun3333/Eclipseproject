function idck(){
	if(f.mid.value==""){
		alert("아이디를 입력하세요.")
	}else{
		ajax(f.mid.value);
	}
}
let apost;
let bdata;
function ajax(idData){
	var ajax_data = "mid="+idData;	// Backend에게 전달 형태 및 데이터 값(get -> 앞 ?붙힘)
	function aaa(){
		if(window.XMLHttpRequest){
			return new XMLHttpRequest();
		}
	}
	function bbb(){
		if(apost.readyState == XMLHttpRequest.DONE && apost.status == 200){
			bdata = this.response;
			console.log(bdata);
			return_resp(bdata);	// 리턴 메세지를 별도로 핸들링하는 함수로 전달.
		}
	}
	apost = aaa();
	apost.onreadystatechange = bbb;
	//192.168.110.223:8081/web/	
	apost.open("POST","http://192.168.110.223:8081/web/login_idck.jsp", true);
	// post 전송에만 사용되는 ecntype 구조이며, 사용자가 입력한 모든 데이터를 암호화로 사용한다는 뜻.
	apost.setRequestHeader("content-type","application/x-www-form-urlencoded");
	apost.send(ajax_data);
	
	/* GET 전송 
	apost.open("GET","http://192.168.110.223:8081/web/login_idck.jsp?mid="+data, true);
	*/
}

function return_resp(res){
	
	//error, no, yes
	if(res == "no"){
		alert("해당 아이디는 사용하실 수 없습니다.");
	}else if(res == "error"){
		alert("올바른 접근 방식이 아닙니다.")
	}
	
	else{
		alert("해당 아이디는 사용 가능합니다. ");
		document.getElementById("mid").readOnly = true;
	}
}

