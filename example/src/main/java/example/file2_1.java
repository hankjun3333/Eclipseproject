package example;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
/* Stream 버전으로 출력해보기 */
public class file2_1 {

	public static void main(String[] args) {
		try {
			notice d = new notice();
			d.abc();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}

class notice{
	//Reader -> Buffered -> ArrayList 하면 byte필요없음
	//Stream -> BufferedStream -> ArrayList -이것도 방법 byte 필요함
	//Stream -> BufferedStreamReader -> Reader ->ArrayList 이건좀 복잡 byte필요함
	
	public void abc() throws Exception{
		String url = "D:\\project\\example\\src\\main\\webapp\\buffer.txt";
		InputStream is = new FileInputStream(url);
		BufferedInputStream bs = new BufferedInputStream(is);
		//System.out.println(is.available());
		byte temp[] = new byte[is.available()];
		bs.read(temp);
		System.out.println(bs);
	}
	
}



