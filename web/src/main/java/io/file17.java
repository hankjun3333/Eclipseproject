package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//flush와 close의 차이점은?!!!??!!
public class file17 {

	public static void main(String[] args) {
		try {
			data14 d = new data14();
			d.abc();
		}
		catch(Exception e) {
			System.out.println("");
		}
	}

}
class data14{
	public void abc() throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String st = null;
		int n = Integer.parseInt(bf.readLine());
		int w =0;
		while(w<n) {
			st = new String(bf.readLine());
			int a = Integer.parseInt(st);
			int b = Integer.parseInt(st);
			int sum = a+b;
			bw.write(sum+"\n");
			bw.flush(); //해당 결과값 출력해주고 메모리 비워주고 하는 역할임!!
			//언제쓰냐??? BufferedWriter를 사용할 때만!! 사용합니다!! 
			w++;
		}
		
		bw.close();
	}
}
