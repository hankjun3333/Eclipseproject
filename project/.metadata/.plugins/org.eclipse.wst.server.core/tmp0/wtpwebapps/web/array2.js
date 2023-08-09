//전역변수 선언
var data; //ajax 쓰기 위한용도
var array; // json값을 배열로 받을 수 있는 변수 용도

function abc(){
	
	function win(){ // 통신 규약에 대한 인스턴스를 생성하는 역할만 함
		if(window.XMLHttpRequest){
			return new XMLHttpRequest();
		}
	}
	
	function file(){
		//서버 접속 성공의 유/무를 확인 하거나 또한 해당 로드할 파일이 정상적으로 되었는지 확인하는 공간
		if(data.readyState == XMLHttpRequest.DONE && data.status == 200){
			//json파일은 기본이 문자열이기때문에 해당 문자열을
			//json.parse 해줘야 문자열을 배열로 바꿔줌 배열화 시켜주어야 한다. (JSON.parse)
			
			//response: 결과값 반환
			array = JSON.parse(this.response); // 여기서 this는 통신에 대한 this임 XMLHttpRequest
			
			console.log(array);
		}
		else if(data.status == 404 || data.status == 405){
			console.log("해당 파일 및 서버에 접속할 수 없습니다.");
			
		}
	}
	
	data = win(); //통신 오픈을 뜻함
	data.onreadystatechange = file; //조건에 맞는 결과값을 출력하는 역할
	
	// true false에 따라 동기 비동기로 바뀜
	// 어떤 파일을 로드할 것인지 설정하는 것("통신형태","파일 또는 URL","비동기&동기")
	//post get put delete update fetch
	//./data.json
	//data.open("get","http://119.192.19.18:8081/web/userlist.json?callback=calldata",true); 
	data.open("get","./data.json",true);
	data.send(); //해당 서버에 접속 및 실행
}






