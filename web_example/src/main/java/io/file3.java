package io;

import java.io.FileReader;
import java.io.IOException;

//IOException + Exception + finally // IO랑 객체지향이랑 섞임
//예외 처리 후 다시 해당 프로세서 실행했지만 그래도 오류날 경우 강제 종료방법
//메인에서 url담고 예외처리 한 경우
public class file3 {

	public static void main(String[] args) {
		data2 dt = new data2();
		
		String url = "D:\\project\\web_example\\src\\main\\webapp\\data1.txt";
		try {
			dt.aaa(url);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			
			String url1 = "D:\\project\\web_example\\src\\main\\webapp\\data.txt";
			try {
				data2 dt2 = new data2();
				dt2.aaa(url1);
			}
			catch(Exception e) {
				System.out.println("완전오류 발생");
				System.out.println("강제종료");
				System.exit(0);
				
			}
		}

		
	}
}
class data2{
	FileReader fr = null;
	public void aaa(String filename) throws Exception, IOException{
		this.fr = new FileReader(filename);
		System.out.println(this.fr.read());
		this.fr.close();
	}
}

