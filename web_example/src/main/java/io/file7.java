package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;

//Buffered를 사용해보기!!
public class file7 {

	public static void main(String[] args) {
		try {
			data5 d = new data5();
			
			d.abc();
		}
		catch(Exception e) {
			
		}

	}

}
class data5 {
	FileReader fr = null;
	public void abc() throws Exception{
		this.fr = new FileReader("D:\\project\\web_example\\src\\main\\webapp\\number.txt");
		LineNumberReader li = new LineNumberReader(this.fr);
		//LineNumberReader == BufferedReader
		//System.out.println(li.readLine());
		
		ArrayList<String> ar = new ArrayList<String>();
		String line = "";
		while((line=li.readLine()) !=null) {
			ar.add(line);
			
		}
		System.out.println(ar);
		li.close();
		this.fr.close();
	}
}
