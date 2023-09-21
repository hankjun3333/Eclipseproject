<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ECMA - 모바일 Swap</title>
    <style>
        html,body{margin: 0; padding: 0;}
        .banner { width: 200px; height: 200px; 
        position: relative; overflow: hidden; border:1px solid red;
        margin: 0 auto;}
        .images{ position: absolute; display: flex;
        transition: all 0.5s ease; }
        .images > img { object-fit: cover; width: 200px; }
    </style>
</head>
<body>
<div class="banner">
<span class="images" id="images">
<img src="./cat1.jpg">
<img src="./cat2.jpg">
<img src="./cat3.jpg">
<img src="./cat4.jpg">
</span>
</div>
</body>
<script>
var startx = 0;
var endx = 0;
var imgsize = 200;
var ori = 0;
var node = 0;
var node_ea; //ea 4개 이미지 -4개
//touchstart : 핑거를 누른 상태!
//touchend : 핑거를 뗀상태
//touches[0]: 최초 좌표값을 가지고 있는 속성 (target 안에있음)
//changedTouches[0] : 변화된 좌표값을 가지고 있는 속성 ! target 안에있음
//pageX (가로로 왔다갔다 하는거)
//pageY (세로로 왔다갔다 하는거)
document.querySelector("#images").addEventListener("touchstart",function(a){
	startx = a.touches[0].pageX;
	console.log(startx);
	node_ea = document.querySelectorAll("#images > img").length;
	console.log(node_ea);
});

document.querySelector("#images").addEventListener("touchend",function(a){
	endx = a.changedTouches[0].pageX;
	if(startx > endx){ //왼쪽에서 오른쪽 움직인경우
		next(endx);
	}
	else{ //오른쪽에서 왼쪽으로 이동
		prev(endx);
	}
	
});

function next(z){
	if(node < node_ea-1){
		ori -= imgsize;
		node = node + 1 ;
		
		document.querySelector("#images").style["transform"]="translateX("+ori+"px)";
	}
}
function prev(z){
	if(node > 0){
		ori += imgsize;
		node = node - 1 ;
		document.querySelector("#images").style["transform"]="translateX("+ori+"px)";
	}
}

</script>
</html>
