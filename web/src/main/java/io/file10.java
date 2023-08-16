package io;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

//InputStream + OutputStream + flush 사용법 ( 메모리 )
//InputStream을 2개를 활성하 시 메모리 구조 상 신규 인스턴스를 생성하지 않을겨우
//연속으로 Stream을 활용하지 못합니다.

//파일첨부 기능 - 이미지가 많음 Stream을 알아야 됨!!!!!!!!!!!!!!!!!
public class file10 {

	public static void main(String[] args) throws Exception{
		InputStream in = System.in; //값을 집어넣는 곳
		OutputStream os = System.out; //여긴 출력하는 곳
		
		int a = in.read(); //입력된 사항을 읽어들여서 int형으로 a객체에 집어넣음
		os.write(a); //쓰기
		
		//os.flush();
		os.close(); //아웃풋스트림닫기
		in.close(); //인풋스트림닫기
		
		data7 aa = new data7();
		aa.abc();
	}

}
//flush를 통해서 메모리를 한번 비워줘야 된다는 뜻 -- 실수많이 하는 부분
//다른 데이터를 불러오기 위해서 flush를 써줘야 됨 메모리를 비워주는 것
//close는 항상 주의할 것
class data7{
	public void abc() {
		String data = "abcd";
		byte[]b = data.getBytes();
		System.out.println(Arrays.toString(b));
		OutputStream os = System.out;
		
		try {
			os.write(b,0,b.length);
			os.flush();
			os.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
//input스트림 위에 하나 만들면 flush 안쓰면 또 못쓴다는 뜻 메모리에 올라가있기때문
