package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

//Stream 사용한 이미지 처리 방법
public class file13 {

	public static void main(String[] args) {
		try {
			data11 d = new data11();
			d.abc();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
class data11{
	public void abc() throws Exception{
		InputStream is =new FileInputStream("D:\\project\\web_example\\src\\main\\webapp\\image.jpg");
		System.out.println(is.available());
		OutputStream os = new FileOutputStream("image2.jpg");
		byte[] data = new byte[is.available()];
		int img = 0;
		while(true) {
			img = is.read(data);
			if(img == -1) {
				break;
			}
			else {
				os.write(data,0,img);
			}
		}
		os.flush();
		os.close();
		is.close();
		
	}
}

