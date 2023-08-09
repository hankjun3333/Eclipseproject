function idck(){
	if(f.mid.value=""){
		alert("아이디를 입력하세요");
	}
	else{
		ajax(f.mid.value);
	}
	
}
//항상 전역변수 ajax 사용시 선언
let apost;
let bdata;

function ajax(data){
	var ajax_data = "mid=" + data; // Back-end 에게 전달해주는 형태 및 데이터값임 post는 물음표?붙이지 않음
	function aaa(){
		if(window.XMLHttpRequest){
			return new XMLHttpRequest();
		}
	}
	function bbb(){
		if(apost.readyState==XMLHttpRequest.DONE && apost.status==200){
			//console.log(this.response);
			bdata = this.response;
			console.log(bdata);
			return_resp(bdata); //리턴 메세지를 별도로 핸들링하는 함수로 전달
		}
	}
	
	apost = aaa();
	apost.onreadystatechange = bbb; //return 할필요가 없이 바로 실행시키려고 () 안씀
	//192.168.110.227:8080/web
	apost.open("POST","http://192.168.110.221:8084/web/login_idck.jsp",true);
	//POST전송에만 사용되는 enctype구조이며, 사용자가 입력한 모든 데이터를 암호화로 사용한다는 뜻
	apost.setRequestHeader("content-type","application/x-www-form-urlencoded"); 
	apost.send(ajax_data); //이게 post랑 get이랑 다름
}
/* GET전송시
	apost.open("GET","http://192.168.110.221:8084/web/login_idck.jsp?mid="+data,true);
	apost.send();
*/

function return_resp(rp){
	//console.log(rp);
	//error, no,yes
		if(rp=="no"){
			alert("해당 아이디는 사용하실 수 없습니다.");
		}
		else if(rp=="error"){
			alert("올바른 접근 방식이 아닙니다.");
		}
		else{
			alert("해당 아이디는 사용 가능합니다."); 
			document.getElementById("mid").readOnly = true; //중복확인 후 해당아이디 수정못하도록
		}	
}





