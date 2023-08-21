package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

//Stream 으로 파일로드 하는 방식 + 쓰기
public class file11 {

	public static void main(String[] args) {
		try {
			data8 d = new data8();
			d.abc();
		}
		catch(Exception e) {
			System.out.println("소스코드 및 경로 실패!!");
		}
	}

}
class data8{
	public void abc() throws Exception{
		InputStream is = new FileInputStream("D:\\project\\web\\src\\main\\webapp\\datalist.txt"); 
		//바이너리로 읽었는지 파일 속성에서 확인
		//이미지 2mb 이상일경우 메세지 띄울용도
		//available() : 파일 전체 크기를 확인할때 사용 !!!!!!!
		//System.out.println(is.available()); //파일 바이트 크기 확인 용량체크가능 1번
		byte temp[] = new byte[is.available()]; //파일들 전체 모두 byte 배열로 적용
		//byte temp[] = new byte[1024*10];//용량을 제한한거임 10KB로 //1024*10 10KB //1024*1024*10 이건 10MB
		
		int ea = is.read(temp); /*파일 용량체크방법 2번 */ //파일을 읽어야함!!!!
		//read()가 필요한 이유는 해당 파일을 바이너리 형태로 읽기 때문에 read메소드로 파일 전체를 읽어들여야함
		//Ansi는 readLine()을씀
		//System.out.println(ea); /*파일크기*/
		
		String data = new String(temp,"UTF-8");
		System.out.println(data);
		is.close();
		try {
			data9 z = new data9();
			z.zzz();
		}
		catch(Exception e) {
			System.out.println("데이터 쓰기 오류 발생");
		}
	}
}
class data9{ //실행하는 클래스 위에 input 햇으니 여긴 아웃풋
	public void zzz() throws Exception{ 
		String test = "\n연습입니다.";
		OutputStream os = new FileOutputStream("D:\\project\\web\\src\\main\\webapp\\datalist.txt",true);
		//byte로 먼저 받아야됨
		byte[] data = test.getBytes(); //byte로 변환해서 들어가야 하므로 (바이너리) test에서 계행처리해야함
		os.write(data);
		os.flush();
		os.close();
	}
}






