package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

//Stream 으로 파일로드
public class file11 {

	public static void main(String[] args) {
		try {
			data8 d = new data8();
			d.abc();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
class data8{
	public void abc() throws Exception{ //인풋 스트림 뭐라고? 바이너리 파일 크기 확인할때 사용
		InputStream is = new FileInputStream("D:\\project\\web_example\\src\\main\\webapp\\datalist.txt");
		//System.out.println(is.available());
		byte temp[] = new byte[is.available()];
		int ea = is.read();
		String data = new String(temp,"UTF-8");
		//System.out.println(data); 데이터를 읽어들이기 까진함
		is.close();
		try {
			data9 z = new data9();
			z.zzz();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
class data9{
	public void zzz() throws Exception{
		String test = "연습입니다.";
		OutputStream os = new FileOutputStream("D:\\project\\web_example\\src\\main\\webapp\\datalist.txt");
		byte[] data = test.getBytes();
		os.write(data);
		os.flush();
		os.close();
	}
}








