package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
inputStream > inputStreamReader > BufferedReader (oK)
InputStream > BufferedInputStream (oK)
FileinputStream > BufferReader (x)
FileWriter >WriterStream 있어야댐 >FileOutputStream (x)

*/
public class file16 {

	public static void main(String[] args) {
		try {
			data13 d = new data13();
			d.abc();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
class data13{
	public void abc() throws Exception{
		String data = "D:\\project\\web_example\\src\\main\\webapp\\data.txt";
		InputStream is = new FileInputStream(data);
		InputStreamReader ir = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(ir);
		System.out.println(br.readLine());
		String data11;
		while((data11 = br.readLine()) !=null) {
			System.out.println(data11);
		}
		br.close();
		ir.close();
		is.close();
	}
}