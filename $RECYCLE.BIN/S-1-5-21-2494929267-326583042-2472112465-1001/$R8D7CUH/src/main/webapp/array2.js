var data;	// ajax에 사용하는 변수명
var array;	// json 값을 배열로 받을 수 있는 변수명

function abc(){
	
	function win(){	//통신 규약에 대한 인스턴스를 새롭게 생성하는 역할
		if(window.XMLHttpRequest){
			return new XMLHttpRequest();
		}
	}
	
	function file(){
		// 서버접속 성공 유/무 를 확인 또한 해당 로드할 파일이 정상적으로 로드가 되었는지 확인하는 공간.
		if(data.readyState == XMLHttpRequest.DONE && data.status == 200){
			// JSON파일은 기본이 문자열 => 해당 문자열을 정상적인 배열화 
			// 시켜주는 함수 입니다. (Json.parse)
			array = JSON.parse(this.response);	//response : 결과값 반환
			console.log(array);
		}else if(data.status == 404 || data.status == 405){
			console.log("해당 파일 및 서버에 접속할 수 없습니다.");
		}
	}
	
	data = win();	//통신 오픈
	data.onreadystatechange = file;	// 조건 맞는 결과값을 출력하는 역할
	data.open("get", "./data.json", true);	
	/*
	어떤 파일을 로드 할 것인지 설정.("통신형태","파일 또는 URL", "비동기&동기")
	post, get, put, delete, update, fetch
	*/
	
	data.send();	//해당 서버에 접속 및 실행
}