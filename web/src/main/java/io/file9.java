package io;

import java.io.*;
import org.apache.catalina.tribes.util.Arrays;

//FileReader, FileWriter, Buffered : 파일을 읽고,쓰기 (문서에 많이 사용) - 아스키
//Buffered , LineNumberReader : 메모리 영역
//Stream 이란 : 문서용도 가능, 이미지, 동영상, 오디오 일때 - (바이너리) -> 바이너리 기본 자료형이 숫자임 int형임 무조건 
//Stream은 전부다 숫자로 인식함 String 없음
//스트림 종류 FileinputStream, AudioInputStream, ObjectInputStream 다양한 것들이 있음

//InputStream, OutputStream : 대분류파트
//FileinputStream, AudioInputStream ,ObjectInputStream
public class file9 {

	public static void main(String[] args) {
		try {
			//InputStream is = System.in; // 스캐너 안쓰고 키보드로 쓰겠다는 것임 //키보드에 대한 정보 받음
			//int code = is.read(); //해당 키를 입력시 아스키코드로 인식하여 int로 변환			
			//System.out.println(code);
			
			String a = "123456789"; // 아스키 숫자로 표현이 됨
			//String a = "ABCDE";
			//String a = "홍길동";
			byte[] b = a.getBytes(); //문자를 바이트단위로 다 변환 getBytes()-언어패킷 -> 문자를 byte 배열로 만드는 것 
			System.out.println(Arrays.toString(b));
			OutputStream os = System.out;
			
			os.write(b,0,b.length); //0번째 부터 b 길이 만큼 (객체,배열시작번호0번,배열종료 끝번호)
			os.flush(); //범위 만큼만 flush 항상 비워나야함
			os.close();

		}
		catch(Exception e){
			System.out.println("코드 오류");
		}
	}

}
