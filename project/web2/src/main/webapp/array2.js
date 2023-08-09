var data;
var array;

function abc(){
	
	function win(){
		//통신 규약에 대한 인스턴스를 생성하는 역할
		if(window.XMLHttpRequest){
			return new XMLHttpRequest();
		}
	}
	//서버 접속 성공의 유무를 확인하거나 또한 해당 로드할 파일이 정상적으로 되엇는지 확인하는 공간
	//json파일은 기본적으로 문자열이기 때문에 해당 문자열을 JSON.parse를 해줘야함 
	//문자열을 배열 형태로 변환해줘야함
	function file(){
		if(data.readyState == XMLHttpRequest.DONE && data.status == 200){
			//array에 문자열이 배열값으로 들어가고 여기서 this는 통신에 대한 this임 XMLHttpRequest
			array = JSON.parse(this.response); 
			console.log(array);
		}
		else if(data.status == 404 || data.status == 405){
			console.log("해당 파일및 서버에 접속불가능");
		}
	}
		data = win();
		data.onreadystatechange = file;
		data.open("get","./data.json",true);
		data.send();
}