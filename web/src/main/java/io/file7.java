package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;

//Buffered를 사용해보기

public class file7 {

	public static void main(String[] args) {
		try {
			data5 d = new data5();
			d.abc();
		}
		catch(Exception e){
			System.out.println("파일 오류발생!!");
		}

	}

}
class data5{
	FileReader fr = null;
	//Buffered ,LineNumberReader : Temp (임시 저장소-메모리) 
	//효율적으로 파일을 메모리에 등록시킨 후 해당 메모리에 등록된 값을 출력하는 형태
	
	/*
	  해당 임시 저장된 내용을 사용시 휘발성으로 데이터는 자동 삭제 처리 됩니다. 한번쓰면 삭제
	  필수&&&조건문에 readLine() 써버리면 첫번째 데이터는 날라가버림&&&&
	  
	 */
	//LineNumberReader == bufferedReader
	public void abc() throws Exception{
		this.fr = new FileReader("D:\\project\\web\\src\\main\\webapp\\number.txt");
		LineNumberReader li = new LineNumberReader(this.fr);
		//System.out.println(li.readLine()); 
		//bufferedReader랑 거의 같다고 보면됨 둘다 휘발성임!! 실무에서 둘중 아무거나 써도 됨
		
		//System.out.println((char)this.fr.read()); // 1번 문자 맨앞 만 찍음 --힘들어짐
		//Buffered : 속도가 빠른대신 사용부분에 있어 변수로 받아서 처리 또는 배열로 만든 후 처리하는 것을 권장
		BufferedReader bf = new BufferedReader(this.fr);
		//System.out.println(bf.readLine()); //하나의 라인을 통째로 읽음 - 휘발성임 그다음꺼 찍음
		
		
		/*
		 * if(bf.readLine() != ""){ //데이터 하나 날라감 이렇게쓰면안됨
		 * 		System.out.println(bf.readLine());
		 * }
		 * 
		 * */
		
		//버퍼리더는 다 String
		//휘발성이기때문에 변수에 넘겨서 null이 아닐때까지 담아서 찍는 방법임
		ArrayList<String> al = new ArrayList<String>();
		String line = "";
		while((line = bf.readLine()) !=null) { 
			//System.out.println(bf.readLine());
			//System.out.println(line);
			al.add(line);
		
		}
		System.out.println(al);
		//다른곳에도 또 찍고 싶으면 ArrayList<String> 등록해서 사용하자
		//버퍼 열렸으니 닫아야 됨
		bf.close(); //IO는 무조건 열고 닫는거를 잘하자!!!!!!!!!!!!!
		this.fr.close(); //IO는 무조건 열고 닫는거를 잘하자!!!!!!!!!!!!!
		
	}
}
