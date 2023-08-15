var data;
var array;

function calldata(){
	console.log
	this.array = data; //전역변수 사용시 이렇게 사용해야됨
	
}
function abc(){
	this.array["member_list"].sort(function(a,b){
		console.log(b);
		//this.array["member_list"].sort(function(a,b){
			//return a["point"]-b["point"]; //오름차순
			//return b["point"]-a["point"]; //내림름차순
		//});
	});
	var html = document.getElementById("list");
	var s;
	for(s in this.array["member_list"]){
		html.innerHTML += "<ul>";
		var f;
		for(f in this.array["member_list"][f]){
			html.innerHTML += "<li>";
		}
	}
}