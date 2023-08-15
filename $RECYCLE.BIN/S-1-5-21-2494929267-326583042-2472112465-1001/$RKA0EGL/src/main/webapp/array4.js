function idck(){
	if(f.mid.value==""){
		alert("id를 입력하세요");
	}
	else{
		ajax(f.mid.value);
	}
	var apost;
	var bdata;
	function ajax(data){
		var ajax_data = "mid=" + data;
		function aaa(){
			if(window.XMLHttpRequest){
				return new XMLHttpRequest();
			}
		}
		function bbb(){ //정상응답일 경우
			if(apost.readyState==XMLHttpRequest.DONE&& apost.Status==200){
				bdata = this.response;
				console.log(bdata);
				return_resp(bdata);
			}
		}
		apost = aaa();
		apost.onreadystatechange = bbb;
		
		apost.setRequestHeader("content-type","application/x-www-form-urlencoded",true);
		apost.send(ajax_data);
	}
	function return_resp(rp){
		if(rp=="no"){
			
		}
	}
}