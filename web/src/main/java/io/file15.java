package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

//BufferedInputStream, BufferedOutputStream
public class file15 {

	public static void main(String[] args) {
		try {
			data12 d = new data12();
			d.abc();
		}
		catch(Exception e) {
			System.out.println("파일 저장 코드 오류");
		}
	}
}
class data12{
	public void abc() throws Exception{
		/*
		 * InputStream outputStream Bufferead //스트림
		 */		String file = "D:\\project\\web\\src\\main\\webapp\\image.jpg";
		InputStream is = new FileInputStream(file);
		//FileInputStream fs = new FileInputStream(file); //두개 같은거임 아무렇게나 써도 됨
		BufferedInputStream bi = new BufferedInputStream(is);
		
		
		byte filesize[] = new byte[bi.available()];
		int total = bi.read(filesize); //int는 크기만 확인임 os.write에는(바이트단위)가 들어와야함
		if(total > 100000) {  
			System.out.println("이미지 제한 용량을 초과합니다.");
		}
		else {
			System.out.println("이미지 제한 용량 확인");
			OutputStream os = new FileOutputStream("image2.jpg");
			os.write(filesize);
			os.flush();
			os.close();
		}
		//System.out.println(Arrays.toString(filesize));
		
		//System.out.println(filesize);
		//System.out.println(fs.available());
	}
}
