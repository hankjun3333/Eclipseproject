package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class file8 {

	public static void main(String[] args) {
		try {
			data6 d = new data6();
			d.abc();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
class data6{
	FileReader fr = null;
	public void abc() throws Exception{
		//FileReader + BufferedReader 파일리더가 있어야 버퍼리도를 쓸수있다!!
		this.fr = new FileReader("D:\\project\\web_example\\src\\main\\webapp\\number.txt");
		
		BufferedReader bf = new BufferedReader(this.fr);
		ArrayList<String> arr = new ArrayList<String>();
		String line = "";
		while((line=bf.readLine()) != "") {
			arr.add(line);
			System.out.println(arr);
		}
		
	}
}
