var data; // 
var array; //배열값

function calldata(data){
	console.log(data);
	this.array = data; // 전역변수를 가져다가 지역변수처럼 사용 this
}

function abc(){
	this.array["member_list"].sort(function(a,b){
		console.log(array);
		console.log(b);
		/*return b["point"] - a["point"];
		console.log(b["point"] - a["point"]);*/
		
		//array3.js 부터 다시 복습
	});
}