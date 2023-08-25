package io;

import java.io.FileReader;

public class file2 {

	public static void main(String[] args) {
		try {
			new data1().aaa();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
class data1{
	public void aaa() throws Exception{
		FileReader fr = new FileReader("D:\\project\\web_example\\src\\main\\webapp\\data.txt");
		System.out.println(fr.getEncoding()); //비록 Ansi라고 txt파일이 저장이 되더라도 이클립스 에디터에서 바로 utf-8로
		//변환시켜주니 헷갈릴수 있는데 데이터를 출력할때는 바로 깨져 버리는 현상이 생길 수 있으니 저장시 encoding 방식을 주의하자!!!!
		
		while(true) {
			int m = fr.read();
			//System.out.println(m); //그냥 int m 을 출력해버리면 아스키 byte로 인식해버림
			System.out.println((char)m); //단순 char는 1바이트 씩 밖에 출력을 못함
			if(m == -1) {
				break;
			}
		}
		fr.close(); //FileReader를 실행시키고 무조건 close 를 해줘야 됨 아님 메모리에 계속 상주함
		
		
	}
}



