package io;

import java.io.FileReader;

public class file1 {

	/*
	 	
	 I/O : 인풋 스트림 , 아웃풋 스트림
	 입력 스트림 : 프로그램으로 들어오는 데이터 ex ) 키보드 마우스
	 아웃풋스트림 : 프로그렘에 해당 데이터를 가져와서 출력하는 형태 모니터 프린터,데이터값
	 
	 	Stream : input, output - 사용자가 처리하는 데이터를 말함
	 	객체지향 io 네트워크 중요
	 	java.io 라는 라이브러릴 사용
	 	StreamAPI 라고 많이 부름
	 	io 에서는 무조건 예외처리가 기본임
	 */
	public static void main(String[] args) {
		
		abc a = new abc();
		
	}

}
/* 
 	\\두개 인 경우는 내컴퓨터에 있는 파일 경로
 	/ 한개 인 경우는 Server를 이욯새 파이릉ㄹ 사용할때 표현
 	 이미지 첨부 할 때 이미지 미리보기 기능에서 이런 기능을 사용한다!!!!!!!!!!! 
 	 
  */
class abc {
	public void aaa() throws Exception{
		FileReader fr = new FileReader("D:\\project\\web_example\\src\\main\\webapp\\data.txt");
		System.out.println(fr.read());
	}
}
