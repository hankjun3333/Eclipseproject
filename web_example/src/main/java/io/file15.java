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
			data12 d =new data12();
			d.abc();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
class data12{
	public void abc() throws Exception{
		String data = "D:\\project\\web_example\\src\\main\\webapp\\image.jpg";
		InputStream is = new FileInputStream("D:\\project\\web_example\\src\\main\\webapp\\image.jpg");
		BufferedInputStream bi = new BufferedInputStream(is);
		//System.out.println(bi.available());
		byte file[] = new byte[bi.available()];
		
		
		int total = bi.read(file);
		OutputStream os = new FileOutputStream("image2.jpg");
		
		if(total > 10000) {
			System.out.println("이미지 용량 초괴");
		}
		else {
			System.out.println("이미지 전송 완료");
		}
		os.write(file);
		os.flush();
		os.close();
		is.close();
	}
}