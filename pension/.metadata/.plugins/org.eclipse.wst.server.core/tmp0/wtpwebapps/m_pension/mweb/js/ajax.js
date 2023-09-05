//전역변수 선언
var data; //ajax 쓰기 위한용도
var array; // json값을 배열로 받을 수 있는 변수 용도
window.onload = function(){

	function win(){
		if(window.XMLHttpRequest){
			return new XMLHttpRequest();
		}
	}
	function file(){
		if(data.readyState ==XMLHttpRequest.DONE && data.status == 200){
			
			this.array = JSON.parse(this.response);
			//console.log(this.array);
			
			
		var html = document.getElementById("list");
		
		//console.log(this.array["penson_product"][0]);
		var s=0;
		var htmlcode = "";
		while(s<this.array["penson_product"].length){
			//console.log(this.array["penson_product"][s]);
			/* pname 부분엔 이름에 대한 배열 번호, pmoney는 가격에 대한 배열 번호를 입력해야함 */
			htmlcode +=`
		        <li onclick="resv('`+this.array["penson_product"][s]["a_wktitle"]+`','`+this.array["penson_product"][s]["a_wkpd"]+`')"> 
		            <div>
		                <span><img src="`+this.array["penson_product"][s]["a_wkimg"]+`"></span>
		                <span>`+this.array["penson_product"][s]["a_wktitle"]+`</span>
		                <span>`+Number(this.array["penson_product"][s]["a_wkpd"]).toLocaleString()+`</span>
		            </div>
		        </li>
		    `;
			s++;
		}
		html.innerHTML = htmlcode;			
	}
	else if(data.status == 404 || data.status == 405){
			console.log("해당 데이터 접근이안됨");
		}
	}
	data = win();
	data.onreadystatechange = file;
	data.open("get","./data.json",true);
	data.send();

}
function resv(nm,money){
	location.href = './m_reservation.jsp?pnm='+encodeURI(nm)+'&pmoney='+money;
}

