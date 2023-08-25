package io;

import java.io.FileReader;
import java.io.IOException;

//IOException + Exception + finally //IO랑 객체지향이랑 섞임 호출을 어떻게하는지 잘보자
//예외처리 후 다시 해당 프로세서 실행했지만 but 강제종료하는 과정
public class file3 {

	public static void main(String[] args) {
		try {
			data2 dt = new data2();
			String url="D:\\project\\web\\src\\main\\webapp\\data1.txt"; //깔끔하게 변수 담아서 사용
			dt.abc(url);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally { 
			//수정해서 다시 반환해주는 역할 
			//catch로 오류가 발생시 다시 프로세서를 읽어서 해당 메소드를 호출하는 형태
			//throws 걸려있으니 try- catch해줘야됨
			//서버 과부하발생시 finally씀 그외에 많이쓰는건 안좋은것 막코드 됨
			//System.out.println("다른 파일명 설정");
			String url="D:\\project\\web\\src\\main\\webapp\\data.txt";
			
			try { //해당 메소드가 throws를 사용했으므로 다시 try-catch를 사용해야 합니다!!!!!
				data2 dt = new data2();
				dt.abc(url);	
			}
			catch(Exception e) {
				System.out.println("파일 완전 오류발생!!");
				System.exit(0); //프로그램 강제 종료시키는 것
				
			}
		}
	}
}

class data2{
	FileReader fr = null; //필드에 많이 올려놓는다
	//IOException은 Exception의 한 방식이다 throws에서 쓰는 방식
	public void abc(String filename) throws Exception, IOException{ //둘다 예외처리하겟다는것
		this.fr = new FileReader(filename); 
		System.out.println(this.fr.read());
		this.fr.close();
	}
}
