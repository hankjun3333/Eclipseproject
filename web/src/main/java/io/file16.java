package io;

/*
  inputStream > inputStreamReader > BufferedReader (oK)
  InputStream > BufferedInputStream (oK)
  FileinputStream > BufferReader (x)
  FileWriter >WriterStream 있어야댐 >FileOutputStream (x)
  
  */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class file16 {
//InputStreamReader--바이너리를 아스키로 바꾸는 애임, OutputStreamWriter, BufferedReader, BufferedWritter
	public static void main(String[] args) {
		try {
			data13 d = new data13();
			d.abc();
		}
		catch(Exception e) {
			System.out.println();
		}

	}

}
class data13{
	//InputStreamReader : Stream을 Reader로 변환해주는 역할임 바이너리를 아스키로 변환!!!!!!!
	public void abc() throws Exception{
		String file = "D:\\project\\web\\src\\main\\webapp\\number.txt";
		InputStream is =new FileInputStream(file);
		InputStreamReader ir = new InputStreamReader(is); //reader는 stream 거쳐서 들어올 수 밖에 없다.!!!@!!
		//그 다음단계 BufferedReader출동
		BufferedReader br = new BufferedReader(ir);
		
		System.out.println(br.readLine());
		String data ;
		while((data = br.readLine())!=null) {
			System.out.println(data);
		}
		br.close();
		ir.close();
		is.close();
	}
}







