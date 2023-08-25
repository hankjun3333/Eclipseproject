package io;

import java.io.FileWriter;

//파일쓰기(write)
public class file4 {

	public static void main(String[] args) {
		//static 언제씀?
		//예외처리 어떤식?
		//오버로딩 오버라이딩 어떤식으로?
		
		try {
			new data3().abc();
		}
		catch(Exception e) {
			System.out.println("파일 오류 발생!!");
		}
	}

}
class data3{
	
	FileWriter fw = null;
	
	public void abc() throws Exception{
		//FileWriter : 문자 데이터를 파일에 쓰는 class
		String user[] = {"홍길동3","유관순3","이순신3","강감찬3","안중근3"};
		//this.fw =new FileWriter("D:\\project\\web\\src\\main\\webapp\\data.txt");
		this.fw =new FileWriter("D:\\project\\web\\src\\main\\webapp\\data.txt",true); //true를 넣어주면 기존데이터 유지됨
		//FileWriter true는 : 기존 데이터를 삭제하지 않고 지속적으로 데이터를 추가하는 형태, 기본값은 false (기존데이터 지운다는것)
		for(String name : user) {
			this.fw.write(name); //기존 데이터에 덮어쓰겠다는 소리임!! write //기존데이터 날라감
			//write 메소드는 해당 파일에 데이터를 덮어쓰기위한용도
		}
		this.fw.close(); //파일 열고나서는 항상 닫자!!!!!! 메모리에 계속 상주해있음
	}
}
