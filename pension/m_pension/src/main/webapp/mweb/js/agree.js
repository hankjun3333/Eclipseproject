
var aa=document.getElementById("all");

var a1 = document.getElementById("a1");
var a2 = document.getElementById("a2");
var a3 = document.getElementById("a3");
var a4 = document.getElementById("a4");	
function all_ck(e){
	//console.log(e);
	var w=1;
	while(w<=5){
		if(aa.checked==e){
			document.getElementById("a"+w).checked=e;
		}
		w++;
	}
}


function abc(){
	var w=1;
	var ck = true;
	
	while(w<=5){
		if(document.getElementById("a"+w).checked==false){
			ck=false;
		}
		w++;
	}
	if(ck==false){
		aa.checked = false;
	}
	else{
		aa.checked = true;
	}
}

function agree1(){
	var today = "";
	var data = "";
	today = Date.now();
	console.log(today);
	data = sessionStorage.setItem("time",today);
			
	//window.open("./join_step2.jsp?days= "+ today,"_self","");
	
	
	var f =document.getElementById("f");
	if(a1.checked==false){
		alert("이용약관 동의를 체크하여 주세요");
		
	}
	else if(a2.checked==false){
		alert("개인정보 수집 동의 체크하여 주세요");
		
	}
	else if(a3.checked==false){
		alert("개인정보 3자 제공동의 체크해주시죠");
	}
	else if(a4.checked==false){
		alert("개인정보 위탁제공 동의 체크해주세요");
		
	}
	else{
		location.href="./join_step2.jsp?days=" + today;
		//f.submit();
	}


}

	
