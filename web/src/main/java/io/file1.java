package io;

import java.io.FileNotFoundException;
import java.io.FileReader;

/*
I/O : inputStream, OutputStream
입력 스트림 : 프로그램으로 들어오는 데이터 ex)키보드,마우스,SSD,HDD 정보를 저장하겠다. 
출력 스트림 : 프로그램에 해당 데이터를 가져와서 출력하는 형태 ex)모니터,프린터,데이터 값

Stream : input,output 밖에없음 - 사용자가 처리하는 데이터를 말함
객체지향,io,네트워크
java.io 라는 라이브러리를 사용 
java.util - 객체지향임
StreamAPI 라고 많이 부름
File, FileReader (일반) -> FileinputStream
FileWriter -> FileOutputStream
무조건 예외처리가 기본임 어디에서 문제가 발생햇을때 처리할껀가? 이게 예외처리임 
1. 메소드에 throws Exception을 사용 시 해당 메소드를 외부에서 호출시 무조권 
호출하는애는 try catch를 사용해야함

2. 해당 메소드 에서 try-catch를 사용할 경우 호출 받은메소드에서 throws를 사용 했을때
 또는 해당 메소드는 throws를 사용하지 않고, 메소드 자체에 호출받은 메소드 자체에 오류가 발생시 
 호출하는 메소드에서 예외처리 하는 상황
 
3. 예외처리하지 않을 경우 해당 프로세서는 종료하지 못하고 정지하는 형태가 발생함 - 먹통

1.외부클래스가 throws Exception하면 호출하는 애는 try catch로 받아야함
try는 정상작동상황
catch는 예외상황 여러번도 사용가능
catch(Exception e)
Exception 쓰고 메세지 찍어보면 무슨종류 예외처리나오는지 앎
그럼 그거 써주면 됨
catch(NumberFormatException e)
catch(NullPointerException e)
*/
public class file1 {

	public static void main(String[] args) throws Exception{
		//정상적으로 작동되는 영역
		//FileReader fr = new FileReader("");
		//파일없으면 catch 작동
		
		abc a = new abc();
		try {
			a.aaa();
			
			String nm = "10";
			Integer number = Integer.parseInt(nm);
			//FileNotFoundException 오류뜨는 이유가 필요 없어지니 지워라 이말
		}
		
		catch(FileNotFoundException fe) {
			System.out.println("해당 파일을 찾을 수 없습니다.");
		}
		
		catch(NumberFormatException nf) {
			System.out.println("숫자로 변환하지 못하였습니다.");
		}
		catch(Exception e) { // 여러번 사용 가능 // 맨 밑에 써야함
			//Exception 은 여러가지 오류사항 예외처리를 모두 확인할 수 있는
			//Default 클래스입니다.
			//System.out.println("해당 파일을 찾을 수 없음");
			//Exception 내용 알고싶으면
			System.out.println(e.getMessage());
			//Exception 종류를 알고싶으면
			System.out.println(e); //FileNotFoundException 이 오류가 나면 저 메세지를 띄워라 이런식으로 코딩
			
		}
		
	}
	
}
//외부클래스 aaa throw Exception
class abc{
	// \\역슬러쉬 두개일경우 : 자신의 PC에 있는 파일을 뜻함
	// /슬러쉬 한개일 경우 : Server를 이용하여 파일을 사용할때 -- 이걸로 많이쓰긴함
	//이미 첨부할때 이미지 미리보기 기능에 사용이 됨
	public void aaa() throws Exception{ //상대경로를 못읽음 //내 컴퓨터에 있는 위치로 써줘야됨 properties 
		FileReader fr = new FileReader("D:\\project\\web\\src\\main\\webapp\\data.txt");
		//data.txt 출력해보기
		System.out.println(fr.read()); //바이트단위로 떠버림 파일을 읽었는데 data.txt 데이터가 아무것도 없으면 -1이뜸
		//fr.read() : 데이터 크기를 읽어 들이는 메소드임 
		// -1 : 파일을 읽었으나 아무것도 없는 상태 , 그 외 나머지숫자는 파일에 내용이 있는 상태 
		
	}
}

