package io;

import java.io.FileReader;

// I/O 파일 데이터 읽어오기
public class file2 {

	public static void main(String[] args) {
		try {
			data1 d = new data1();
			d.aaa();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
class data1{
	public void aaa() throws Exception{
		FileReader fr = new FileReader("D:\\project\\web\\src\\main\\webapp\\data.txt");
		//파일을 읽어오는 인코더 형식
		//특히 문서 파일을 저장할때 인코딩 형식도 utf-8인지, Ansi인지 잘 확인하고 저장을 하자!!!!!!!!!!!!!
		System.out.println(fr.getEncoding()); //메모장이나 파일 그대로 저장하면 Ansi되는경우가잇음 실수 종종함
		
		//근데 골때리는거는 에디터가 읽는건 utf-8로 읽지만 데이터 찍을때 깨져버림 그러니까 저장할때 주의할 것
		while(true) { //무한 루프 loop //fr에 있는걸 다읽어올때까지
			int m = fr.read();
			
			//System.out.println(m); //글자 한글자당 byte 숫자 -1은 더이상 읽어올 내용이 없다.
			System.out.println((char)m); //String 인식 못하고 char로 해야 인식함
			//byte를 문자화 하여 변환해서 출력을 해야함
			
			//1024byte == 1Kbyte
			//1024Kbyte == 1Mbyte
			if(m == -1) {
				break;
			}
			
		}
		fr.close(); // 파일 열고나서 데이터 찍고 닫아줘야됨 계속 열려있는 상태임

	}
}