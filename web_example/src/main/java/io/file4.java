package io;

import java.io.FileReader;
import java.io.FileWriter;

public class file4 {

	public static void main(String[] args) {
		data3 d = new data3();
		try {
			d.aaa();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}
	

}
//FileWriter는 기존 데이터를 덮어 씌우는 것
/*FileWriter true는 기존 데이터 유지 
기본 값은 false 이다.*/
class data3 {
	FileWriter fw = null;
	public void aaa() throws Exception{
		String user[] = {"홍길동","강감찬","리순신","유관순"};
		this.fw = new FileWriter("D:\\project\\web_example\\src\\main\\webapp\\data.txt",true);
		for(String name : user) {
			this.fw.write(name);
		}
		this.fw.close();
		
	}
}