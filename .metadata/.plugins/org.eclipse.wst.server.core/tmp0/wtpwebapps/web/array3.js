let data; //변수가 같은 중복이름을 사용하지 않도록 하기 위한 선언방식임
let array
//배열값 

function calldata(data){
	console.log(data);
	this.array = data; //전역변수
}

function abc(){
	
	this.array["member_list"].sort(function (a,b){
		console.log(b);
		//return a["point"] - b["point"]; // 올림차순
		return b["point"] - a["point"]; //내림차순
	});
	//console.log(this.array);
	let html = document.getElementById("list");
	
	
	//이걸 for in 이라고 함 => 배열 전용 반복문임 (for문 치고 속도가 상당히 빠름)
	var s;
	for(s in this.array["member_list"]){
		html.innerHTML += "<ul>";
		
		var f;
		for(f in this.array["member_list"][s]){
			//console.log(f);
			html.innerHTML += "<li>"+this.array["member_list"][s][f]+"</li>";
			//console.log(this.array["member_list"][s][f]);
			if(f == "point"){
				//toLocaleString 찍으면 3000 이게 3,000 이렇게 찍힘
				html.innerHTML += "<li>"+this.array["member_list"][s][f].toLocaleString()+"</li>";
			}
			else{
				html.innerHTML += "<li>"+this.array["member_list"][s][f]+"</li>";
			}
		}
	}
}
